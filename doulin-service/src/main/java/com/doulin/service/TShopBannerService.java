package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopBanner;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
* TShopBannerService
* @Author malinging
* @Date 2021-05-18
**/
public interface TShopBannerService extends IService<TShopBanner> {

    IPage<TShopBanner> page(VQuery query);

    IPage<TShopBanner> getPageInfo(Map<String, Object> pageMap);

    /**
     * 分页数据
     * @param map
     * @return
     */
    List<TShopBanner> getListPage(Map<String, Object> map);

    /**
     * 分页数据条数总数
     * @param map
     * @return
     */
    Integer getPageCount(Map<String, Object> map);

    /**
     * 根据社区编号获取banner
     * @param communityCode
     * @return
     */
    List<TShopBanner> getInfoByCommunityCode(String communityCode);
}
