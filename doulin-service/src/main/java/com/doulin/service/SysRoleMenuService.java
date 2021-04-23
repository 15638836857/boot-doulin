package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysRoleMenu;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
 * SysRoleMenuService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    IPage<SysRoleMenu> page(VQuery query);

    /**
     * 批量删除id对应的数据
     * @param ids 数据id
     * @param loginUserId 登录用户的id
     */
    void deleteByIds(List<String> ids, String loginUserId);

    /**
     * 根据id 获取菜单的关联的信息
     * @param id
     * @return
     */
    SysRoleMenu getOneById(Integer id);

    List<SysRoleMenu> pageInfo(Map<String, Object> vmap);

    Integer countByMap(Map<String, Object> vmap);

    /**
     * 获取登录用户的菜单
     * @param loginNo
     * @return
     */
    List<Integer> getLoginUserMenu(String loginNo);
}
