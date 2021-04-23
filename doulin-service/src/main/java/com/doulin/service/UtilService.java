package com.doulin.service;

import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.common.ResJson;
import com.doulin.entity.common.UserLoginReq;
import com.doulin.entity.common.UserLoginRes;
import com.doulin.entity.common.UserRegisterReq;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 移动段和web段公用
 */
public interface UtilService {
    /**
     * 手机短信
     * @param phone
     * @param type
     */
    void shortMassge(String phone,String type,String ip) throws Exception;

    /**
     * 商家上传的图片
     * @param file 批量的图片
     * @param id 数据id
     * @param type  1/商家的店铺图   2/用户
     * @return
     * @throws Exception
     */
    List<String> uploadImg(MultipartFile[] file,String type) throws Exception;

    /**
     * 验证手机号 是否存在
     * @param type 1，商户   2/客户
     * @param registerReq
     * @throws Exception
     */
    void phoneFlag(String type, UserRegisterReq registerReq) throws Exception;

    /**
     * 1.2用户登录
     * @param request
     * @param req
     * @return
     */
     ResJson codec(HttpServletRequest request, UserLoginReq req) throws Exception;

    /**
     * 获取验证码
     * @param phone 手机号
     * @param codeType 短信类型
     * @return
     */
     String getRandomCodesByPhone(String phone,String codeType);

     String getShopLoginSucessToken(HttpServletRequest request, UserLoginReq req, UserLoginRes res , TShopHomeBaseInfo c) throws Exception;

    /**
     * 根据图片路径删除
     * @param url
     */
    void deleteImag(String url) throws Exception;

    /**
     * 读取证件
     * @param map
     * @return
     */
    ResJson getZjInfo(Map<String, Object> map);

    /**
     * 获取
     * @param btype  1/获取省，2/获取市，3/获取银行 ，4/获取支行 ，5/获取银联号
     * @return
     */
    ResJson getBankIfo(String btype,String province,String city,String bank) throws Exception;

    /**
     * 关于我们
     * @param id
     * @return
     */
    ResJson geAboutById(String id);
}
