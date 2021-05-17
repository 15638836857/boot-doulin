package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopVipRecharge;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* TShopVipRechargeMapper
* @Author malinging
* @Date 2021-05-07
**/
@Mapper
public interface TShopVipRechargeMapper extends BaseMapper<TShopVipRecharge> {

    IPage<TShopVipRecharge> findByQuery(IPage<TShopVipRecharge> page, @Param("query") VQuery query);

    List<TShopVipRecharge> selectByVipBaseId(@Param("id")Integer id);

    List<TShopVipRecharge> selectVipStored(@Param("loginNo")String loginNo,
                                           @Param("name")String name,
                                           @Param("vipFlag")String vipFlag,
                                           @Param("validFlag")String validFlag,
                                           @Param("shopHomeCode")String shopHomeCode
                                   );

    void updateByIdsAndVipBaseId(@Param("vipBaseId")Integer vipBaseId);
    void updateVipByIds(@Param("ids")String[] ids,@Param("vipBaseId")Integer vipBaseId);
}
