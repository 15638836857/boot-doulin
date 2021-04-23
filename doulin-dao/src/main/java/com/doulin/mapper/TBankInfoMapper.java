package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TBankInfo;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* TBankInfoMapper
* @Author malinging
* @Date 2021-04-22
**/
@Mapper
public interface TBankInfoMapper extends BaseMapper<TBankInfo> {

    IPage<TBankInfo> findByQuery(IPage<TBankInfo> page, @Param("query") VQuery query);

    List<TBankInfo> selectInfoByType(@Param("type")Integer type
            ,@Param("province")String province,@Param("city")String city,@Param("bank")String bank);
}
