package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TOrderOrCarGoods;
import com.doulin.entity.vo.VQuery;

/**
 * TOrderOrCarGoodsService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TOrderOrCarGoodsService extends IService<TOrderOrCarGoods> {

    IPage<TOrderOrCarGoods> page(VQuery query);

}
