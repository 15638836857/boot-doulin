package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.SysUser;
import com.doulin.entity.vo.VQuery;

/**
 * SysUserMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    IPage<SysUser> findByQuery(IPage<SysUser> page, @Param("query") VQuery query);

}
