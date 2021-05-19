package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TUserAddress;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
 * TUserAddressService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TUserAddressService extends IService<TUserAddress> {

    IPage<TUserAddress> page(VQuery query);

    List<TUserAddress> getByOpenId(String openId);
}
