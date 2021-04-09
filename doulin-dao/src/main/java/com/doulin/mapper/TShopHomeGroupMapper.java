package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TShopHomeGroup;
import com.doulin.entity.vo.VQuery;

/**
 * TShopHomeGroupMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface TShopHomeGroupMapper extends BaseMapper<TShopHomeGroup> {

    IPage<TShopHomeGroup> findByQuery(IPage<TShopHomeGroup> page, @Param("query") VQuery query);

}
