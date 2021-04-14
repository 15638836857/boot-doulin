package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.common.MyException;
import com.doulin.entity.SysRole;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
 * SysRoleService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysRoleService extends IService<SysRole> {

    IPage<SysRole> page(VQuery query);

    /**
     * 角色的添加和修改 非空验证
     * @param sysRole 系统角色
     * @throws MyException
     */
    void addAndUpdateParam(String oper,SysRole sysRole) throws MyException;

    /**
     * 根据角色id或名称获取 角色信息
     * @param id 角色id
     * @param roleName 角色名称
     * @return 角色对象
     */
    SysRole getOneByRoleNameOrId(Integer id,String roleName);

    /**
     * 分页数据
     * @param requestMap
     * @return
     */
    IPage<SysRole> pageInfo(Map<String, Object> requestMap);
    Integer getTotalCount(Map<String, Object> map);
    List<SysRole> getPageInfo(Map<String, Object> map);
}
