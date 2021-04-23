package com.doulin.mobile.common;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.doulin.common.Base64Utils;
import com.doulin.common.content.SysContent;
import com.doulin.common.encrymlbgo.HttpEncryptUtil;
import com.doulin.common.encrymlbgo.KeyUtil;
import com.doulin.entity.SysDictValue;
import com.doulin.entity.common.ResJson;
import com.doulin.entity.common.SelectVo;
import com.doulin.service.SysDictValueService;
import com.doulin.service.SysUserService;
import com.doulin.service.TShopHomeBaseInfoService;
import com.doulin.service.UtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @className CommonController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/16 9:39
 * @Version 1.0
 */
@Api(tags = "移动端公共接口类")
@CrossOrigin
@RestController
@RequestMapping("app/tool/api")
@Slf4j
public class CommonController extends BaseAppController {
    /**
     * 项目路径
     */
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private TShopHomeBaseInfoService shopHomeBaseInfoService;

    @Autowired
    private UtilService utilService;
    @Autowired
    private SysDictValueService dictValueService;


    /**
     * 新增
     */
    @ApiOperation(value = "根据手机号获取验证码", notes =
            " {\n" +
            "        \"codeType\": \"短信类型 0/老版本 1/绑定手机  2/找回密码   3/身份验证   4/修改密码  5/注册  6/登录\",\n" +
            "        \"phone\": \"手机号\"\n" +
            "    }\n")
    @PostMapping("/getSMSCode")
    public String getSMSCode(HttpServletRequest request, HttpServletResponse response, @RequestBody String data) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            Map<String, Object> map = getRequestCk(data);
            Object phoneStr = map.get(SysContent.PHONE);
            Object codeType = map.get(SysContent.CODE_TYPE);
            if (!PhoneUtil.isMobile(phoneStr.toString())) {
                r = R.failed("请输入正确的手机号");
            } else if (null == codeType) {
                r = R.failed("短信类型不能为空");
            } else {
                String ip = request.getRemoteAddr();
                utilService.shortMassge(phoneStr.toString(), codeType.toString(), ip);
                r = R.ok("验证码获取成功");
            }
        } catch (Exception e) {
            log.error("app/tool/getSMSCode" + e.getMessage());
            r = R.failed("获取验证码异常");
        }
        return responseApp(r);
    }
    @ApiOperation(value = "请求返回RSA的公钥", notes = "无")
    @PostMapping(value = "rsaKey")
    public Object getRsaKey() {
        return R.ok(Base64Utils.byte2Base64(KeyUtil.SERVER_PUBLIC_KEY.getBytes()).replaceAll("\r\n", ""));
    }

    /**
     * 2.14 上传图片返回路径(单多张都可)
     *
     * @param request
     * @return
     */
    @ApiOperation(value ="上传图片返回路径(单多张都可)" ,notes = "file:文件图片，type: 1/商家  2/用户")
    @PostMapping(value = "/addimgs",headers = "content-type=multipart/form-data")
    public Object addimgs(HttpServletRequest request, @RequestParam("file") MultipartFile[] file,String type) {
        try {
            List<String> fileUrl = utilService.uploadImg(file,type);
            return  responseAppNoMi(R.ok(fileUrl));
        } catch (Exception e) {
            log.error("请求处理异常"+e.getMessage() );
            return  responseAppNoMi(R.failed("请求处理异常"));
        }
    }
    @ApiOperation(value ="删除图片" ,notes = "{url:图片路径}")
    @PostMapping(value = "/deleteImg")
    public String addimgs(  String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String url = map.get(SysContent.URL_STR).toString();
            utilService.deleteImag(url);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("请求处理异常" + e.getMessage());
            return responseAppRes(ResJson.error("请求处理异常"));
        }
    }
    @ApiOperation(value ="根据字典code获取字典值" ,notes = "{\n" +
            "    \"code\": \"字典code\"\n" +
            "}")
    @PostMapping(value = "/getValueByCode")
    public String getValueByCode(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String code = map.get(SysContent.CODE_STR).toString();
            List<SysDictValue> list=dictValueService.getListByTypeCodeOrValue(code,null);
            return responseAppRes(ResJson.Ok(list));
        } catch (Exception e) {
            log.error("请求处理异常" + e.getMessage());
            return responseAppRes(ResJson.error("请求处理异常"));
        }
    }
    @ApiOperation(value ="读取证件信息" ,notes = "{\n" +
            "    \"zjType\": \"cardz/身份证正面  cardf/身份证反面  bankcard/银行卡  shopshiro/店面资质\",\n" +
            "    \"url\": \"图片路径 不带http和端口\"\n" +
            "}")
    @PostMapping(value = "/zjInfo")
    public String getZjInfo(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            return responseAppRes(utilService.getZjInfo(map));
        } catch (Exception e) {
            log.error("请求处理异常" + e.getMessage());
            return responseAppRes(ResJson.error("请求处理异常"+e.getMessage()));
        }
    }
    @ApiOperation(value ="获取银联号" ,notes = "{\n" +
            "    \"btype\": \"查询类型  1/获取 省、市，2/获取支行 和 联号\",\n" +
            "    \"province\": \"省\",\n" +
            "    \"city\": \"市\",\n" +
            "    \"bank\": \"银行\"\n" +
            "}")
    @PostMapping(value = "/getBankInfo")
    public String getBankInfo(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String btype=map.get(SysContent.BTYPE).toString();
            if(SysContent.INTGER_1.toString().equals(btype)) {
                return responseAppRes(utilService.getBankIfo(btype, null, null, null));
            }else{
                String province = map.get(SysContent.PROVICE).toString();
                String city = map.get(SysContent.CITY).toString();
                String bank = map.get(SysContent.BANK).toString();
                return responseAppRes(utilService.getBankIfo(btype, province, city, bank));
            }
        } catch (Exception e) {
            log.error("请求处理异常" + e.getMessage());
            List<SelectVo> list=new ArrayList<>();
            return responseAppRes(ResJson.error(list,"请求处理异常"+e.getMessage()));
        }
    }

     @ApiOperation(value ="获取协议" ,notes = "{\n" +
             "    \"id\": \"id\"\n" +
             "}")
    @PostMapping(value = "/about/displayContent")
    public String aboutDisplayContent(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String id=map.get(SysContent.ID_STR).toString();
            return responseAppRes(utilService.geAboutById(id));
        } catch (Exception e) {
            log.error("请求处理异常" + e.getMessage());
            return responseAppRes(ResJson.error("请求处理异常"+e.getMessage()));
        }
    }





    @ApiOperation(value = "app加密", notes = "无")
    @PostMapping(value = "jiami")
    public String  jiami(@RequestBody Map<String,Object> data)  {
        try {
            return  HttpEncryptUtil.appEncrypt(JSONUtil.toJsonStr(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
    @ApiOperation(value = "服务器解密", notes = "无")
    @PostMapping(value = "jiemi")
    public Object  jiemi(@RequestBody String data)  {
        try {
            String aesKeyStr = KeyUtil.AES_KEY;
            return  HttpEncryptUtil.appDecrypt(aesKeyStr,data);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
}







//    /**
//     * 请求返回RSA的公钥
//     *
//     * @return
//     */
//    @RequestMapping(value = "rsaKey")
//    @ResponseBody
//    public ResJson getRsaKey() {
//        ResJson res = new ResJson();
//        res.setObject(Base64Utils.byte2Base64(KeyUtil.SERVER_PUBLIC_KEY.getBytes()).replaceAll("\r\n", ""));
//        res.setMainShow(3);
//        res.setResult("0");
//        res.setResultNote("请求成功");
//        return res;
//    }

//    /**
//     * H5 获取验证码
//     *
//     * @param request
//     * @param response
//     * @return
//     */
//    public ResJson getSMSCode(HttpServletRequest request, HttpServletResponse response) {
//        ResJson res = new ResJson();
//        res.setResultNote("提交失败");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        String phone = request.getParameter("phone");
//        String codeType = request.getParameter("codeType");
//        if (StringUtils.isBlank(phone)) {
//            res.setResultNote("手机号不能为空");
//            return res;
//        }
//        if (StringUtils.isBlank(codeType)) {
//            res.setResultNote("短信类型不能为空");
//            return res;
//        }
//        try {
//            Tuser tuser=tuserService.getUserByPhone(phone);
//            if(null != tuser) {
//                res.setResultNote("该手机号已注册");
//            }else {
//                SMSVerificationCode.getRequest2(phone, codeType);
//                //CacheUtils.put("code" + phone, codeType, "123456");
//                String ip = request.getRemoteAddr();
//                Long dateTime = System.currentTimeMillis();// 获取服务器的时间
//                // rides储存
//                CacheUtils.put("dateTime" + ip, codeType, dateTime,1800);
//                CacheUtils.put("ip" + ip, codeType, ip,1800);
//                res.setResultNote("验证码获取成功");
//            }
//        } catch (Exception e) {
//            logger.error("请求处理异常：16406" );
//            logger.error(e.toString());
//        }
//        res.setResult("0");
//        return res;
//    }

