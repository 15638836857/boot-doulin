package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopOrderCoupon;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* TShopOrderCouponMapper
* @Author malinging
* @Date 2021-05-13
**/
@Mapper
public interface TShopOrderCouponMapper extends BaseMapper<TShopOrderCoupon> {

    IPage<TShopOrderCoupon> findByQuery(IPage<TShopOrderCoupon> page, @Param("query") VQuery query);

    List<TShopOrderCoupon> selectInfoByShopHomeCode(@Param("shopHomeCode")String shopHomeCode,@Param("orderType")String orderType);

    /**
     * 关闭或开启
     * @param shopHomeCode
     * @param orderType
     */
    void openOrCloseBy(@Param("shopHomeCode")String shopHomeCode,@Param("orderType")String orderType,@Param("openFlag")String openFlag);
}
