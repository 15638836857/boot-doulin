package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.SysDictType;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
 * SysDictTypeMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    IPage<SysDictType> findByQuery(IPage<SysDictType> page, @Param("query") VQuery query);

    void deleteByids(@Param("ids")List<Integer> ids);

    SysDictType selectOneById(@Param("id")Integer id);
}
