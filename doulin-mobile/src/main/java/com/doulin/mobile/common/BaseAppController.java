package com.doulin.mobile.common;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.doulin.common.RforApp;
import com.doulin.common.content.SysContent;
import com.doulin.common.encrymlbgo.HttpEncryptUtil;
import com.doulin.common.encrymlbgo.KeyUtil;
import com.doulin.entity.common.ResJson;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
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
        log.info("参数加密之前"+data);
        log.info("参数加密之后"+HttpEncryptUtil.serverDecrypt(data));
        return  HttpEncryptUtil.serverDecrypt(data);
    }
    protected String  getRequestAk(String  data) throws Exception {
        String ak= HttpEncryptUtil.serverDecrypt(data).get(SysContent.AK).toString();
        return ak;
    }
    protected Map<String,Object>  getRequestCk(String  data) throws Exception {
        if(null==data){
            throw new Exception(SysContent.ERROR_PARAM);
        }
        String ak= HttpEncryptUtil.serverDecrypt(data).get(SysContent.CT).toString();
        return (Map<String,Object>)JSONUtil.parseObj(ak);
    }
    //相应app不加密
    protected Object  responseAppNoMi(R t) {
        RforApp r=new RforApp();
        r.setCode(SysContent.INTGER_0.toString());
        Map<String,Object> result=new HashMap<>();
        result.put("resultNote",t.getMsg());
        result.put("result",t.getCode());
        result.put("objects",t.getData()==""?new ResJson():t.getData());
        r.setMsg("请求成功");
        r.setData(result);
        return r; //初始化

    } //相应app加密
    protected String  responseApp(R t) {
        RforApp rforApp = new RforApp();
        rforApp.setCode(SysContent.INTGER_0.toString());
        rforApp.setMsg("请求成功");
        RforApp r = new RforApp();
        r.setCode(String.valueOf(t.getCode()));
        r.setData(t.getData());
        r.setMsg(t.getMsg());
        rforApp.setData(r);
        try {
            return HttpEncryptUtil.serverEncrypt(KeyUtil.AES_KEY, JSONUtil.toJsonPrettyStr(rforApp));
        } catch (Exception e) {
            log.error("返回到app异常" + e.getMessage());
        }
        return null; //初始化
    }
    //相应app加密
    protected String  responseAppRes(ResJson res) {
        try {
            RforApp r=new RforApp();
            r.setToken(res.getToken());
            r.setCode(SysContent.INTGER_0.toString());
            Map<String,Object> result=new HashMap<>();
            result.put("resultNote",res.getResultNote());
            result.put("result",res.getResult());
            result.put("objects",res.getObjects()==null?new ResJson():res.getObjects());
            result.put("zcState",res.getZcState());


            r.setMsg("请求成功");
            r.setData(result);
            String str=JSONUtil.toJsonStr(r);
            return HttpEncryptUtil.serverEncrypt(KeyUtil.AES_KEY, JSONUtil.toJsonPrettyStr(str ));
        } catch (Exception e) {
            log.error("返回到app异常" + e.getMessage());
        }
        return null; //初始化

    }


}
