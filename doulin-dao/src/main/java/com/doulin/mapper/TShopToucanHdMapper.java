package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopToucanHd;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* TShopToucanHdMapper
* @Author malinging
* @Date 2021-05-14
**/
@Mapper
public interface TShopToucanHdMapper extends BaseMapper<TShopToucanHd> {

    IPage<TShopToucanHd> findByQuery(IPage<TShopToucanHd> page, @Param("query") VQuery query);

    TShopToucanHd selectByShopHomeCodeAndOrderType(@Param("shopHomeCode")String shopHomeCode, @Param("orderType")String orderType);
}
