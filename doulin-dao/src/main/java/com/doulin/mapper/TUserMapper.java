package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TUser;
import com.doulin.entity.vo.VQuery;

/**
 * TUserMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

    IPage<TUser> findByQuery(IPage<TUser> page, @Param("query") VQuery query);

}
