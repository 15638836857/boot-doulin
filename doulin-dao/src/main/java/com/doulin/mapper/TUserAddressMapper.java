package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.doulin.entity.TUserAddress;
import com.doulin.entity.vo.VQuery;

/**
 * TUserAddressMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TUserAddressMapper extends BaseMapper<TUserAddress> {

    IPage<TUserAddress> findByQuery(IPage<TUserAddress> page, @Param("query") VQuery query);

}
