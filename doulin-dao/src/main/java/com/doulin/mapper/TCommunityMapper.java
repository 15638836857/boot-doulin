package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TCommunity;
import com.doulin.entity.common.SelectVo;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
* TCommunityMapper
* @Author malinging
* @Date 2021-04-15
**/
@Mapper
public interface TCommunityMapper extends BaseMapper<TCommunity> {

    IPage<TCommunity> findByQuery(IPage<TCommunity> page, @Param("query") VQuery query);
    @Select("SELECT MAX(t.community_code) as CODE from t_community t where t.del_flag=0")
    String selectLastCode();

    TCommunity selectOneById(@Param("id") Integer id);


    List<TCommunity> selectInfoByMap(Map<String,Object> map);

    List<TCommunity> pageInfo(Map<String, Object> map);

    Integer count(Map<String, Object> map);

    void deleteInfoBatchIds(@Param("loginUserId")String loginUserId,@Param("ids")List<String> ids);

    List<SelectVo> selectListInfo();
    List<SelectVo> selectTreeCommunity();

    /**
     * 根据省市区  "        \"type\": \"1/获取默认的社区  2/获取 指定周围社区的信息\",\n" +
     *             "        \"province\": \"省:河南\",\n" +
     *             "        \"city\": \"市：郑州\",\n" +
     *             "        \"area\": \"区域/县：金水区\"\n" +
     * @param map
     * @return
     */
    List<TCommunity> selectByProviceAndCityAndArea(Map<String, Object> map);

    List<TCommunity> selectShopSelect();
}
