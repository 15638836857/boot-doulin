package com.doulin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysUserRole;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* SysUserRoleMapper
* @Author malinging
* @Date 2021-04-14
**/
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    IPage<SysUserRole> findByQuery(IPage<SysUserRole> page, @Param("query") VQuery query);

    List<SysUserRole> selectListByUserId( @Param("userId")Integer userId);
}
