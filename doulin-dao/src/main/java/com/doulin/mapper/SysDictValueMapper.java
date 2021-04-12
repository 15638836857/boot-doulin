package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.SysDictValue;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
 * SysDictValueMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface SysDictValueMapper extends BaseMapper<SysDictValue> {

    IPage<SysDictValue> findByQuery(IPage<SysDictValue> page, @Param("query") VQuery query);

    List<SysDictValue> selectByTypeCodes(@Param("typeCodes")List<String> typeCodes);

    List<SysDictValue> selectByTypeIds(@Param("typeIds")List<Integer> typeIds);
}
