package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TShopHomeBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TShopHomeBaseInfoController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(description = "商家基本信息控制器类")
@RestController
@RequestMapping("/tshopHomeBaseInfo")
public class TShopHomeBaseInfoController {

    @Autowired
    private TShopHomeBaseInfoService tShopHomeBaseInfoService;

    /**
     * 新增
     *
     * @param tShopHomeBaseInfo
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TShopHomeBaseInfo tShopHomeBaseInfo) {
        tShopHomeBaseInfoService.save(tShopHomeBaseInfo);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tShopHomeBaseInfoService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tShopHomeBaseInfo
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TShopHomeBaseInfo tShopHomeBaseInfo) {
        tShopHomeBaseInfoService.updateById(tShopHomeBaseInfo);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TShopHomeBaseInfo detail(@RequestParam("id") Long id) {
        return tShopHomeBaseInfoService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TShopHomeBaseInfo> userList(@RequestBody(required = false) VQuery query) {
        return tShopHomeBaseInfoService.page(query);
    }

}