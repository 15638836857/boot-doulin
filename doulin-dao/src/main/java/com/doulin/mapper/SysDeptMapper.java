package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysDept;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

/**
 * SysDeptMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface SysDeptMapper extends BaseMapper<SysDept> {

    IPage<SysDept> findByQuery(IPage<SysDept> page, @Param("query") VQuery query);

}
