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
     * 根据商品名称查询商品
     * @param goodsName
     * @return
     */
    TGoods getInfoByName(String goodsName);
    /**
     * 获取商品分组
     * @param loginNo 商家登录号
     * @param cateid 分类id
     */
    List<TGoods> getGoodsGategory(String loginNo, String cateid);

    /**
     * 商品添加或修改
     * @param oper
     * @param tGoods
     */
    void addOrUpdate(String oper, TGoods tGoods) throws Exception;
}
