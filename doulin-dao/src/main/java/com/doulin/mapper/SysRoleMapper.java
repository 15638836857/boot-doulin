package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysRole;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysRoleMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface SysRoleMapper extends BaseMapper<SysRole> {

    IPage<SysRole> findByQuery(IPage<SysRole> page, @Param("query") VQuery query);

    Integer selectTotalCount(Map<String, Object> map);

    List<SysRole> selectPageInfo(Map<String, Object> map);
}
