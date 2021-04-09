package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysMenu;
import com.doulin.entity.vo.VQuery;

/**
 * SysMenuService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysMenuService extends IService<SysMenu> {

    IPage<SysMenu> page(VQuery query);

}
