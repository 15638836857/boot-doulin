package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.vo.VQuery;

/**
 * TShopHomeBaseInfoMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TShopHomeBaseInfoMapper extends BaseMapper<TShopHomeBaseInfo> {

    IPage<TShopHomeBaseInfo> findByQuery(IPage<TShopHomeBaseInfo> page, @Param("query") VQuery query);

}
