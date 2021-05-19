package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TUserShopRelation;
import com.doulin.entity.vo.VQuery;

/**
* TUserShopRelationService
* @Author malinging
* @Date 2021-05-17
**/
public interface TUserShopRelationService extends IService<TUserShopRelation> {

    IPage<TUserShopRelation> page(VQuery query);

}
