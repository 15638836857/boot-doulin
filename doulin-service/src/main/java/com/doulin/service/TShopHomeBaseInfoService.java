package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.vo.VQuery;

/**
 * TShopHomeBaseInfoService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TShopHomeBaseInfoService extends IService<TShopHomeBaseInfo> {

    IPage<TShopHomeBaseInfo> page(VQuery query);

}
