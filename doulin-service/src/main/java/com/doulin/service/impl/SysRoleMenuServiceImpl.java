package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.entity.SysRoleMenu;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysRoleMenuMapper;
import com.doulin.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * SysRoleMenuServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Override
    public IPage<SysRoleMenu> page(VQuery query) {
        IPage<SysRoleMenu> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByIds(List<String> ids, String loginUserId) {
        baseMapper.deleteByIds(ids,loginUserId);
    }

    @Override
    public SysRoleMenu getOneById(Integer id) {

        return sysRoleMenuMapper.selectOneById(id);
    }

    @Override
    public List<SysRoleMenu> pageInfo(Map<String, Object> map) {
        return sysRoleMenuMapper.pageInfo(map);
    }

    @Override
    public Integer countByMap(Map<String, Object> map) {
        return sysRoleMenuMapper.countByMap(map);
    }

    @Override
    public List<Integer> getLoginUserMenu(String loginNo) {

        return null;
    }

    @Override
    public List<SysRoleMenu> getListByRoleId(String roleId) {

        return sysRoleMenuMapper.selectByRoleId(roleId);
    }

}