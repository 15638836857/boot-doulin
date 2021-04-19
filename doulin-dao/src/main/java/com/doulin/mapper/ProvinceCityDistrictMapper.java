package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.ProvinceCityDistrict;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
* ProvinceCityDistrictMapper
* @Author malinging
* @Date 2021-04-15
**/
@Mapper
public interface ProvinceCityDistrictMapper extends BaseMapper<ProvinceCityDistrict> {

    IPage<ProvinceCityDistrict> findByQuery(IPage<ProvinceCityDistrict> page, @Param("query") VQuery query);

}
