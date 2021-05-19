package com.doulin.controller;

import com.doulin.WxCommons.authorize.WxBaseController;
import com.doulin.common.Base64Utils;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.common.encrymlbgo.KeyUtil;
import com.doulin.service.TCommunityService;
import com.doulin.service.TShopBannerService;
import com.doulin.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @className 微信 注册控制器
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/17 15:10
 * @Version 1.0
 */
@Api(tags = " 微信 注册控制器")
@RestController
@RequestMapping("wx/auth")
@CrossOrigin
@Slf4j
public class WxAuthController extends WxBaseController {

    private final static String API_TOP = "wx";
    @Value("${wxchat.login}")
    private String wxLoginUrl;

    @Autowired
    private TCommunityService communityService;
    @Autowired
    private TShopBannerService shopBannerService;
    @Autowired
    private TUserService userService;

    @ApiOperation(value = "登录凭证校验 用户信息", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"page\": 1,\n" +
            "        \"size\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"code\": \"用户code\"\n" +
            "    }\n" +
            "}")
    @PostMapping("auth")
    public Object login(@RequestBody Map<String, Object> map) {
        try {
            Map<String, Object> v = getVvalue(map);
            String code = v.get(SysContent.CODE_STR).toString();
            Object obj=getSmallOpenId(code, wxLoginUrl);
            return R.ok(obj);
        } catch (Exception e) {
            log.error(API_TOP + "/code********" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    @ApiOperation(value = "请求返回RSA的公钥", notes = "无")
    @PostMapping(value = "rsaKey")
    public Object getRsaKey() {
        return R.ok(Base64Utils.byte2Base64(KeyUtil.SERVER_PUBLIC_KEY.getBytes()).replaceAll("\r\n", ""));
    }
}
