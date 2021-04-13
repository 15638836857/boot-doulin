package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.SysRoleMenu;
import com.doulin.entity.vo.VQuery;

/**
 * SysRoleMenuMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    IPage<SysRoleMenu> findByQuery(IPage<SysRoleMenu> page, @Param("query") VQuery query);

}
