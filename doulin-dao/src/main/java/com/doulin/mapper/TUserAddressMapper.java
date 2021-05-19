package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TUserAddress;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TUserAddressMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TUserAddressMapper extends BaseMapper<TUserAddress> {

    IPage<TUserAddress> findByQuery(IPage<TUserAddress> page, @Param("query") VQuery query);

    List<TUserAddress> selectByOpenId(@Param("openId")String openId);
}
