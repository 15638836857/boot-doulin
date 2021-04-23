package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TAbout;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
* TAboutService
* @Author malinging
* @Date 2021-04-23
**/
public interface TAboutService extends IService<TAbout> {

    IPage<TAbout> page(VQuery query);

    TAbout geAboutById(String id);

    IPage<TAbout> pageInfo(Map<String, Object> vmap);

     List<TAbout> getPageList(Map<String, Object> map);
     Integer getTotalCount(Map<String, Object> map);
}
