package com.doulin.mobile.controller.shophd;

import cn.hutool.core.bean.BeanUtil;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopOrderCoupon;
import com.doulin.entity.common.ResJson;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.TShopOrderCouponService;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* TShopOrderCouponController
* @Author malinging
* @Date 2021-05-13
**/
@Api(tags = "商家订单消费券/订单返券/新人进店领券/进店领券/满减活动")
@RestController
@RequestMapping("app/shop/order/coupon")
@CrossOrigin
@Slf4j
public class TShopOrderCouponController extends BaseAppController {
    private final static String API_TOP="app/shop/order/coupon";

    @Autowired
    private TShopOrderCouponService tShopOrderCouponService;

    /**
     * 查询信息
     *
     * @param json
     */
    @ApiOperation(value = "商家端订单消费券活动查询", notes = "{\n" +
            "    \"shopHomeCode\": \"商家编号\",\n" +
            "    \"orderType\": \"DDFQ/订单返券,XNJDLQ/新人进店领券，JDLQ/进店领券 ，MJHD/满减活动\",\n" +
            "    \"loginNo\": \"登录号\"\n" +
            "}")
    @PostMapping("/getOrderCoupon")
    public Object getScoreInfo(String json) {
        try {
            Map<String,Object> map=getRequestCk(json);
            String loginNo=map.get(SysContent.LOGINNO_STR).toString();
            String shopHomeCode=map.get("shopHomeCode").toString();
            String orderType=map.get("orderType").toString();
            Map<String,Object> request= Maps.newHashMap();
            List<TShopOrderCoupon> tShopOrderCoupon=tShopOrderCouponService.getInfoByShopHomeCode(shopHomeCode,orderType);
            String openFlag=SysContent.N_STR;
            if(null==tShopOrderCoupon || tShopOrderCoupon.isEmpty()){
                tShopOrderCoupon=new ArrayList<>();
            }else{
                openFlag=tShopOrderCoupon.get(0).getOpenFlag();
            }
            request.put("openFlag",openFlag);
            request.put("orderCouponList",tShopOrderCoupon);
            return responseAppRes(ResJson.Ok(request));
        } catch (Exception e) {
            log.error(API_TOP+"getScoreInfo****" +e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }

    @ApiOperation(value = "商家段积分规则 更新/添加/删除 接口", notes = "{\n" +
            "    \"oper\": \"add:添加 / edit:编辑 /del:删除  /open:开启或关闭 \",\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"id\": \"数据id 编辑，删除 必传\",\n" +
            "    \"ids\": \"设置有效 必传\",\n" +
            "    \"orderType\": \"DDFQ/订单返券,XNJDLQ/新人进店领券，JDLQ/进店领券 ，MJHD/满减活动  每一步必传\",\n" +
            "    \"name\": \"优惠券名称\",\n" +
            "    \"orderToMoney\": \"返券门槛\",\n" +
            "    \"toMoneySend\": \"优惠金额/满减活动消费满多少金额减多少金额\",\n" +
            "    \"consumeMoney\": \"使用门槛 /消费满多少金额MJHD/满减活动 \",\n" +
            "    \"timeDay\": \"有效期多少天\",\n" +
            "    \"shopHomeCode\": \"商家编号 每一步 必传\",\n" +
            "    \"validFlag\": \"是否生效  Y/N\",\n" +
            "    \"openFlag\": \"是否开启  Y/N\"\n" +
            "}")
    @PostMapping("/addOrUpdate")
    public Object add(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String oper = map.get(SysContent.OPER_STR).toString();
            String loginNo = map.get(SysContent.LOGINNO_STR).toString();
            String orderType = map.get("orderType").toString();
            TShopOrderCoupon tShopOrderCoupon = BeanUtil.toBean(map, TShopOrderCoupon.class);
            tShopOrderCouponService.saveAndUpdate(oper, tShopOrderCoupon);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error(API_TOP + "/addOrUpdate****" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
}