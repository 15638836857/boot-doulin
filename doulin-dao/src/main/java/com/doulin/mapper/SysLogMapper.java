package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.SysLog;
import com.doulin.entity.vo.VQuery;

/**
 * SysLogMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

    IPage<SysLog> findByQuery(IPage<SysLog> page, @Param("query") VQuery query);

}
