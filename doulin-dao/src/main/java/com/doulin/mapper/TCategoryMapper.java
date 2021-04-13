package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TCategory;
import com.doulin.entity.vo.VQuery;

/**
 * TCategoryMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TCategoryMapper extends BaseMapper<TCategory> {

    IPage<TCategory> findByQuery(IPage<TCategory> page, @Param("query") VQuery query);

}
