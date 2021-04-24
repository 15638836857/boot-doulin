package com.doulin.service.impl;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.MyException;
import com.doulin.common.content.ErrorContent;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysUser;
import com.doulin.entity.SysUserRole;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysUserMapper;
import com.doulin.service.SysUserRoleService;
import com.doulin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * SysUserServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public IPage<SysUser> page(VQuery query) {
        IPage<SysUser> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return sysUserMapper.findByQuery(page, query);
    }

    @Override
    public SysUser getOneByLoginNo(String loginNo) {
        return sysUserMapper.selectInfoByLoginNo(loginNo);
    }

    @Override
    public void verificationSysUser(String oper,SysUser sysUser) throws MyException {
        //判断是否符合条件
        if(StrUtil.isEmpty(sysUser.getTelePhone()) || !PhoneUtil.isMobile(sysUser.getTelePhone())){
            throw new MyException(SysContent.ERROR_MOBILE);
        }else if(StrUtil.isEmpty(sysUser.getRealName())){
            throw new MyException(ErrorContent.ERROR_REAL_NAME);
        }else if(null==sysUser.getDeptId()){
            throw new MyException(ErrorContent.ERROR_DEPT);
        }

        if(SysContent.OPER_ADD.equals(oper)){
            if(null!=getOneByLoginNo(sysUser.getLoginNo())){
                throw new MyException(SysContent.ERROR_SYS_USER_EXSIS);
            }
        }else if(SysContent.OPER_EDIT.equals(oper)){
            if(null==sysUser.getId()){
                throw new MyException(SysContent.ERROR_ID);
            }else {
                SysUser use=getOneByLoginNo(sysUser.getLoginNo());
                if(!use.getId().equals(sysUser.getId())){
                    throw new MyException(SysContent.ERROR_USER);
                }
            }
        }else if(SysContent.OPER_DELETE.equals(oper)){
            if(null==sysUser.getId()){
                throw new MyException(SysContent.ERROR_ID);
            }
        }else{
            throw new MyException(SysContent.ERROR_OPER);
        }

    }
    @Transactional(rollbackFor = MyException.class)
    @Override
    public boolean addAndUpdate(String oper, SysUser sysUser) throws MyException {
        verificationSysUser(oper,sysUser);
        boolean flag=false;
        if(SysContent.OPER_ADD.equals(oper)){
            if(save(sysUser)){
                flag=true;
            }
        }else if(SysContent.OPER_EDIT.equals(oper)){
            if(getInfoByUserId(sysUser.getId()).get(0).getLoginNo().equals(SysContent.SYS_ADMIN)){
                throw  new MyException(SysContent.ADMIN_ERROR);
            }
            if(updateById(sysUser)){
                flag=true;
            }
        }
        String roleIds=sysUser.getRoleId();
        List<String> roles= Arrays.asList(roleIds.split(SysContent.EN_D));
        Set<SysUserRole> urlist=new HashSet<>();
        for (String rid : roles) {
            SysUserRole sur=new SysUserRole();
            sur.setRoleId(Integer.valueOf(rid));
            sur.setUserId(sysUser.getId());
            urlist.add(sur);
        }
        sysUserRoleService.remove(new QueryWrapper<SysUserRole>().eq(SysContent.USER_ID,sysUser.getId()));
        sysUserRoleService.saveBatch(urlist);


        return flag;
    }
    @Transactional(rollbackFor = MyException.class)
    @Override
    public boolean deleteByIds(List<Integer> ids,String userId) throws MyException {
        try {
            sysUserMapper.deleteByIds(ids,userId);
            return true;
        } catch (Exception e) {
           throw new MyException(e.getMessage());
        }
    }

    @Override
    public IPage<SysUser> pageInfo(Map<String, Object> map) {
        List<SysUser> datalist=sysUserMapper.selectPageData(map);
        Integer count=sysUserMapper.selectPageToTal(map);
        IPage<SysUser> page=new Page<>();
        page.setTotal(Long.valueOf(count.toString()));
        page.setCurrent(Long.valueOf(map.get(SysContent.PAGE).toString()));
        page.setSize(Long.valueOf(map.get(SysContent.ROWS).toString()));
        page.setRecords(datalist);
        return page;
    }

    @Override
    public List<SysUser> getInfoByUserId(Integer id) {

        return sysUserMapper.selectInfoById(id);
    }

}