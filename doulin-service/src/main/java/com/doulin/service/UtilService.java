package com.doulin.service;

import com.doulin.entity.common.ResJson;
import com.doulin.entity.common.UserLoginReq;
import com.doulin.entity.common.UserRegisterReq;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
     * @param shopCode 商家编码
     * @param type  1/商家的店铺图   2/商家的商品图
     * @return
     * @throws Exception
     */
    List<String> uploadImg(MultipartFile[] file,String shopCode,String type) throws Exception;

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
}
