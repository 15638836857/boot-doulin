package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.SysMenu;
import com.doulin.entity.vo.VQuery;

/**
 * SysMenuMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    IPage<SysMenu> findByQuery(IPage<SysMenu> page, @Param("query") VQuery query);

}
