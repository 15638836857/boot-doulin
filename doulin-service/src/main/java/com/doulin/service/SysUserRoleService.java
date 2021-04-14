package com.doulin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysUserRole;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
* SysUserRoleService
* @Author malinging
* @Date 2021-04-14
**/
public interface SysUserRoleService extends IService<SysUserRole> {

    IPage<SysUserRole> page(VQuery query);

    /**
     * 根据用户的id
     * @param userId
     * @return
     */
    List<SysUserRole> getListByUserId(Integer userId);
}
