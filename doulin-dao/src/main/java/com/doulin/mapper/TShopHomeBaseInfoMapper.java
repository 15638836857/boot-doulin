package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.edo.Industrycate;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * TShopHomeBaseInfoMapper
 *
 * @Author malinging
 * @Date 2021-04-09
 **/

public interface TShopHomeBaseInfoMapper extends BaseMapper<TShopHomeBaseInfo> {

    IPage<TShopHomeBaseInfo> findByQuery(IPage<TShopHomeBaseInfo> page, @Param("query") VQuery query);

    TShopHomeBaseInfo selectByLoginNoOrShopHomeCode(@Param("loginNo")String loginNo,@Param("shopHomeCode")String shopHomeCode);

    /**
     * 分页数据
     * @param map
     * @return
     */
    List<TShopHomeBaseInfo> selectPageList(Map<String, Object> map);
    Integer selectCount(Map<String, Object> map);

    /**
     *
     * @param type "1' 行业类别    “2”/微信行业类别
     * @return
     */
    List<Industrycate> selectHyCodeList(@Param("type") Integer type);
}
