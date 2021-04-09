package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysUser;
import com.doulin.entity.vo.VQuery;

/**
 * SysUserService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysUserService extends IService<SysUser> {

    IPage<SysUser> page(VQuery query);

}
