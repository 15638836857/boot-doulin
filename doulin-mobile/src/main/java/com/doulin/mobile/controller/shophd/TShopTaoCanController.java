package com.doulin.mobile.controller.shophd;

import cn.hutool.core.bean.BeanUtil;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopToucanHd;
import com.doulin.entity.TShopToucanHdGoods;
import com.doulin.entity.common.ResJson;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.TShopToucanHdGoodsService;
import com.doulin.service.TShopToucanHdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
* TShopToucanHdController
* @Author malinging
* @Date 2021-05-14
**/
@Api(tags = "app商家套餐/复购套餐/第二件N折/加价购")
@RestController
@RequestMapping("app/shop/tc")
@CrossOrigin
@Slf4j
public class TShopTaoCanController extends BaseAppController {
    private final  static  String API_TOP="app/shop/tc";
    @Autowired
    private TShopToucanHdService tShopToucanHdService;
    @Autowired
    private TShopToucanHdGoodsService tShopToucanHdGoodsService;
    /**
     * 获取数控i
     *
     * @param json
     * @return
     */
    @ApiOperation(value = "获取套餐信息 FGTC:复购套餐/  DEJNZ:第二件N折/ JJG加价购", notes = "{\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"orderType\": \"FGTC:复购套餐/  DEJNZ:第二件N折/ JJG加价购\",\n" +
            "    \"shopHomeCode\": \"商家编号\"\n" +
            "}")
    @PostMapping("/getTcInfo")
    public String  userList(String json) {
        try {
            Map<String,Object> map=getRequestCk(json);
            String loginNo=map.get(SysContent.LOGINNO_STR).toString();
            String orderType=map.get(SysContent.ORDER_TYPE).toString();
            String shopHomeCode=map.get(SysContent.SHOP_HOME_CODE).toString();
            TShopToucanHd tShopToucanHd=tShopToucanHdService.getByShopHomeCodeAndOrderType(shopHomeCode,orderType);

            return responseAppRes(ResJson.Ok(tShopToucanHd));
        } catch (Exception e) {
            log.error(API_TOP+"/getTcInfo***********"+e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
    /**
    * 新增
    *
    * @param json
    */
    @ApiOperation(value = "app商家套餐/复购套餐/第二件N折/加价购  添加/修改/删除/开启或关闭", notes = "复购套餐{\n" +
            "    \"oper\": \"add/edit/del/open\",\n" +
            "    \"loginNo\": \"登录号\",\n" +
            "    \"shopHomeCode\": \"商家编号\",\n" +
            "    \"orderType\": \" FGTC:复购套餐/  DEJNZ:第二件N折/ JJG加价购  必传\",\n" +
            "    \"openFlag\": \" 是否开启 Y/N\",\n" +
            "    \"validFlag\": \" 是否有效 Y/N\",\n" +
            "    \"id\": \"套餐的id 修改/删除 必传\",\n" +
            "    \"ids\": \"开启有效的id 逗号间隔  必传\",\n" +
            "    \"name\": \"活动名称\",\n" +
            "    \"shopGoodsId\": \"商品id 设置套餐时必填\",\n" +
            "    \"shopGoodsSkuId\": \"商品skuid 设置套餐时必填\",\n" +
            "    \"tcName\": \"套餐名称\",\n" +
            "    \"price\": \"套餐一口价\",\n" +
            "    \"goodsNum\": \"商品数量\"\n" +
            "}\n 第二件N折 {\n" +
            "        \"oper\": \"add/edit/del/open\",\n" +
            "        \"loginNo\": \"登录号\",\n" +
            "        \"shopHomeCode\": \"商家编号\",\n" +
            "        \"orderType\": \" FGTC:复购套餐/ DEJNZ:第二件N折/ JJG加价购 必传\",\n" +
            "        \"openFlag\": \" 是否开启 Y/N\",\n" +
            "        \"validFlag\": \" 是否有效 Y/N\",\n" +
            "        \"id\": \" 套餐id 修改/删除 必传\",\n" +
            "        \"ids\": \"开启有效的套餐id 逗号间隔 必传\",\n" +
            "        \"shopGoodsId\": \"商品id 设置套餐时必填\",\n" +
            "       \"shopGoodsSkuId\": \"商品skuid 设置套餐时必填\",\n" +
            "        \"twoDiscount\": \"第二件则扣\"\n" +
            "}\n JJG加价购{\n" +
            "        \"oper\": \"add/edit/del/open\",\n" +
            "        \"loginNo\": \"登录号\",\n" +
            "        \"shopHomeCode\": \"商家编号\",\n" +
            "        \"orderType\": \" FGTC:复购套餐/ DEJNZ:第二件N折/ JJG加价购 必传\",\n" +
            "        \"openFlag\": \" 是否开启 Y/N\",\n" +
            "        \"validFlag\": \" 是否有效 Y/N\",\n" +
            "        \"id\": \" 套餐id 修改/删除 必传\",\n" +
            "        \"ids\": \"开启有效的套餐id 逗号间隔 必传\",\n" +
            "        \"shopGoodsId\": \"商品id 设置套餐时必填\",\n" +
            "        \"addMoney\": \"加价购 加的金额\"\n" +
            "    }")
    @PostMapping("/addOrUpdate")
    public Object add(String json) {
        try {
            Map<String,Object> map=getRequestCk(json);
            TShopToucanHdGoods tShopToucanHd= BeanUtil.toBean(map,TShopToucanHdGoods.class);
            String oper=map.get(SysContent.OPER_STR).toString();
            String tcName="",openFlag="",hdName="";
            if(null!=map.get("tcName")){
                tcName=map.get("tcName").toString();
            }  if(null!=map.get(SysContent.OPEN_FLAG)){
                openFlag=map.get(SysContent.OPEN_FLAG).toString();
            } if(null!=map.get(SysContent.NAME_STR)){
                hdName=map.get(SysContent.NAME_STR).toString();
            }
            tShopToucanHdGoodsService.addOrUpdate(oper,tShopToucanHd,hdName,tcName,openFlag);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error(API_TOP+"/addOrUpdate***********"+e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }

    }



}