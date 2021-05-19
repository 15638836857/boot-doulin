package com.doulin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.doulin.WxCommons.authorize.WxBaseController;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TCommunity;
import com.doulin.entity.TShopBanner;
import com.doulin.entity.TUser;
import com.doulin.service.TCommunityService;
import com.doulin.service.TShopBannerService;
import com.doulin.service.TUserService;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @className WxHomePageController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/19 14:13
 * @Version 1.0
 */
@Api(tags = " 微信 首页")
@RestController
@RequestMapping("wx/home/page")
@CrossOrigin
@Slf4j
public class WxHomePageController extends WxBaseController {
    private final static String API_TOP="wx/home/page";
    @Autowired
    private TCommunityService communityService;
    @Autowired
    private TShopBannerService shopBannerService;
    @Autowired
    private TUserService userService;

    @ApiOperation(value = "更新用户的基本信息", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"page\": 1,\n" +
            "        \"size\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"wxOperid\": \"微信的openId\",\n" +
            "        \"userName\": \"用户的名称\",\n" +
            "        \"nickName\": \"昵称\",\n" +
            "        \"telePhone\": \"手机号\",\n" +
            "        \"email\": \"邮箱\",\n" +
            "        \"userLogo\": \"用户的头像 ，建议使用base64\",\n" +
            "        \"sex\": \"用户性别 0女  1男\"\n" +
            "    }\n" +
            "}")
    @PostMapping("updateUser")
    public Object updateUser(@RequestBody Map<String, Object> map) {
        try {
            Map<String, Object> v = getVvalue(map);
            String openId=v.get("wxOperid").toString();
            TUser user= BeanUtil.toBean(v,TUser.class);
            userService.updateByOpenId(user);
            return R.ok();
        } catch (Exception e) {
            log.error(API_TOP + "/updateUser********" + e.getMessage());
            return R.error(e.getMessage());
        }
    }


    @ApiOperation(value = "根据用户的信息获取社区信息", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"page\": 1,\n" +
            "        \"size\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"type\": \"1/获取默认的社区  2/获取 指定周围社区的信息\",\n" +
            "        \"province\": \"省:河南\",\n" +
            "        \"city\": \"市：郑州\",\n" +
            "        \"area\": \"区域/县：金水区\",\n" +
            "        \"shopHomeCode\": \"商家编号\"\n" +
            "    }\n" +
            "}")
    @PostMapping("sqInfo")
    public Object getSqInfo(@RequestBody Map<String, Object> map) {
        try {
            Map<String, Object> v = getVvalue(map);
            String type = v.get(SysContent.TYPE_STR).toString();
            String province = v.get(SysContent.PROVICE).toString();
            String city = v.get(SysContent.CITY).toString();
            String area = v.get(SysContent.AREA).toString();
            String shopHomeCode = v.get(SysContent.SHOP_HOME_CODE).toString();
            Map<String, Object> paramMap = Maps.newHashMap();
            paramMap.put(SysContent.TYPE_STR, type);
            paramMap.put(SysContent.PROVICE, province);
            paramMap.put(SysContent.CITY, city);
            paramMap.put(SysContent.AREA, area);
            paramMap.put(SysContent.SHOP_HOME_CODE, shopHomeCode);
            List<TCommunity> list = communityService.getByProviceAndCityAndArea(paramMap);
            return R.ok(list);
        } catch (Exception e) {
            log.error(API_TOP + "/sqInfo********" + e.getMessage());
            return R.error(e.getMessage());
        }
    }
    @ApiOperation(value = "获取banner", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"page\": 1,\n" +
            "        \"size\": 10,\n" +
            "        \"token\": \"用户的token\"\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"communityCode\": \"社区编号\"\n" +
            "    }\n" +
            "}")
    @PostMapping("getBanner")
    public Object getBanner(@RequestBody Map<String, Object> map) {
        try {
            Map<String, Object> v = getVvalue(map);
            String communityCode = v.get(SysContent.COMMUNITYCODE).toString();
            List<TShopBanner> list = shopBannerService.getInfoByCommunityCode(communityCode);
            return R.ok(list);
        } catch (Exception e) {
            log.error(API_TOP + "/getBanner********" + e.getMessage());
            return R.error(e.getMessage());
        }
    }
}
