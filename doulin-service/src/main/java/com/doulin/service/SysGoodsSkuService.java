package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysGoodsSku;
import com.doulin.entity.vo.VQuery;

/**
* SysGoodsSkuService
* @Author malinging
* @Date 2021-04-27
**/
public interface SysGoodsSkuService extends IService<SysGoodsSku> {

    IPage<SysGoodsSku> page(VQuery query);

}
