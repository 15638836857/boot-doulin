package com.doulin.mobile.controller.shophd;

import cn.hutool.core.bean.BeanUtil;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopScoreCoupon;
import com.doulin.entity.TShopScoreSetting;
import com.doulin.entity.common.ResJson;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.TShopScoreCouponService;
import com.doulin.service.TShopScoreSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @className TShopScoreController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/13 11:32
 * @Version 1.0
 */
@Api(tags = "App商家积分兑换")
@RestController
@RequestMapping("app/shop/score")
@CrossOrigin
@Slf4j
public class TShopScoreController extends BaseAppController {
    private final  static  String API_TOP="app/shop/score";
    @Autowired
    private TShopScoreCouponService tShopScoreCouponService;
    @Autowired
    private TShopScoreSettingService tShopScoreSettingService;

    /**
     * 查询信息
     *
     * @param json
     */
    @ApiOperation(value = "商家端积分活动查询", notes = "{\n" +
            "    \"shopHomeCode\": \"商家编号\",\n" +
            "    \"name\": \"活动名称\",\n" +
            "    \"loginNo\": \"登录号\"\n" +
            "}")
    @PostMapping("/getScoreInfo")
    public Object getScoreInfo(String json) {
        try {
            Map<String,Object> map=getRequestCk(json);
            String loginNo=map.get(SysContent.LOGINNO_STR).toString();
            String name=map.get(SysContent.NAME_STR).toString();
            String shopHomeCode=map.get("shopHomeCode").toString();
            TShopScoreSetting tShopScoreCoupon=tShopScoreSettingService.getByShopLoginNo(loginNo);
            if(null==tShopScoreCoupon){//如果为空默认添加一条
                tShopScoreCoupon=new TShopScoreSetting();
                tShopScoreCoupon.setShopHomeCode(shopHomeCode);
                tShopScoreCoupon.setName(name);
                tShopScoreCoupon.setMoneyToOneScore(BigDecimal.valueOf(SysContent.INTGER_0));
                tShopScoreCoupon.setOpenFlag(SysContent.N_STR);
                tShopScoreSettingService.saveAndUpdate(SysContent.OPER_ADD,tShopScoreCoupon);
                TShopScoreSetting ts=tShopScoreSettingService.getByShopLoginNo(loginNo);
                return responseAppRes(ResJson.Ok(ts));
            }else{
                return responseAppRes(ResJson.Ok(tShopScoreCoupon));
            }
        } catch (Exception e) {
           log.error(API_TOP+"getScoreInfo****" +e.getMessage());
           return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
    /**
     * 新增
     *
     * @param json
     */
    @ApiOperation(value = "商家端积分活动 更新/添加 接口", notes = "{\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"ids\": \"优惠券的有效  ids 逗号间隔\",\n" +
            "    \"name\": \"名称\",\n" +
            "    \"openFlag\": \"是否开启 Y/N\",\n" +
            "    \"moneyToOneScore\": \"多少钱送一个积分  规则\",\n" +
            "    \"shopHomeCode\": \"商家编号\"\n" +
            "}")
    @PostMapping("/hdAddOrUpdate")
    public Object addOrUpdate(String json) {
        try {
            Map<String,Object> map=getRequestCk(json);
            String loginNo=map.get(SysContent.LOGINNO_STR).toString();
            TShopScoreSetting tShopScoreCoupon= BeanUtil.toBean(map,TShopScoreSetting.class);
            tShopScoreSettingService.saveAndUpdate(SysContent.OPER_EDIT,tShopScoreCoupon);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
           log.error(API_TOP+"/hd/addOrUpdate****" +e.getMessage());
           return responseAppRes(ResJson.error(e.getMessage()));
        }

    }
    @ApiOperation(value = "商家段积分规则 更新/添加/删除 接口", notes = "{\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"oper\": \"add/edit/del\",\n" +
            "    \"id\": \"编辑/删除 必传\",\n" +
            "    \"shopHomeCode\": \"商家编码\",\n" +
            "    \"name\": \"优惠券名称\",\n" +
            "    \"couponAmount\": \"优惠券金额\",\n" +
            "    \"demandScore\": \"使用门槛 多少积分\",\n" +
            "    \"toScore\": \"兑换积分\",\n" +
            "    \"validFlag\": \"是否生效  Y/N\"\n" +
            "}")
    @PostMapping("/gzAddOrUpdate")
    public Object add(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String oper = map.get(SysContent.OPER_STR).toString();
            String loginNo = map.get(SysContent.LOGINNO_STR).toString();
            TShopScoreCoupon tShopScoreCoupon = BeanUtil.toBean(map, TShopScoreCoupon.class);
            tShopScoreCouponService.saveAndUpdate(oper, tShopScoreCoupon);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error(API_TOP + "/gz/addOrUpdate****" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }

}
