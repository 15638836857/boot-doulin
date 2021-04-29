package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysGoodsSku;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* SysGoodsSkuMapper
* @Author malinging
* @Date 2021-04-27
**/
@Mapper
public interface SysGoodsSkuMapper extends BaseMapper<SysGoodsSku> {

    IPage<SysGoodsSku> findByQuery(IPage<SysGoodsSku> page, @Param("query") VQuery query);

}
