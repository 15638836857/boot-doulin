package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopToucanHdGoods;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
* TShopToucanHdGoodsService
* @Author malinging
* @Date 2021-05-14
**/
public interface TShopToucanHdGoodsService extends IService<TShopToucanHdGoods> {

    IPage<TShopToucanHdGoods> page(VQuery query);

    /**
     *
     * @param oper   添加/修改/删除/开启或关闭
     * @param tShopToucanHd
     * @param tcName 套餐名称
     * @param hdName 活动名称
     * @param openFlag 是否开启状态
     */

    void addOrUpdate(String oper,TShopToucanHdGoods tShopToucanHd,String hdName,String tcName,String openFlag) throws Exception;

    /**
     * 根据类型和编号获取 套餐 信息
     * @param shopHomeCode
     * @param orderType
     * @return
     */
    List<TShopToucanHdGoods> getInfoByShopHomeCode(String shopHomeCode, String orderType);
}
