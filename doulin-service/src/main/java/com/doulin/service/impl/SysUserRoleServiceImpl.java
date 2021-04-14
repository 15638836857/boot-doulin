package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.entity.SysUserRole;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysUserRoleMapper;
import com.doulin.service.SysUserRoleService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
* SysUserRoleServiceImpl
* @Author malinging
* @Date 2021-04-14
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Override
    public IPage<SysUserRole> page(VQuery query) {
        IPage<SysUserRole> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public List<SysUserRole> getListByUserId(Integer userId) {

        return userRoleMapper.selectListByUserId(userId);
    }

}