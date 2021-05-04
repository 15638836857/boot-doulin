package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopGoodsCategory;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* TShopGoodsCategoryMapper
* @Author malinging
* @Date 2021-04-30
**/
@Mapper
public interface TShopGoodsCategoryMapper extends BaseMapper<TShopGoodsCategory> {

    IPage<TShopGoodsCategory> findByQuery(IPage<TShopGoodsCategory> page, @Param("query") VQuery query);

    TShopGoodsCategory selectOneByNameAndHomeCode(@Param("shopHomeCode")String shopHomeCode,@Param("name")  String name);

    void deleteByIdAndLoginId(@Param("id")Integer id, @Param("loginUserId") String loginUserId);

    List<TShopGoodsCategory> selectInfoByLoginNo(@Param("loginNo")String loginNo);

    /**
     * 商家入驻成功后 系统默认添加一笔 商品分类
     * @param shopHomeCode
     * @param shopGroupId
     */
    void insertDefaultCatagory(@Param("shopHomeCode")String shopHomeCode,@Param("shopGroupId")Integer shopGroupId );
}
