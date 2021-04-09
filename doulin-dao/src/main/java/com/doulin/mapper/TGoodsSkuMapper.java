package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TGoodsSku;
import com.doulin.entity.vo.VQuery;

/**
 * TGoodsSkuMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface TGoodsSkuMapper extends BaseMapper<TGoodsSku> {

    IPage<TGoodsSku> findByQuery(IPage<TGoodsSku> page, @Param("query") VQuery query);

}
