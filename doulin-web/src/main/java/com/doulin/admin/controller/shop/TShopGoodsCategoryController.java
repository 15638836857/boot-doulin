package com.doulin.admin.controller.shop;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopGoodsCategory;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TShopGoodsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
* TShopGoodsCategoryController
* @Author malinging
* @Date 2021-04-30
**/
@Api(description = "TShopGoodsCategory Controller")
@RestController
@RequestMapping("/tShopGoodsCategory")
public class TShopGoodsCategoryController {

    @Autowired
    private TShopGoodsCategoryService tShopGoodsCategoryService;

    /**
    * 新增
    *
    * @param tShopGoodsCategory
    */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TShopGoodsCategory tShopGoodsCategory) {
        tShopGoodsCategoryService.save(tShopGoodsCategory);
    }

    /**
    * 删除
    *
    * @param ids
    */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tShopGoodsCategoryService.removeByIds(Arrays.asList(ids));
    }

    /**
    * 更新
    *
    * @param tShopGoodsCategory
    */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TShopGoodsCategory tShopGoodsCategory) {
        tShopGoodsCategoryService.updateById(tShopGoodsCategory);
    }

    /**
    * 详情
    *
    * @param id
    * @return
    */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TShopGoodsCategory detail(@RequestParam("id") Long id) {
        return tShopGoodsCategoryService.getById(id);
    }

    /**
    * 分页
    *
    * @param query
    * @return
    */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TShopGoodsCategory> userList(@RequestBody(required = false) VQuery query) {
        return tShopGoodsCategoryService.page(query);
    }

}