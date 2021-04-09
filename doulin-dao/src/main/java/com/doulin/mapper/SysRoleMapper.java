package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.SysRole;
import com.doulin.entity.vo.VQuery;

/**
 * SysRoleMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    IPage<SysRole> findByQuery(IPage<SysRole> page, @Param("query") VQuery query);

}
