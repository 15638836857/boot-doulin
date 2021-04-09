package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.SysDept;
import com.doulin.entity.vo.VQuery;

/**
 * SysDeptMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {

    IPage<SysDept> findByQuery(IPage<SysDept> page, @Param("query") VQuery query);

}
