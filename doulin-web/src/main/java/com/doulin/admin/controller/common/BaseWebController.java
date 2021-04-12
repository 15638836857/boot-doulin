package com.doulin.admin.controller.common;

import cn.hutool.core.util.StrUtil;
import com.doulin.common.MyException;
import com.doulin.common.content.SysContent;

import java.util.Map;

/**
 * @className BaseController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/12 9:48
 * @Version 1.0
 */
public class BaseWebController {
    /**
     * 获取 s的值
     * @param requestMap
     * @return
     */
    public Map<String,Object> getSvalue(Map<String,Object> requestMap){
        return (Map<String, Object>) requestMap.get(SysContent.S_STR);
    }
    /**
     * 获取 v 的值
     * @param requestMap
     * @return
     */
    public Map<String,Object> getVvalue(Map<String,Object> requestMap){
        return (Map<String, Object>) requestMap.get(SysContent.V_STR);
    }

    /**
     * 获取登录用户userId
     * @param requestMap
     * @return
     */
    public String getLoginUserId(Map<String,Object> requestMap) throws MyException {
        if(null==getSvalue(requestMap).get(SysContent.LOGIN_USERID)){
           throw new MyException(SysContent.ERROR_LOGIN_USERID);
        }
        return getSvalue(requestMap).get(SysContent.LOGIN_USERID).toString();
    }
}
