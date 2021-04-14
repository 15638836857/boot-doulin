package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysSalesman;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

/**
 * SysSalesmanMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface SysSalesmanMapper extends BaseMapper<SysSalesman> {

    IPage<SysSalesman> findByQuery(IPage<SysSalesman> page, @Param("query") VQuery query);

    String selectYwyCodeNum();

    SysSalesman selectOneByPhone(String phone);
}
