package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopMakeMeter;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
* TShopMakeMeterService
* @Author malinging
* @Date 2021-05-04
**/
public interface TShopMakeMeterService extends IService<TShopMakeMeter> {

    IPage<TShopMakeMeter> page(VQuery query);

    /**
     * 修改或添加
     * @param oper add/添加  edit/编辑
     * @param tShopMakeMeter
     */
    void saveAndUpdate(String oper,TShopMakeMeter tShopMakeMeter) throws Exception;

    TShopMakeMeter getInfoByShopHomeCodeAndTypeId(String shopHomeCode,String type);

    /**
     * 根据商家物料生成二维码
     * @return
     */
    void makeQrcodeByHomeCode(String oper,TShopMakeMeter tShopMakeMeter) throws Exception;

    /**
     *
     * @param map
     * @return
     */
    IPage<TShopMakeMeter> pageInfo(Map<String, Object> map);

    List<TShopMakeMeter> getPageList(Map<String, Object> map);
    Integer getCount(Map<String, Object> map);
}
