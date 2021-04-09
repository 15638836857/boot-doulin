package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TCategory;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TCategoryController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(description = "TCategory Controller")
@RestController
@RequestMapping("/tCategory")
public class TCategoryController {

    @Autowired
    private TCategoryService tCategoryService;

    /**
     * 新增
     *
     * @param tCategory
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TCategory tCategory) {
        tCategoryService.save(tCategory);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tCategoryService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tCategory
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TCategory tCategory) {
        tCategoryService.updateById(tCategory);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TCategory detail(@RequestParam("id") Long id) {
        return tCategoryService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TCategory> userList(@RequestBody(required = false) VQuery query) {
        return tCategoryService.page(query);
    }

}