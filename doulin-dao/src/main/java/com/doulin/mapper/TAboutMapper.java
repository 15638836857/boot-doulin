package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TAbout;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* TAboutMapper
* @Author malinging
* @Date 2021-04-23
**/
@Mapper
public interface TAboutMapper extends BaseMapper<TAbout> {

    IPage<TAbout> findByQuery(IPage<TAbout> page, @Param("query") VQuery query);

    List<TAbout> selectPageList(Map<String, Object> map);
    Integer selectTotalCount(Map<String, Object> map);
}
