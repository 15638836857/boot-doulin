package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TGoods;
import com.doulin.entity.vo.VQuery;

/**
 * TGoodsService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TGoodsService extends IService<TGoods> {

    IPage<TGoods> page(VQuery query);

}
