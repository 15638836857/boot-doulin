package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopToucanHdGoods;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* TShopToucanHdGoodsMapper
* @Author malinging
* @Date 2021-05-14
**/
@Mapper
public interface TShopToucanHdGoodsMapper extends BaseMapper<TShopToucanHdGoods> {

    IPage<TShopToucanHdGoods> findByQuery(IPage<TShopToucanHdGoods> page, @Param("query") VQuery query);

    List<TShopToucanHdGoods> selectByShopHomeCodeAndOrderType( @Param("shopHomeCode")String shopHomeCode, @Param("orderType")String orderType);
}
