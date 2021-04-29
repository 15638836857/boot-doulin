package com.doulin.admin.controller.shop;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysGoods;
import com.doulin.service.SysGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
* 系统商品接口控制器
* @Author malinging
* @Date 2021-04-27
**/
@Api(tags = "系统商品接口控制器")
@CrossOrigin
@RestController
@RequestMapping("/sysGoods")
@Slf4j
public class SysGoodsController extends BaseWebController {

    @Autowired
    private SysGoodsService sysGoodsService;

    /**
    * 新增
    *
    * @param requestMap
    */
    @ApiOperation(value = "系统商品添加", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"goodsImg\": \"商品图片\",\n" +
            "        \"goodsName\": \"商品名称\",\n" +
            "        \"skuList\": [\n" +
            "            {\n" +
            "                \"sku\": \"规格1 如：50g/L\",\n" +
            "                \"prices\": \"价格\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"sku\": \"规格2 如：20g/L\",\n" +
            "                \"prices\": \"价格\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        SysGoods sysGoods= BeanUtil.toBean(getVvalue(requestMap),SysGoods.class);
        try {
            sysGoods.setAddBy(getLoginUserId(requestMap));
            sysGoods.setAddDt(new Date());
            sysGoods.setDelFlag(SysContent.INTGER_0);
            sysGoodsService.saveAndUpdate(SysContent.OPER_ADD,sysGoods);
            return R.ok();
        } catch (Exception e) {
            log.error("sysGoods/add" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
    * 删除
    *
    * @param requestMap
    */
    @ApiOperation(value = "delete", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(@RequestBody Map<String,Object> requestMap) {
        try {
            String id = getVvalue(requestMap).get(SysContent.ID_STR).toString();
            if (StrUtil.isEmpty(id)) {
                throw new Exception(SysContent.ERROR_ID);
            }
            sysGoodsService.deleteById(Integer.valueOf(id));
            return R.ok();
        } catch (Exception e) {
            log.error("sysGoods/delete" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
    * 更新
    *
    * @param requestMap
    */
    @ApiOperation(value = "update", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\",\n" +
            "        \"goodsImg\": \"商品图片\",\n" +
            "        \"goodsName\": \"商品名称\",\n" +
            "        \"sku\": [\n" +
            "            {\n" +
            "                \"sku\": \"规格1 如：50g/L\",\n" +
            "                \"prices\": \"价格\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"sku\": \"规格2 如：20g/L\",\n" +
            "                \"prices\": \"价格\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
        try {
            SysGoods sysGoods = BeanUtil.toBean(getVvalue(requestMap), SysGoods.class);
            sysGoods.setEditBy(getLoginUserId(requestMap));
            sysGoods.setEditDt(new Date());
            sysGoodsService.saveAndUpdate(SysContent.OPER_EDIT, sysGoods);
            return R.ok();
        } catch (Exception e) {
            log.error("sysGoods/update" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
    * 详情
    *
    * @param id
    * @return
    */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysGoods detail(@RequestParam("id") Long id) {
        return sysGoodsService.getById(id);
    }

    /**
    * 分页
    *
    * @param
    * @return
    */
    @ApiOperation(value = "系统商品管理分页数据", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"goodsName\": \"商品名称\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object userList(@RequestBody Map<String,Object> requestMap) {
        IPage<SysGoods> page=sysGoodsService.getPageInfo(getPageParm(requestMap));
        return R.ok(page);
    }

}