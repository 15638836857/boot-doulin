package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TGoods;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
 * TGoodsService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TGoodsService extends IService<TGoods> {

    IPage<TGoods> page(VQuery query);

    /**
     * 根据商家编码商品名称 模糊查询商品 是否有类似存在
     * @param goodsName 商品名称
     * @param shopHomeCode 商家编码
     * @return
     */
    TGoods getInfoByName(String shopHomeCode,String goodsName);
    /**
     * 获取商品分组
     * @param loginNo 商家登录号
     * @param cateid 分类id
     */
    List<TGoods> getGoodsGategory(String loginNo, String cateid,String goodsLowerFrame);

    /**
     * 商品添加或修改
     * @param oper
     * @param tGoods
     */
    void addOrUpdate(String oper, TGoods tGoods) throws Exception;

    /**
     * 根据商品 的关键字搜索商品
     * @param loginNo
     * @param value
     * @param goodsLowerFrame
     * @return
     */
    List<TGoods> getGoodsByValue(String loginNo,String goodsLowerFrame, Integer categoryId,String value);
}
