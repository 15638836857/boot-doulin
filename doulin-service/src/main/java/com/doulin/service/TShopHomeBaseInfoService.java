package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.edo.Industrycate;
import com.doulin.entity.vo.VQuery;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    void updateInfoById(TShopHomeBaseInfo tsb,TShopHomeBaseInfo dbInfo,String oper) throws Exception;

    /**
     * 商家分页数据
     * @param map
     * @return
     */
    IPage<TShopHomeBaseInfo> getPageInfo(Map<String, Object> map);

    List<TShopHomeBaseInfo> getPageList(Map<String, Object> map);
     Integer getCount(Map<String, Object> map);

    TShopHomeBaseInfo getInfoByShopHomeCode(String shopHomeCode);

    List<Industrycate> getHyCodeList(Integer type,Integer treeType);

    /**
     * 获取商家信息  和关联的其它社区信息
     * @param loginNo
     * @return
     */
    TShopHomeBaseInfo getInfoAndAnyCommunityByLoginNo(String loginNo);
}
