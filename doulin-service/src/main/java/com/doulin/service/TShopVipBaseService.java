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

    /**
     * 根据商家登录号获取 商家开通过的活动信息
     * @param loginNo 商家登录号
     * @param isOpen 是否开启
     * @return
     */
    List<Map<String, Object>> getActivity(String loginNo,String isOpen);
}
