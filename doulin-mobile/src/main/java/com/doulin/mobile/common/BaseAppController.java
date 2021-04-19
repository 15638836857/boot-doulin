package com.doulin.mobile.common;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.doulin.common.RforApp;
import com.doulin.common.content.SysContent;
import com.doulin.common.encrymlbgo.HttpEncryptUtil;
import com.doulin.common.encrymlbgo.KeyUtil;
import com.doulin.entity.common.ResJson;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @className BaseAppController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/16 8:41
 * @Version 1.0
 */
@Slf4j
public class BaseAppController {
    private final  String DATA="json";
    protected R r;

    /**
     * 获取请求的参数
     * @param data
     * @return
     */
    protected Map<String,Object> getRequestParam(String  data) throws Exception {
        return  HttpEncryptUtil.serverDecrypt(data);
    }
    protected String  getRequestAk(String  data) throws Exception {
        String ak= HttpEncryptUtil.serverDecrypt(data).get(SysContent.AK).toString();
        return ak;
    }
    protected Map<String,Object>  getRequestCk(String  data) throws Exception {
        String ak= HttpEncryptUtil.serverDecrypt(data).get(SysContent.CT).toString();
        return (Map<String,Object>)JSONUtil.parseObj(ak);
    }
    //相应app加密
    protected String  responseApp(R t) {
        RforApp rforApp = new RforApp();
        rforApp.setResult(String.valueOf(r.getCode()));
        rforApp.setResultNote(t.getMsg());
        rforApp.setObject(t.getData());
        try {
            return HttpEncryptUtil.serverEncrypt(KeyUtil.AES_KEY, JSONUtil.toJsonPrettyStr(rforApp));
        } catch (Exception e) {
            log.error("返回到app异常" + e.getMessage());
        }
        return null; //初始化
//        r=null;
//        try {
//            return HttpEncryptUtil.serverEncrypt( KeyUtil.AES_KEY,JSONUtil.toJsonPrettyStr());
//        } catch (Exception e) {
//           log.error("返回到app异常"+e.getMessage());
//        }
//        return null;
    }
    //相应app加密
    protected String  responseAppRes(ResJson res) {
        try {
            return HttpEncryptUtil.serverEncrypt(KeyUtil.AES_KEY, JSONUtil.toJsonPrettyStr(res));
        } catch (Exception e) {
            log.error("返回到app异常" + e.getMessage());
        }
        return null; //初始化

    }


}
