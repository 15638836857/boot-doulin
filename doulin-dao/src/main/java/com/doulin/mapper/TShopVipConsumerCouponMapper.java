package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopVipConsumerCoupon;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* TShopVipConsumerCouponMapper
* @Author malinging
* @Date 2021-05-07
**/
@Mapper
public interface TShopVipConsumerCouponMapper extends BaseMapper<TShopVipConsumerCoupon> {

    IPage<TShopVipConsumerCoupon> findByQuery(IPage<TShopVipConsumerCoupon> page, @Param("query") VQuery query);

    List<TShopVipConsumerCoupon> selectByVipBaseId(@Param("id") Integer id);
    List<TShopVipConsumerCoupon> selectVipCoupons(@Param("loginNo") String loginNo,@Param("name")  String name);
    void updateVipByBaseId(@Param("vipBaseId")Integer vipBaseId);
    void updateByIdsAndVipBaseId(@Param("ids")String[] ids, @Param("vipBaseId")Integer vipBaseId);
}
