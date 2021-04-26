package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TCategory;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * TCategoryMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TCategoryMapper extends BaseMapper<TCategory> {

    IPage<TCategory> findByQuery(IPage<TCategory> page, @Param("query") VQuery query);

    List<TCategory> selectPageList(Map<String, Object> map);

    Integer selectTotal(Map<String, Object> map);

    void deleteByIdAndLoginId( @Param("id")Integer id, @Param("loginUserId") String loginUserId);

    TCategory selectOneByIdOrName( @Param("id")Integer id, @Param("name") String name);
}
