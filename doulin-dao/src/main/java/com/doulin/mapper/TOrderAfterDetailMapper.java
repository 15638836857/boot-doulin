package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TOrderAfterDetail;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

/**
 * TOrderAfterDetailMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TOrderAfterDetailMapper extends BaseMapper<TOrderAfterDetail> {

    IPage<TOrderAfterDetail> findByQuery(IPage<TOrderAfterDetail> page, @Param("query") VQuery query);

}
