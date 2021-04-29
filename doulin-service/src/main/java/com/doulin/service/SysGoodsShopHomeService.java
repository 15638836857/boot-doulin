package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysGoodsShopHome;
import com.doulin.entity.vo.VQuery;

/**
* SysGoodsShopHomeService
* @Author malinging
* @Date 2021-04-27
**/
public interface SysGoodsShopHomeService extends IService<SysGoodsShopHome> {

    IPage<SysGoodsShopHome> page(VQuery query);

    /**
     * 根据商家的编号和系统商品的id 获取信息
     * @param shopHomeCode
     * @param sysGoodsId
     * @return
     */
    SysGoodsShopHome getInfoByShopHomeCodeAndSysGoodsId(String shopHomeCode, Integer sysGoodsId);
}
