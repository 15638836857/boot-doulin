package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TOrderAfterDetail;
import com.doulin.entity.vo.VQuery;

/**
 * TOrderAfterDetailMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface TOrderAfterDetailMapper extends BaseMapper<TOrderAfterDetail> {

    IPage<TOrderAfterDetail> findByQuery(IPage<TOrderAfterDetail> page, @Param("query") VQuery query);

}
