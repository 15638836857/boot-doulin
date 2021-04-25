package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TCategory;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
 * TCategoryService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TCategoryService extends IService<TCategory> {

    IPage<TCategory> page(VQuery query);

    List<TCategory> getByShopGroupId(Integer shopGroupId);

    TCategory getOneByName(String name);
}
