package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TUserShopRelation;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* TUserShopRelationMapper
* @Author malinging
* @Date 2021-05-17
**/
@Mapper
public interface TUserShopRelationMapper extends BaseMapper<TUserShopRelation> {

    IPage<TUserShopRelation> findByQuery(IPage<TUserShopRelation> page, @Param("query") VQuery query);

}
