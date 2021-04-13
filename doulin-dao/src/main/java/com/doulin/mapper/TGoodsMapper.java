package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TGoods;
import com.doulin.entity.vo.VQuery;

/**
 * TGoodsMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TGoodsMapper extends BaseMapper<TGoods> {

    IPage<TGoods> findByQuery(IPage<TGoods> page, @Param("query") VQuery query);

}
