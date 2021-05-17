package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopScoreCoupon;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* TShopScoreCouponMapper
* @Author malinging
* @Date 2021-05-13
**/
@Mapper
public interface TShopScoreCouponMapper extends BaseMapper<TShopScoreCoupon> {

    IPage<TShopScoreCoupon> findByQuery(IPage<TShopScoreCoupon> page, @Param("query") VQuery query);

    List<TShopScoreCoupon> selectByShopHomeCode(@Param("shopHomeCode")String shopHomeCode);

}
