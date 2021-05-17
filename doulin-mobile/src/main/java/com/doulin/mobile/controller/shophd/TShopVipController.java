package com.doulin.mobile.controller.shophd;

import cn.hutool.core.bean.BeanUtil;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopVipBase;
import com.doulin.entity.TShopVipConsumerCoupon;
import com.doulin.entity.TShopVipRecharge;
import com.doulin.entity.common.ResJson;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.TShopVipBaseService;
import com.doulin.service.TShopVipConsumerCouponService;
import com.doulin.service.TShopVipRechargeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @className TShopVipController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/7 11:51
 * @Version 1.0
 */
@Api(tags = "App商家会员权益中心")
@RestController
@CrossOrigin
@RequestMapping("app/vip")
@Slf4j
public class TShopVipController extends BaseAppController {
    @Autowired
    private TShopVipBaseService tShopVipBaseService;
    @Autowired
    private TShopVipRechargeService shopVipRechargeService;
    @Autowired
    private TShopVipConsumerCouponService shopVipConsumerCouponService;


    @ApiOperation(value = "商家设置储值 普通人员 储值", notes =
            "商家设置储值 普通人员 储值添加json={\n" +
            "    \"oper\": \"操作方式  add/添加  \",\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"shopHomeCode\": \"商家编码\",\n" +
            "    \"name\": \"规则名称\",\n" +
            "    \"rechargeMoney\": \"充值多少\",\n" +
            "    \"toMoney\": \"送多少钱\",\n" +
            "    \"openFlag\": \"活动是否开启 Y/N 默认不开启\",\n" +
            "    \"validFlag\": \"活动是否开启后是否生效 Y/N 默认不生效\",\n" +
            "    \"vipFlag\": \"是vip还是普通会员使用  Y/vip  N/普通会员\"\n" +
            "}\n"+ "商家设置储值 普通人员 储值编辑json={\n" +
            "    \"oper\": \"操作方式  edit/编辑   \",\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"id\": \"数据id\",\n" +
            "    \"rechargeMoney\": \"充值多少\",\n" +
            "    \"toMoney\": \"送多少钱\",\n" +
            "}\n"+"商家设置储值 普通人员 储值删除json={\n" +
            "    \"oper\": \"操作方式  del/删除  open/开启活动  \",\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"id\": \"数据id 单个删除\"\n" +
            "}\n"+"商家设置储值 普通人员 储值开启活动设置json={\n" +
            "    \"oper\": \"操作方式  open/开启活动设置  \",\n" +
            "    \"shopHomeCode\": \"商家编号\",\n" +
            "    \"openFlag\": \"活动是否开启 Y/N \",\n" +
            "    \"vipFlag\": \"是vip还是普通会员使用  Y/vip  N/普通会员\",\n" +
            "    \"ids\": \"有效设置有效时必须传值  \",\n" +
            "    \"name\": \"规则名称\"\n" +
            "}\n"+"商家设置储值 普通人员 储值有效活动设置json={\n" +
            "    \"oper\": \"操作方式  valid/ 有效活动  \",\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"ids\": \"数据id 多个逗号间隔\"\n" +
            "}"
     )
    @PostMapping("vipStoredValue")
    public Object vipStoredValue(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String oper=map.get("oper").toString();
            TShopVipRecharge tShopVipRecharge= BeanUtil.toBean(map,TShopVipRecharge.class);
            shopVipRechargeService.operData(oper,tShopVipRecharge);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("app/vip/vipStoredValue****" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
    @ApiOperation(value = "获取商家  会员或普通人员 储值", notes =
            "{\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"name\": \"规则名称 可为空  为空获取全部\",\n" +
            "    \"validFlag\": \"活动是否开启后是否生效 Y/N\",\n"+
            "    \"vipFlag\": \"是vip还是普通会员使用  Y/vip  N/普通会员\"\n" +
            "}" )
    @PostMapping("getVipStored")
    public Object getVipStored(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String loginNo=map.get(SysContent.LOGINNO_STR).toString();
            String name=null;
            if(null!=map.get(SysContent.NAME_STR)){
                name=map.get(SysContent.NAME_STR).toString();
            }
            String vipFlag=null;
            if(null!=map.get(SysContent.VIPFLAG)){
                vipFlag=map.get(SysContent.VIPFLAG).toString();
            }
            String validFlag=null;
            if(null!=map.get(SysContent.VALIDFLAG)){
                validFlag=map.get(SysContent.VALIDFLAG).toString();
            }
            List<Map<String, Object>> result=shopVipRechargeService.getVipStored(loginNo,name,vipFlag,validFlag,null);
            if(null==result || result.isEmpty()){
                result=new ArrayList<>();
            }
            return responseAppRes(ResJson.Ok(result));
        } catch (Exception e) {
            log.error("app/vip/getVipStored****" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
    @ApiOperation(value = "商家设置vip会员券", notes =
                         "商家设置vip会员券添加json={" +
                          "    \"oper\": \"add\",\n" +
                          "    \"loginNo\": \"登录号\",\n" +
                          "    \"shopHomeCode\": \"商家编号\",\n" +
                          "    \"name\": \"优惠券名称\",\n" +
                          "    \"consumeMoney\": \"使用门槛\",\n" +
                          "    \"toMoneySend\": \"优惠券金额\",\n" +
                          "    \"timeDay\": \"有效期\"\n" +
                          "}\n"+  "商家设置vip会员券编辑{" +
                          "    \"oper\": \"edit\",\n" +
                          "    \"loginNo\": \"登录号\",\n" +
                          "    \"id\": \"数据id\",\n" +
                          "    \"consumeMoney\": \"使用门槛\",\n" +
                          "    \"toMoneySend\": \"优惠券金额\",\n" +
                          "    \"timeDay\": \"有效期\"\n" +
                          "}\n"+ "商家设置vip会员券删除json={" +
                          "    \"oper\": \"del\",\n" +
                          "    \"loginNo\": \"登录号\",\n" +
                          "    \"id\": \"数据id\"\n" +
                          "}"
           )
    @PostMapping("vipCoupons")
    public Object VipCoupons(String json) {
        try {
            Map<String,Object> map=getRequestCk(json);
            String oper=map.get(SysContent.OPER_STR).toString();
            TShopVipConsumerCoupon shopVipConsumerCoupon=BeanUtil.toBean(map,TShopVipConsumerCoupon.class);
            shopVipConsumerCouponService.operData(oper,shopVipConsumerCoupon);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("app/vip/vipCoupons****" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
    @ApiOperation(value = "获取商家设置vip会员券", notes =
                         "{" +
                           "    \"name\": \"规则名称 可为空  为空获取全部\",\n" +
                          "    \"loginNo\": \"登录号\"\n" +
                          "}")
    @PostMapping("getVipCoupons")
    public Object getVipCoupons(String json) {
        try {
            Map<String,Object> map=getRequestCk(json);
            String name=null;
            if(null!=map.get(SysContent.NAME_STR)){
                name=map.get(SysContent.NAME_STR).toString();
            }
            String loginNo=map.get(SysContent.LOGINNO_STR).toString();
            List<Map<String, Object>> result=shopVipConsumerCouponService.getVipCoupons(loginNo,name);
            if(null==result|| result.isEmpty()){
                result=new ArrayList<>();
            }
            return responseAppRes(ResJson.Ok(result));
        } catch (Exception e) {
            log.error("app/vip/getVipCoupons****" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }





    @ApiOperation(value = "添加/修改 权益", notes =
            "会员权益添加json={\n" +
            "    \"oper\": \"add 添加\",\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"name\": \"规则名称\",\n" +
            "    \"shopHomeCode\": \"商家编号\",\n" +
            "    \"openFlag\": \"是否开启 Y/N\",\n" +
            "    \"vipType\": \"会员权益类型 1/积分翻倍  2/每月领券  3/储值多送 4/订单打折 5/配送打折 6/商品会员价，  多个逗号间隔\",\n" +
            "    \"orderDiscount\": \"订单打折\",\n" +
            "    \"toSendDiscount\": \"配送打折\",\n" +
            "    \"scoreTimes\": \"积分翻倍\",\n" +
            "    \"allDiscount\": \"全场打折\",\n" +
            "    \"allFlag\": \"是否全场 Y/N\",\n" +
            "    \"vipMoneyType\": \"会员计费类型  1/免费领取  2/月收费  3/季收费 4/年收费  5/月季年收费\",\n" +
            "    \"vipMonthMoney\": \"按月收费\",\n" +
            "    \"vipSeasonMoney\": \"按季收费\",\n" +
            "    \"vipYearMoney\": \"按年收费\",\n" +
            "    \"vipRechargeIds\": , 绑定权益 充值列表ids 逗号间隔\n" +
            "    \"vipConsumerCouponIds\": 绑定权益 会员消费券列表ids" +
            "}\n" +"会员权益编辑json={\n" +
            "    \"oper\": \"edit 编辑\",\n" +
            "    \"id\": \"数据id\",\n" +
            "    \"openFlag\": \"是否开启 Y/N\",\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"vipType\": \"会员权益类型 1/积分翻倍  2/每月领券  3/储值多送 4/订单打折 5/配送打折 6/商品会员价，  多个逗号间隔\",\n" +
            "    \"orderDiscount\": \"订单打折\",\n" +
            "    \"toSendDiscount\": \"配送打折\",\n" +
            "    \"scoreTimes\": \"积分翻倍\",\n" +
            "    \"allDiscount\": \"全场打折\",\n" +
            "    \"allFlag\": \"是否全场 Y/N\",\n" +
            "    \"vipMoneyType\": \"会员计费类型  1/免费领取  2/月收费  3/季收费 4/年收费  5/月季年收费\",\n" +
            "    \"vipMonthMoney\": \"按月收费\",\n" +
            "    \"vipSeasonMoney\": \"按季收费\",\n" +
            "    \"vipYearMoney\": \"按年收费\",\n" +
            "    \"vipRechargeIds\": \" 绑定权益 充值列表ids 逗号间隔\",\n" +
            "    \"vipConsumerCouponIds\": 绑定权益 会员消费券列表ids" +
            "}\n" +"会员权益开启json={\n" +
            "    \"oper\": \"open 开启\",\n" +
            "    \"openFlag\": \"是否开启 Y/N\",\n" +
            "    \"id\": 数据id" +
            "}\n")
    @PostMapping("add")
    public Object addVipInfo(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            TShopVipBase tShopVipBase = BeanUtil.toBean(map,TShopVipBase.class);
            String loginNo=getRequestCk(json).get(SysContent.LOGINNO_STR).toString();
            String oper=getRequestCk(json).get(SysContent.OPER_STR).toString();
            if(SysContent.OPER_ADD.equals(oper)) {
                tShopVipBase.setAddBy(loginNo);
                tShopVipBase.setAddDt(new Date());
            }else{
                tShopVipBase.setEditBy(loginNo);
                tShopVipBase.setEditDt(new Date());
            }
            tShopVipBaseService.addVipInfo(oper,tShopVipBase);
            return responseAppRes(ResJson.Ok(tShopVipBase));
        } catch (Exception e) {
            log.error("app/vip/addVipInfo****" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }

    @ApiOperation(value = "商家的活动", notes = "{\n" +
            "    \"isOpen\": \"是否开启 Y/N 不传默认全部\",\n" +
            "    \"loginNo\": \"登录号\"\n" +
            "}")
    @PostMapping("getActivity")
    public Object getActivity(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String loginNo=map.get(SysContent.LOGINNO_STR).toString();
            String isOpen=null;
            if(null!=map.get("isOpen")){
                isOpen=map.get("isOpen").toString();
            }
            List<Map<String,Object>> result=tShopVipBaseService.getActivity(loginNo,isOpen);
            return responseAppRes(ResJson.Ok(result));
        } catch (Exception e) {
            log.error("app/vip/getActivity****" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
    @ApiOperation(value = "获取权益根据类别", notes = "{\n" +
            "    \"loginNo\": \"登录号\"\n" +
            "}")
    @PostMapping("getShopVip")
    public Object getVipInfo(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            TShopVipBase tShopVipBase = tShopVipBaseService.getInfoByLoginNo(map.get(SysContent.LOGINNO_STR).toString());
            return responseAppRes(ResJson.Ok(tShopVipBase));
        } catch (Exception e) {
            log.error("app/vip/getShopVip****" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
}
