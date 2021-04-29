package com.doulin.mobile.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysGoodsShopHome;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysGoodsShopHomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
* SysGoodsShopHomeController
* @Author malinging
* @Date 2021-04-27
**/
@Api(description = "SysGoodsShopHome Controller")
@CrossOrigin
@RestController
@RequestMapping("/sysGoodsShopHome")
public class SysGoodsShopHomeController {

    @Autowired
    private SysGoodsShopHomeService sysGoodsShopHomeService;

    /**
    * 新增
    *
    * @param sysGoodsShopHome
    */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysGoodsShopHome sysGoodsShopHome) {
        sysGoodsShopHomeService.save(sysGoodsShopHome);
    }

    /**
    * 删除
    *
    * @param ids
    */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysGoodsShopHomeService.removeByIds(Arrays.asList(ids));
    }

    /**
    * 更新
    *
    * @param sysGoodsShopHome
    */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysGoodsShopHome sysGoodsShopHome) {
        sysGoodsShopHomeService.updateById(sysGoodsShopHome);
    }

    /**
    * 详情
    *
    * @param id
    * @return
    */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysGoodsShopHome detail(@RequestParam("id") Long id) {
        return sysGoodsShopHomeService.getById(id);
    }

    /**
    * 分页
    *
    * @param query
    * @return
    */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysGoodsShopHome> userList(@RequestBody(required = false) VQuery query) {
        return sysGoodsShopHomeService.page(query);
    }

}