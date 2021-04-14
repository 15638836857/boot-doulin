package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysRoleMenu;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysRoleMenuMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    IPage<SysRoleMenu> findByQuery(IPage<SysRoleMenu> page, @Param("query") VQuery query);

    /**
     * 根据数据id删除
     * @param ids
     * @param loginUserId
     */
    void deleteByIds(List<String> ids, String loginUserId);

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    SysRoleMenu selectOneById(Integer id);

    List<SysRoleMenu> pageInfo(Map<String, Object> map);

    Integer countByMap(Map<String, Object> map);
}
