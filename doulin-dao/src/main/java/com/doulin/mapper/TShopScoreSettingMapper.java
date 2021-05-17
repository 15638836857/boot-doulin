package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopScoreSetting;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* TShopScoreSettingMapper
* @Author malinging
* @Date 2021-05-13
**/
@Mapper
public interface TShopScoreSettingMapper extends BaseMapper<TShopScoreSetting> {

    IPage<TShopScoreSetting> findByQuery(IPage<TShopScoreSetting> page, @Param("query") VQuery query);

    TShopScoreSetting selectByShopLoginNo(@Param("loginNo")String loginNo);

    TShopScoreSetting selectByShopHomeCode(@Param("shopHomeCode")String shopHomeCode);
}
