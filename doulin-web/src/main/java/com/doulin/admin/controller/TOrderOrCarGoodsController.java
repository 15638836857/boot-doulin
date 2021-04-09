package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TOrderOrCarGoods;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TOrderOrCarGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TOrderOrCarGoodsController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(description = "TOrderOrCarGoods Controller")
@RestController
@RequestMapping("/tOrderOrCarGoods")
public class TOrderOrCarGoodsController {

    @Autowired
    private TOrderOrCarGoodsService tOrderOrCarGoodsService;

    /**
     * 新增
     *
     * @param tOrderOrCarGoods
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TOrderOrCarGoods tOrderOrCarGoods) {
        tOrderOrCarGoodsService.save(tOrderOrCarGoods);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tOrderOrCarGoodsService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tOrderOrCarGoods
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TOrderOrCarGoods tOrderOrCarGoods) {
        tOrderOrCarGoodsService.updateById(tOrderOrCarGoods);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TOrderOrCarGoods detail(@RequestParam("id") Long id) {
        return tOrderOrCarGoodsService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TOrderOrCarGoods> userList(@RequestBody(required = false) VQuery query) {
        return tOrderOrCarGoodsService.page(query);
    }

}