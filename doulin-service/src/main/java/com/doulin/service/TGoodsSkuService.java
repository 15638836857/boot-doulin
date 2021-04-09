package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TGoodsSku;
import com.doulin.entity.vo.VQuery;

/**
 * TGoodsSkuService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TGoodsSkuService extends IService<TGoodsSku> {

    IPage<TGoodsSku> page(VQuery query);

}
