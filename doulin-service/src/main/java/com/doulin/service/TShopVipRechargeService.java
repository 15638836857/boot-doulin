package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopVipRecharge;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
* TShopVipRechargeService
* @Author malinging
* @Date 2021-05-07
**/
public interface TShopVipRechargeService extends IService<TShopVipRecharge> {

    IPage<TShopVipRecharge> page(VQuery query);

    /**
     * 添加/修改/删除/开启
     * @param oper
     * @param tShopVipRecharge
     */
    void operData(String oper, TShopVipRecharge tShopVipRecharge) throws Exception;

    /**
     * 根据登录号获取 商家的储值信息
     * @param loginNo 登录号
     * @param name 规则名称
     * @param vipFlag 是否是vip  Y/N
     * @return name为 可以    list 为value
     */
    List<Map<String, Object>> getVipStored(String loginNo, String name, String vipFlag,String validFlag,String shopHomeCode);

    void updateByIdsAndVipBaseId(String[] ids, Integer vipBaseId) throws Exception;
}
