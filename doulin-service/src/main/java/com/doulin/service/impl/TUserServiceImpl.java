package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TUser;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TUserMapper;
import com.doulin.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

}