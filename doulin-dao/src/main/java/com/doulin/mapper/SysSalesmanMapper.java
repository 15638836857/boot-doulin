package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.SysSalesman;
import com.doulin.entity.vo.VQuery;

/**
 * SysSalesmanMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface SysSalesmanMapper extends BaseMapper<SysSalesman> {

    IPage<SysSalesman> findByQuery(IPage<SysSalesman> page, @Param("query") VQuery query);

}
