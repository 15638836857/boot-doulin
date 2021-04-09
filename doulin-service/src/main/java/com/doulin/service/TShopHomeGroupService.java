package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopHomeGroup;
import com.doulin.entity.vo.VQuery;

/**
 * TShopHomeGroupService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TShopHomeGroupService extends IService<TShopHomeGroup> {

    IPage<TShopHomeGroup> page(VQuery query);

}
