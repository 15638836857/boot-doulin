package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TCommunnityToken;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* TCommunnityTokenMapper
* @Author malinging
* @Date 2021-04-19
**/
@Mapper
public interface TCommunnityTokenMapper extends BaseMapper<TCommunnityToken> {

    IPage<TCommunnityToken> findByQuery(IPage<TCommunnityToken> page, @Param("query") VQuery query);

}
