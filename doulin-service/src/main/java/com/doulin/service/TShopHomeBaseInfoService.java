package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.vo.VQuery;

import javax.servlet.http.HttpServletRequest;

/**
 * TShopHomeBaseInfoService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface TShopHomeBaseInfoService extends IService<TShopHomeBaseInfo> {

    IPage<TShopHomeBaseInfo> page(VQuery query);

    /**
     * 商家根据登录注册号  系统默认手机号
     * @param loginNo
     * @return
     */
    TShopHomeBaseInfo getInfoByLoginNo(String loginNo);

    /**
     * 根据token获取商家用户信息
     * @param token
     * @return
     */
    TShopHomeBaseInfo getByToken(String token);

    void updateToken(Integer id, String token);

    /**
     * 根据登录手机号 修改 密码
     * @param tShopHomeBaseInfo loginNo 登录手机号
     * @param  tShopHomeBaseInfo password 密码
     */
    TShopHomeBaseInfo addPassByPhone(HttpServletRequest request,TShopHomeBaseInfo tShopHomeBaseInfo) throws Exception;
}
