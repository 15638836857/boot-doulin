package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopMakeMeter;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* TShopMakeMeterMapper
* @Author malinging
* @Date 2021-05-04
**/
@Mapper
public interface TShopMakeMeterMapper extends BaseMapper<TShopMakeMeter> {

    IPage<TShopMakeMeter> findByQuery(IPage<TShopMakeMeter> page, @Param("query") VQuery query);

    /**
     * 根据商家的编号 和 类型id 查询信息
     * @param shopHomeCode
     * @param type
     * @return
     */
    TShopMakeMeter selectInfoByShopHomeCodeAndTypeId(
            @Param("shopHomeCode")String shopHomeCode,@Param("type") String type);

    List<TShopMakeMeter> selectPageList(Map<String, Object> map);
    Integer selectPageCount(Map<String, Object> map);
}
