package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysGoods;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* SysGoodsMapper
* @Author malinging
* @Date 2021-04-27
**/
@Mapper
public interface SysGoodsMapper extends BaseMapper<SysGoods> {

    IPage<SysGoods> findByQuery(IPage<SysGoods> page, @Param("query") VQuery query);

    List<SysGoods> pageList(Map<String, Object> map);
    Integer pageCount(Map<String, Object> map);

    List<Map<String, Object>> getListByName(@Param("goodsName")String goodsName);
}
