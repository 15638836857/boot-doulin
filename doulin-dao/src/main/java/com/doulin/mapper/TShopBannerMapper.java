package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopBanner;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* TShopBannerMapper
* @Author malinging
* @Date 2021-05-18
**/
@Mapper
public interface TShopBannerMapper extends BaseMapper<TShopBanner> {

    IPage<TShopBanner> findByQuery(IPage<TShopBanner> page, @Param("query") VQuery query);

    List<TShopBanner> selectPageList(Map<String, Object> map);

    Integer selectPageCount(Map<String, Object> map);

    List<TShopBanner> selectInfoByCommunityCode(@Param("communityCode")String communityCode);
}
