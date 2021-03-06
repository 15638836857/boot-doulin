package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TUser;
import com.doulin.entity.TUserAddress;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TUserMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TUserMapper extends BaseMapper<TUser> {

    IPage<TUser> findByQuery(IPage<TUser> page, @Param("query") VQuery query);

    void updateToken(@Param("id")Integer id, @Param("token")String token);


}
