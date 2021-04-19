package com.doulin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.ProvinceCityDistrict;
import com.doulin.entity.edo.Tree;
import com.doulin.entity.vo.VQuery;

/**
* ProvinceCityDistrictService
* @Author malinging
* @Date 2021-04-15
**/
public interface ProvinceCityDistrictService extends IService<ProvinceCityDistrict> {

    IPage<ProvinceCityDistrict> page(VQuery query);

    Tree<ProvinceCityDistrict> getTree();
}
