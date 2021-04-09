package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TUser;
import com.doulin.entity.vo.VQuery;

/**
 * TUserService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TUserService extends IService<TUser> {

    IPage<TUser> page(VQuery query);

}
