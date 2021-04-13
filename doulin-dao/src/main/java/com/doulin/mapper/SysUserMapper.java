package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysUser;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysUserMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface SysUserMapper extends BaseMapper<SysUser> {

    IPage<SysUser> findByQuery(IPage<SysUser> page, @Param("query") VQuery query);

    void deleteByIds(@Param("ids")List<Integer> ids);

    /**
     * 根据手机号或真实姓名查询信息
     * @param map
     * @return
     */
    List<SysUser> selectPageData(Map<String, Object> map);

    Integer selectPageToTal(Map<String, Object> map);
}
