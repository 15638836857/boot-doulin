package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TUser;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TUserMapper;
import com.doulin.service.RedisUtilService;
import com.doulin.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * TUserServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {


    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private RedisUtilService redisUtilService;

    @Override
    public IPage<TUser> page(VQuery query) {
        IPage<TUser> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public TUser getOneByLoginPhone(String loginPhone) {
        QueryWrapper<TUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(SysContent.DEL_FLAG,SysContent.INTGER_0);
        queryWrapper.eq(SysContent.TELE_PHONE,loginPhone);
        return getOne(queryWrapper);
    }

    @Override
    public void updateToken(Integer id, String token) {
        userMapper.updateToken(id,token);
    }

    @Override
    public TUser getByToken(String token) {
        QueryWrapper<TUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(SysContent.DEL_FLAG,SysContent.INTGER_0);
        queryWrapper.eq(SysContent.TOKEN_STR,token);
        return getOne(queryWrapper);
    }

    @Override
    public TUser getByOpenidAndType(String openid) {
       Object o= redisUtilService.hget(SysContent.USERINFO,openid);
       if(null!=o){
           return (TUser)o;
       }else {
           QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
           queryWrapper.eq(SysContent.DEL_FLAG, SysContent.INTGER_0);
           queryWrapper.eq(SysContent.WX_OPENID, openid);
           return getOne(queryWrapper);
       }
    }

    @Override
    public void updateByOpenId(TUser tUser) {
        TUser user= getByOpenidAndType(tUser.getWxOperid());
        if(null==user){
            tUser.setDelFlag(SysContent.INTGER_0);
            tUser.setAddDt(new Date());
            save(tUser);
            redisUtilService.hset(SysContent.USERINFO,tUser.getWxOperid(),user);
        }else{
            tUser.setId(user.getId());
            tUser.setEditDt(new Date());
            updateById(user);
            redisUtilService.hdel(SysContent.USERINFO,tUser.getWxOperid());
            redisUtilService.hset(SysContent.USERINFO,tUser.getWxOperid(),user);
        }
    }

}