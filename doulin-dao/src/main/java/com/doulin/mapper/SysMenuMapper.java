package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysMenu;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysMenuMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface SysMenuMapper extends BaseMapper<SysMenu> {

    IPage<SysMenu> findByQuery(IPage<SysMenu> page, @Param("query") VQuery query);

    List<String> listUserPerms(Long userId);

    SysMenu selectInfoById( @Param("id") Integer id);

    List<SysMenu> selectByPid(@Param("pid")Integer pid);
}
