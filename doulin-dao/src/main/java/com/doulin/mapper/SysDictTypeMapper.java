package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.SysDictType;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
 * SysDictTypeMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    IPage<SysDictType> findByQuery(IPage<SysDictType> page, @Param("query") VQuery query);

    void deleteByids(@Param("ids")List<Integer> ids);

    SysDictType selectOneById(@Param("id")Integer id);

    /**
     * 获取分页数据
     * @param map
     * @return
     */
    List<SysDictType> selectPageInfo(Map<String, Object> map);

    Integer countByMap(Map<String, Object> map);
}
