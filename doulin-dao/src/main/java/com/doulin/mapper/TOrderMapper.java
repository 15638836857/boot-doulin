package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TOrder;
import com.doulin.entity.vo.VQuery;

/**
 * TOrderMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TOrderMapper extends BaseMapper<TOrder> {

    IPage<TOrder> findByQuery(IPage<TOrder> page, @Param("query") VQuery query);

}
