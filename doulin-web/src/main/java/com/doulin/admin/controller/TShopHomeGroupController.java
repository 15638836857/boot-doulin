package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TShopHomeGroup;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TShopHomeGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TShopHomeGroupController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "商家分组控制器类")
@RestController
@RequestMapping("/tshopHomeGroup")
public class TShopHomeGroupController {

    @Autowired
    private TShopHomeGroupService tShopHomeGroupService;

    /**
     * 新增
     *
     * @param tShopHomeGroup
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TShopHomeGroup tShopHomeGroup) {
        tShopHomeGroupService.save(tShopHomeGroup);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tShopHomeGroupService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tShopHomeGroup
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TShopHomeGroup tShopHomeGroup) {
        tShopHomeGroupService.updateById(tShopHomeGroup);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TShopHomeGroup detail(@RequestParam("id") Long id) {
        return tShopHomeGroupService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TShopHomeGroup> userList(@RequestBody(required = false) VQuery query) {
        return tShopHomeGroupService.page(query);
    }

}