package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TCar;
import com.doulin.entity.vo.VQuery;

/**
 * TCarMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface TCarMapper extends BaseMapper<TCar> {

    IPage<TCar> findByQuery(IPage<TCar> page, @Param("query") VQuery query);

}
