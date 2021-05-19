package com.doulin.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;
import com.doulin.WxCommons.authorize.WxBaseController;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TFeedback;
import com.doulin.entity.TUserAddress;
import com.doulin.service.TFeedbackService;
import com.doulin.service.TUserAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @className WxOwerCenterController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/19 14:20
 * @Version 1.0
 */
@Api(tags = " 微信 首页")
@RestController
@RequestMapping("wx/ower/center")
@CrossOrigin
@Slf4j
public class WxOwerCenterController extends WxBaseController {
    private final static String API_TOP = "wx/ower/center";

    @Autowired
    private TUserAddressService tUserAddressService;

    @Autowired
    private TFeedbackService feedbackService;


    @ApiOperation(value = "更新用户的地址信息", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"page\": 1,\n" +
            "        \"size\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"oper\": \"add/edit/del\",\n" +
            "        \"id\": \"编辑删除必传\",\n" +
            "        \"userId\": \"用户id\",\n" +
            "        \"communityCode\": \"社区编码\",\n" +
            "        \"address\": \"地址\",\n" +
            "        \"defaultFlag\": \"是否默认  Y/N \",\n" +
            "        \"telePhone\":\"联系电话\"\n" +
            "    }\n" +
            "}")
    @PostMapping("address")
    public Object updateUserAddress(@RequestBody Map<String, Object> map) {
        Map<String, Object> v = getVvalue(map);
        String oper = v.get(SysContent.OPER_STR).toString();
        TUserAddress userAddress = BeanUtil.toBean(v, TUserAddress.class);
        try {
            userAddress.setDelFlag(SysContent.INTGER_0);
            if (SysContent.OPER_EDIT.equals(oper) || SysContent.OPER_DELETE.equals(oper)) {
                if (null == userAddress.getId()) {
                    throw new Exception(SysContent.ERROR_ID);
                }
                if (SysContent.OPER_DELETE.equals(oper)) {
                    userAddress.setDelFlag(SysContent.INTGER_1);
                }
            }
            if (SysContent.OPER_EDIT.equals(oper) || SysContent.OPER_ADD.equals(oper)) {
                if (null == userAddress.getUserId()) {
                    throw new Exception(SysContent.ERROR_PARAM);
                } else if (StrUtil.isEmpty(userAddress.getCommunityCode())) {
                    throw new Exception("社区不能为空");
                } else if (StrUtil.isEmpty(userAddress.getAddress())) {
                    throw new Exception("地址不能为空");
                } else if (!PhoneUtil.isMobile(userAddress.getTelePhone())) {
                    throw new Exception("手机号不正确");
                } else {
                    //如果没有设置默认 设置普通地址
                    if (StrUtil.isEmpty(userAddress.getDefaultFlag())) {
                        userAddress.setDefaultFlag(SysContent.N_STR);
                    }
                }
            }
            tUserAddressService.saveOrUpdate(userAddress);
            return R.ok();
        } catch (Exception e) {
            log.error(API_TOP + "address" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    @ApiOperation(value = "意见反馈", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"page\": 1,\n" +
            "        \"size\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"uid\": \"用户id\",\n" +
            "        \"nickname\": \"用户昵称\",\n" +
            "        \"phone\": \"反馈用户的电话\",\n" +
            "        \"content\": \"反馈的内容\",\n" +
            "        \"img1\": \"图url \",\n" +
            "        \"img2\": \"图url \",\n" +
            "        \"img3\": \"图url \",\n" +
            "        \"img4\": \"图url \",\n" +
            "        \"type\": \"0 用户端 1商家端\"\n" +
            "    }\n" +
            "}")
    @PostMapping("feedBack")
    public Object feedBack(@RequestBody Map<String,Object> map) {
        try {
             Map<String,Object> v=getVvalue(map);
             TFeedback feedback=BeanUtil.toBean(v,TFeedback.class);
             feedbackService.addInfo(feedback);
            return R.ok();
        } catch (Exception e) {
            log.error(API_TOP + "address****" + e.getMessage());
            return R.error(e.getMessage());
        }
    }
    @ApiOperation(value = "获取用户的地址", notes = "")
    @PostMapping("getAddress")
    public Object getAddress(HttpServletRequest request) {
        try {
            String token = request.getHeader(SysContent.TOKEN_STR);
            if (StrUtil.isEmpty(token)) {
                throw new Exception("用户有误");
            }
            String openId = token.substring(0, token.indexOf("&"));
            List<TUserAddress> list = tUserAddressService.getByOpenId(openId);
            return R.ok(list);
        } catch (Exception e) {
            log.error(API_TOP + "address****" + e.getMessage());
            return R.error(e.getMessage());
        }
    }


}
