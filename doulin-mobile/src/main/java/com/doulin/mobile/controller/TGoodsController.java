package com.doulin.mobile.controller;

import cn.hutool.core.bean.BeanUtil;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TGoods;
import com.doulin.entity.common.ResJson;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.SysGoodsService;
import com.doulin.service.TCategoryService;
import com.doulin.service.TGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @className 商品管理
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/27 19:09
 * @Version 1.0
 */
@Api(tags = "App商品管理")
@CrossOrigin
@RestController
@RequestMapping("app/tgs")
@Slf4j
public class TGoodsController extends BaseAppController {
    @Autowired
    private TGoodsService tGoodsService;
    @Autowired
    private TCategoryService categoryService;
    @Autowired
    private SysGoodsService sysGoodsService;
    /**
     * 获取商品分类信息
     * @return
     */
    @ApiOperation(value = "搜索系统商品",notes = "{\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"goodsName\": \"商品名称\"\n" +
            "}")
    @PostMapping("getSysGoodsByName")
    public Object getSysgoodsByName(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String loginNo = map.get(SysContent.LOGINNO_STR).toString();
            String goodsName = map.get("goodsName").toString();
            List<Map<String, Object>> list = sysGoodsService.getListByName(goodsName);
            return responseAppRes(ResJson.Ok(list));
        } catch (Exception e) {
            log.error("app/tgs/getSysgoodsByName**********" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
    /**
     * 获取商品添加信息
     * @return
     */
    @ApiOperation(value = "商品添加",notes = "{\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"categoryId\": \"分组id\",\n" +
            "    \"shopHomeCode\": \"商家编码\",\n" +
            "    \"sysGoodsId\": \"系统商品id\",\n" +
            "    \"goodsName\": \"商品名称\",\n" +
            "    \"imageTitle\": \"封面图片\",\n" +
            "    \"goodsTitle\": \"商品简介\",\n" +
            "    \"state\": \"是否有效 Y/N\",\n" +
            "    \"content\": \"商品详情\",\n" +
            "    \"keyword\": \"搜索关键字   如：苹,红苹果,黄瓜\",\n" +
            "    \"remark\": \"商品备注\",\n" +
            "    \"goodsLowerFrame\": \"商品下架  Y/N\",\n" +
            "    \"sort\": \"排序\",\n" +
            "    \"skuList\": [\n" +
            "        {\n" +
            "            \"sku\": \"sku商品1\",\n" +
            "            \"price\": \"商品价格\",\n" +
            "            \"cuPrice\": \"促销价格\",\n" +
            "            \"stock\": \"库存\",\n" +
            "            \"sort\": \"排序\",\n" +
            "            \"status\": \"是否禁用  Y/N\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"sku\": \"sku商品2\",\n" +
            "            \"price\": \"商品价格\",\n" +
            "            \"cuPrice\": \"促销价格\",\n" +
            "            \"stock\": \"库存\",\n" +
            "            \"sort\": \"排序\",\n" +
            "            \"status\": \"是否禁用  Y/N\"\n" +
            "        }\n" +
            "    ]\n" +
            "}")
    @PostMapping("goods/add")
    public Object addGoods(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String loginNo = map.get(SysContent.LOGINNO_STR).toString();
            TGoods tGoods= BeanUtil.toBean(map,TGoods.class);
            tGoods.setAddBy(loginNo);
            tGoods.setAddDt(new Date());
            tGoods.setDelFlag(SysContent.INTGER_0);
            tGoodsService.addOrUpdate(SysContent.OPER_ADD,tGoods);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("app/tgs/goods/add**********" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
    /**
     * 获取商品添加信息
     * @return
     */
    @ApiOperation(value = "商品修改",notes = "{\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"id\": \"数据id\",\n" +
            "    \"categoryId\": \"分组id\",\n" +
            "    \"shopHomeCode\": \"商家编码\",\n" +
            "    \"sysGoodsId\": \"系统商品id\",\n" +
            "    \"goodsName\": \"商品名称\",\n" +
            "    \"imageTitle\": \"封面图片\",\n" +
            "    \"goodsTitle\": \"商品简介\",\n" +
            "    \"state\": \"是否有效 Y/N\",\n" +
            "    \"content\": \"商品详情\",\n" +
            "    \"keyword\": \"搜索关键字   如：苹,红苹果,黄瓜\",\n" +
            "    \"remark\": \"商品备注\",\n" +
            "    \"goodsLowerFrame\": \"商品下架  Y/N\",\n" +
            "    \"sort\": \"排序\",\n" +
            "    \"skuList\": [\n" +
            "        {\n" +
            "            \"sku\": \"sku商品1\",\n" +
            "            \"price\": \"商品价格\",\n" +
            "            \"cuPrice\": \"促销价格\",\n" +
            "            \"stock\": \"库存\",\n" +
            "            \"sort\": \"排序\",\n" +
            "            \"status\": \"是否禁用  Y/N\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"sku\": \"sku商品2\",\n" +
            "            \"price\": \"商品价格\",\n" +
            "            \"cuPrice\": \"促销价格\",\n" +
            "            \"stock\": \"库存\",\n" +
            "            \"sort\": \"排序\",\n" +
            "            \"status\": \"是否禁用  Y/N\"\n" +
            "        }\n" +
            "    ]\n" +
            "}")
    @PostMapping("goods/update")
    public Object update(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String loginNo = map.get(SysContent.LOGINNO_STR).toString();
            TGoods tGoods= BeanUtil.toBean(map,TGoods.class);
            tGoods.setEditBy(loginNo);
            tGoods.setEditDt(new Date());
            tGoodsService.addOrUpdate(SysContent.OPER_EDIT,tGoods);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("app/tgs/goods/update**********" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }

    /**
     * 获取商品分类信息
     * @return
     */
    @ApiOperation(value = "根据分组id商品信息",notes = "{\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"cateId\": \"商品分类id\"\n" +
            "}")
    @PostMapping("getGoodsByCateId")
    public Object getGoodsByCategory(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String loginNo = map.get(SysContent.LOGINNO_STR).toString();
            String cateId = map.get("cateId").toString();
            List<TGoods> list = tGoodsService.getGoodsGategory(loginNo, cateId);
            return responseAppRes(ResJson.Ok(list));
        } catch (Exception e) {
            log.error("app/tgs/getGoodsByCateId**********" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
    /**
     * 获取商品分类信息
     * @return
     */
    @ApiOperation(value = "搜索商家商品",notes = "{\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"goodsLowerFrame\": \"商品是否下架   Y/N\",\n" +
            "    \"value\": \"关键字\"\n" +
            "}")
    @PostMapping("getGoodsByValue")
    public Object getGoodsByValue(String json) {
        try {
            Map<String, Object> map = getRequestCk(json);
            String loginNo = map.get(SysContent.LOGINNO_STR).toString();
            String value="",goodsLowerFrame="";
            if(null!=map.get("value")){
                value = map.get("value").toString();
            }
            if(null!=map.get("goodsLowerFrame")){
                goodsLowerFrame=map.get("goodsLowerFrame").toString();
            }
            List<TGoods> list = tGoodsService.getGoodsByValue(loginNo,goodsLowerFrame, value);
            return responseAppRes(ResJson.Ok(list));
        } catch (Exception e) {
            log.error("app/tgs/getGoodsByValue**********" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
}
