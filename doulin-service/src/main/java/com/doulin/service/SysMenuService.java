package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.common.MyException;
import com.doulin.entity.SysMenu;
import com.doulin.entity.edo.Tree;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Set;

/**
 * SysMenuService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysMenuService extends IService<SysMenu> {

    IPage<SysMenu> page(VQuery query);

    Set<String> listPerms(Long userId);

    /**
     * 添加或编辑参数验证
     * @param sysMenu 系统菜单
     * @throws MyException 抛出的异常
     */
    void addAndUpdateParam(String oper,SysMenu sysMenu) throws MyException;

    /**
     * 根据菜单id或名称获取菜单的信息
     * @param id 菜单id
     * @param menuName 菜单名称
     * @param type 菜单类型
     * @return
     */
    SysMenu getOneByMenuNameOrId(Integer id,String menuName,Integer type);

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    SysMenu getInfoById(Integer id);

    /**
     * 获取下一级信息
     * @param pid 父级id
     * @return
     */
    List<SysMenu> getListByPid(Integer pid);



    Tree<SysMenu> getTree();
}
