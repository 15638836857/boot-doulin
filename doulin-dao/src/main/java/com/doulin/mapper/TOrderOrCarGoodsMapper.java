package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TOrderOrCarGoods;
import com.doulin.entity.vo.VQuery;

/**
 * TOrderOrCarGoodsMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TOrderOrCarGoodsMapper extends BaseMapper<TOrderOrCarGoods> {

    IPage<TOrderOrCarGoods> findByQuery(IPage<TOrderOrCarGoods> page, @Param("query") VQuery query);

}
