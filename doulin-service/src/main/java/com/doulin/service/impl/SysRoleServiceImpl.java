package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.MyException;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysRole;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysRoleMapper;
import com.doulin.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 系统角色业务实现类
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Override
    public IPage<SysRole> page(VQuery query) {
        IPage<SysRole> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void addAndUpdateParam(String oper,SysRole sysRole) throws MyException {
        if(StrUtil.isEmpty(sysRole.getRoleName())){
            throw new MyException(SysContent.ERROR_ROLE_NAME_EMPTY);
        }
        if(SysContent.OPER_ADD.equals(oper)){
          if(null!=getOneByRoleNameOrId(null,sysRole.getRoleName())){
              throw new MyException(SysContent.ERROR_EXISIS);
          }
        }else if(SysContent.OPER_EDIT.equals(oper)){
            SysRole sr=getOneByRoleNameOrId(null,sysRole.getRoleName());
            if(null!=sr && !sr.getId().equals(sysRole.getId())){
                throw new MyException(SysContent.ERROR_EXISIS);
            }
        }
    }

    @Override
    public SysRole getOneByRoleNameOrId(Integer id, String roleName) {
        QueryWrapper<SysRole> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(SysContent.DEL_FLAG,SysContent.INTGER_0);
        if(null!=id) {
            queryWrapper.eq(SysContent.ID_STR, id);
        }
        if(StrUtil.isNotEmpty(roleName)) {
            queryWrapper.eq(SysContent.ROLE_NAME, roleName);
        }
        return getOne(queryWrapper);
    }

    @Override
    public IPage<SysRole> pageInfo(Map<String, Object> map) {
        IPage<SysRole> page=new Page<>();
        List<SysRole> list=getPageInfo(map);
        Integer count=getTotalCount(map);
        page.setRecords(list);
        page.setTotal(Long.valueOf(count));
        page.setSize(Long.valueOf(map.get(SysContent.ROWS).toString()));
        page.setCurrent(Long.valueOf(map.get(SysContent.PAGE).toString()));
        return page;
    }
    @Override
    public Integer getTotalCount(Map<String, Object> map) {
        return sysRoleMapper.selectTotalCount(map);
    }
    @Override
    public List<SysRole> getPageInfo(Map<String, Object> map) {
        return sysRoleMapper.selectPageInfo(map);
    }

}