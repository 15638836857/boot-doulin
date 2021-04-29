package com.doulin.mobile.controller;

import cn.hutool.core.bean.BeanUtil;
import com.doulin.common.MyException;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TCategory;
import com.doulin.entity.common.ResJson;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.TCategoryService;
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
 * TCategoryController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "App商品分类控制器类")
@CrossOrigin
@RestController
@RequestMapping("app/tctg")
@Slf4j
public class TCategoryController extends BaseAppController {

    @Autowired
    private TCategoryService tCategoryService;

    /**
     * 新增
     *
     * @param json
     */
    @ApiOperation(value = "商品分类添加", notes = "{\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"name\": \"分类名称\",\n" +
            "    \"shopGroupId\": \"商家分类id\",\n" +
            "    \"image\": \"分类的图片图标\",\n" +
            "    \"sort\": \"排序\",\n" +
            "    \"status\": \"是否禁用 Y/N\"\n" +
            "}")
    @PostMapping("/add")
    public Object add(String json) {
        try {
            Map<String, Object> requestMap = getRequestCk(json);
            String loginNo = requestMap.get(SysContent.LOGINNO_STR).toString();
            TCategory tCategory = BeanUtil.toBean(requestMap, TCategory.class);
            if (null == tCategory.getShopGroupId()) {
                throw new MyException("店铺类型有误");
            }
            tCategory.setAddBy(loginNo);
            tCategory.setDelFlag(SysContent.INTGER_0);
            tCategory.setAddDt(new Date());
            TCategory tt = tCategoryService.getOneByNameOrId(null, tCategory.getName());
            if (null != tt) {
                throw new MyException(SysContent.ERROR_EXISIS);
            }
            tCategoryService.save(tCategory);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("添加商品分类异常***" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }
    /**
     * 修改
     *
     * @param json
     */
    @ApiOperation(value = "商品分类修改", notes = "{\n" +
            "        \"id\": \"数据id\",\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"categoryId\": \"商品分类id  不传值 查系统和 商家的分类\",\n" +
            "    \"name\": \"分类名称\",\n" +
            "    \"shopGroupId\": \"商家分类id\",\n" +
            "    \"image\": \"分类的图片图标\",\n" +
            "    \"sort\": \"排序\",\n" +
            "    \"status\": \"是否禁用 Y/N\"\n" +
            "}")
    @PostMapping("/update")
    public Object update(String json) {
        try {
            Map<String, Object> requestMap = getRequestCk(json);
            String loginNo = requestMap.get(SysContent.LOGINNO_STR).toString();
            TCategory tCategory = BeanUtil.toBean(requestMap, TCategory.class);
            if(tCategory.getId()==null){
                throw new MyException(SysContent.ERROR_PARAM_ID);
            }
            if(null==tCategory.getShopGroupId()){
                throw new MyException("店铺类型有误");
            }
            tCategory.setEditBy(loginNo);
            tCategory.setEditDt(new Date());
            TCategory tt = tCategoryService.getOneByNameOrId(null,tCategory.getName());
            if (null != tt && !tt.getId().equals(tCategory.getId())) {
                throw new MyException(SysContent.ERROR_EXISIS);
            }
            tCategoryService.updateById(tCategory);
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("修改商品分类异常***" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }

    /**
     * 删除
     *
     * @param json
     */
    @ApiOperation(value = "删除", notes = "{\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"id\": \"数据id\"\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(String json) {
        try {
            Map<String,Object> requestMap=getRequestCk(json);
            tCategoryService.deleteById(
                    Integer.valueOf(requestMap.get(SysContent.ID_STR).toString()),
                    requestMap.get(SysContent.LOGINNO_STR).toString());
            return responseAppRes(ResJson.Ok());
        } catch (Exception e) {
            log.error("商家分类删除异常" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }

    }



    /**
     * 详情
     *
     * @param json
     * @return
     */
    @ApiOperation(value = "详情", notes = "{\n" +
            "    \"loginNo\": \"登录账号\",\n" +
            "    \"id\": \"数据id\"\n" +
            "}")
    @PostMapping("/detail")
    public Object detail(String json) {
        try {
            Map<String, Object> requestMap = getRequestCk(json);
            TCategory tt = tCategoryService.getOneByNameOrId(Integer.valueOf(requestMap.get(SysContent.ID_STR).toString()), null);
            return responseAppRes(ResJson.Ok(tt));
        } catch (Exception e) {
            log.error("商家分类删除异常" + e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }


    /**
     * 分页
     *
     * @param json
     * @return
     */
    @ApiOperation(value = "商品分类的数据", notes = "{ \"loginNo\": \"商家登录号\"}")
    @PostMapping("/list")
    public Object userList(String json) {
        try {
            Map<String,Object> requestMap=getRequestCk(json);
            String loginNo=requestMap.get(SysContent.LOGINNO_STR).toString();
            List<TCategory> list=tCategoryService.getListByLoginNo(loginNo);
            return responseAppRes(ResJson.Ok(list));
        } catch (Exception e) {
            log.error("app/tctg/list*******"+e.getMessage());
            return responseAppRes(ResJson.error(e.getMessage()));
        }
    }

}