package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysRole;
import com.doulin.entity.vo.VQuery;

/**
 * SysRoleService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysRoleService extends IService<SysRole> {

    IPage<SysRole> page(VQuery query);

}
