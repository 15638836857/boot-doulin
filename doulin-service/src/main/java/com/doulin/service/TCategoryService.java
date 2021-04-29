package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TCategory;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
 * TCategoryService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TCategoryService extends IService<TCategory> {

    IPage<TCategory> page(VQuery query);

    List<TCategory> getByShopGroupId(Integer shopGroupId);

    TCategory getOneByNameOrId(Integer id,String name);

    /**
     * 分页数据
     * @param pageParm name 商品名称
     * @param pageParm shopGroupId 商家分类id
     * @return
     */
    IPage<TCategory> pageInfo(Map<String, Object> pageParm);

    List<TCategory> getPageList(Map<String, Object> map);
    Integer getPageTotal(Map<String, Object> map);

    void deleteById(Integer  id, String loginUserId);

    /**
     * 根据商家登录号
     * @param loginNo 商家登录号
     * @return
     */
    List<TCategory> getListByLoginNo(String loginNo);
}
