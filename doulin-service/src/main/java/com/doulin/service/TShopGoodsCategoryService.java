package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopGoodsCategory;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
* TShopGoodsCategoryService
* @Author malinging
* @Date 2021-04-30
**/
public interface TShopGoodsCategoryService extends IService<TShopGoodsCategory> {

    IPage<TShopGoodsCategory> page(VQuery query);


    TShopGoodsCategory getOneByNameAndHomeCode(String shopHomeCode, String name);

    void deleteById(Integer id, String loginNo);

    List<TShopGoodsCategory> getListByLoginNo(String loginNo);

    /**
     * 商家入驻成功后 系统默认添加一笔 商品分类
     * @param shopHomeCode 商家编号
     * @param shopGroupId 商家分类id
     */
    void insertDefaultCatagory(String shopHomeCode,Integer shopGroupId );
}
