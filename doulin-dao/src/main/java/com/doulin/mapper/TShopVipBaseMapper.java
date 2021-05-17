package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopVipBase;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* TShopVipBaseMapper
* @Author malinging
* @Date 2021-05-07
**/
@Mapper
public interface TShopVipBaseMapper extends BaseMapper<TShopVipBase> {

    IPage<TShopVipBase> findByQuery(IPage<TShopVipBase> page, @Param("query") VQuery query);

    TShopVipBase selectInfoByLoginNo(@Param("loginNo") String loginNo);

    Map<String, Object> selectActivity(@Param("loginNo")String loginNo);
}
