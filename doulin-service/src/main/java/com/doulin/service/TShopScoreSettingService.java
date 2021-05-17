package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopScoreSetting;
import com.doulin.entity.vo.VQuery;

/**
* TShopScoreSettingService
* @Author malinging
* @Date 2021-05-13
**/
public interface TShopScoreSettingService extends IService<TShopScoreSetting> {

    IPage<TShopScoreSetting> page(VQuery query);

    /**
     * 添加或者编辑
     * @param oper
     * @param tShopScoreCoupon
     */
    void saveAndUpdate(String oper, TShopScoreSetting tShopScoreCoupon) throws Exception;

    /**
     * 获取商家给普通用户 设置积分的规则
     * @param loginNo
     * @return
     */
    TShopScoreSetting getByShopLoginNo(String loginNo);

    TShopScoreSetting getByShopHomeCode(String shopHomeCode);
}
