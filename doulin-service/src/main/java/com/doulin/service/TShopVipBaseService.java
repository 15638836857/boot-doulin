package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopVipBase;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
* TShopVipBaseService
* @Author malinging
* @Date 2021-05-07
**/
public interface TShopVipBaseService extends IService<TShopVipBase> {

    IPage<TShopVipBase> page(VQuery query);

    /**
     * 获取会员权益
     * @param loginNo
     * @return
     */
    TShopVipBase getInfoByLoginNo(String loginNo);

    void addVipInfo(String oper,TShopVipBase tShopVipBase) throws Exception;

    List<Map<String, Object>> getActivity(String loginNo,String isOpen);
}
