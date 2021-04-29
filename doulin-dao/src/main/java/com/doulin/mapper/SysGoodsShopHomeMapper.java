package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysGoodsShopHome;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* SysGoodsShopHomeMapper
* @Author malinging
* @Date 2021-04-27
**/
@Mapper
public interface SysGoodsShopHomeMapper extends BaseMapper<SysGoodsShopHome> {

    IPage<SysGoodsShopHome> findByQuery(IPage<SysGoodsShopHome> page, @Param("query") VQuery query);

}
