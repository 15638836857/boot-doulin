package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysRoleMenu;
import com.doulin.entity.vo.VQuery;

/**
 * SysRoleMenuService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    IPage<SysRoleMenu> page(VQuery query);

}
