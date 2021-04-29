package com.doulin.mobile.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysGoods;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
* SysGoodsController
* @Author malinging
* @Date 2021-04-27
**/
@Api(description = "SysGoods Controller")
@CrossOrigin
@RestController
@RequestMapping("/sysGoods")
public class SysGoodsController {

    @Autowired
    private SysGoodsService sysGoodsService;

    /**
    * 新增
    *
    * @param sysGoods
    */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysGoods sysGoods) {
        sysGoodsService.save(sysGoods);
    }

    /**
    * 删除
    *
    * @param ids
    */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysGoodsService.removeByIds(Arrays.asList(ids));
    }

    /**
    * 更新
    *
    * @param sysGoods
    */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysGoods sysGoods) {
        sysGoodsService.updateById(sysGoods);
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
    * @param query
    * @return
    */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysGoods> userList(@RequestBody(required = false) VQuery query) {
        return sysGoodsService.page(query);
    }

}