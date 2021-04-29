package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysGoods;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
* SysGoodsService
* @Author malinging
* @Date 2021-04-27
**/
public interface SysGoodsService extends IService<SysGoods> {

    IPage<SysGoods> page(VQuery query);

    IPage<SysGoods> getPageInfo(Map<String, Object> map);
     List<SysGoods> pageList(Map<String, Object> map);
     Integer pageCount(Map<String, Object> map);

    void saveAndUpdate(String operAdd, SysGoods sysGoods) throws Exception;

    void deleteById(Integer id);

    List<Map<String, Object>> getListByName(String goodsName);
}
