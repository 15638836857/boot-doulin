package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopHomeGroup;
import com.doulin.entity.common.SelectVo;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
 * TShopHomeGroupService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TShopHomeGroupService extends IService<TShopHomeGroup> {

    IPage<TShopHomeGroup> page(VQuery query);

    void removeBatchByIds(String loginUserId, List<String> ids);

    IPage<TShopHomeGroup> pageInfo(Map<String, Object> map);

    TShopHomeGroup getOneByName(String groupName);

    /**
     * 根据id或商品code获取信息
     * @param id
     * @param shopCode
     * @return
     */
    TShopHomeGroup getInfoByIdOrShopCode(Integer id,String shopCode);

    /**
     * 商家分类下拉框
     * @return
     */
    List<SelectVo> getSelectInfo();
}
