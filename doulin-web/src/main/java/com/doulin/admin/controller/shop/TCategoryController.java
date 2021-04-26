package com.doulin.admin.controller.shop;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TCategory;
import com.doulin.service.TCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * TCategoryController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "商品分类控制器类")
@CrossOrigin
@RestController
@RequestMapping("/tcategory")
@Slf4j
public class TCategoryController extends BaseWebController {

    @Autowired
    private TCategoryService tCategoryService;

    /**
     * 新增
     *
     * @param requestMap
     */
    @ApiOperation(value = "商品分类添加", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"name\": \"分类名称\",\n" +
            "        \"shopGroupId\": \"商家分类id\",\n" +
            "        \"image\": \"分类的图片图标  base64 字符串\",\n" +
            "        \"sort\": \"排序\",\n" +
            "        \"status\": \"是否禁用 Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        TCategory tCategory = BeanUtil.toBean(getVvalue(requestMap), TCategory.class);
        try {
            if(null==tCategory.getShopGroupId()){
                throw new MyException("店铺类型有误");
            }
            tCategory.setAddBy(getLoginUserId(requestMap));
            tCategory.setDelFlag(SysContent.INTGER_0);
            tCategory.setAddDt(new Date());
            TCategory tt = tCategoryService.getOneByNameOrId(null,tCategory.getName());
            if (null != tt) {
                throw new MyException(SysContent.ERROR_EXISIS);
            }
            tCategoryService.save(tCategory);
            return R.ok();
        } catch (MyException e) {
            log.error("添加商品分类异常***" + e.getMessage());
            return R.error(e.getMessage());
        }
    }
    /**
     * 修改
     *
     * @param requestMap
     */
    @ApiOperation(value = "商品分类修改", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\",\n" +
            "        \"name\": \"分类名称\",\n" +
            "        \"shopGroupId\": \"商家分类id\",\n" +
            "        \"image\": \"分类的图片图标  base64 字符串\",\n" +
            "        \"sort\": \"排序\",\n" +
            "        \"status\": \"是否禁用 Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
        TCategory tCategory = BeanUtil.toBean(getVvalue(requestMap), TCategory.class);
        try {
            if(tCategory.getId()==null){
                throw new MyException(SysContent.ERROR_PARAM_ID);
            }
            if(null==tCategory.getShopGroupId()){
                throw new MyException("店铺类型有误");
            }
            tCategory.setEditBy(getLoginUserId(requestMap));
            tCategory.setEditDt(new Date());
            TCategory tt = tCategoryService.getOneByNameOrId(null,tCategory.getName());
            if (null != tt && !tt.getId().equals(tCategory.getId())) {
                throw new MyException(SysContent.ERROR_EXISIS);
            }
            tCategoryService.updateById(tCategory);
            return R.ok();
        } catch (MyException e) {
            log.error("修改商品分类异常***" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
     * 删除
     *
     * @param requestMap
     */
    @ApiOperation(value = "删除", notes = "{\n" +
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
            tCategoryService.deleteById(Integer.valueOf(getVvalue(requestMap).get(SysContent.ID_STR).toString()),
                    getLoginUserId(requestMap));
            return R.ok();
        } catch (MyException e) {
            log.error("商家分类删除异常" + e.getMessage());
            return R.error();
        }

    }



    /**
     * 详情
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "详情", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/detail")
    public Object detail(@RequestBody Map<String,Object> requestMap) {
        try {
           TCategory tt= tCategoryService.getOneByNameOrId(Integer.valueOf(getVvalue(requestMap).get(SysContent.ID_STR).toString()),null);
            return R.ok(tt);
        } catch (Exception e) {
            log.error("商家分类删除异常" + e.getMessage());
            return R.error();
        }

    }


    /**
     * 分页
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "商品分类的分页数据", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"name\": \"分类名称\",\n" +
            "        \"shopGroupId\": \"商家分类id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object userList(@RequestBody Map<String,Object> requestMap) {
        IPage<TCategory> page=tCategoryService.pageInfo(getPageParm(requestMap));
        if(null==page.getRecords()||page.getRecords().size()<=0){
            return R.ok(SysContent.ERROR_EMPTY);
        }
        return R.ok(page);
    }

}