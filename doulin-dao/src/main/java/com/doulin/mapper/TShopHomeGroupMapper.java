package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopHomeGroup;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * TShopHomeGroupMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TShopHomeGroupMapper extends BaseMapper<TShopHomeGroup> {

    IPage<TShopHomeGroup> findByQuery(IPage<TShopHomeGroup> page, @Param("query") VQuery query);

    void deleteInfoBatchIds(@Param("loginUserId")String loginUserId, @Param("ids") List<String> ids);

    List<TShopHomeGroup> pageInfo(Map<String, Object> map);

    Integer count(Map<String, Object> map);
}
