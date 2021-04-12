package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TCar;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TCarController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "用户购物车控制器类")
@RestController
@RequestMapping("/tcar")
public class TCarController {

    @Autowired
    private TCarService tCarService;

    /**
     * 新增
     *
     * @param tCar
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TCar tCar) {
        tCarService.save(tCar);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tCarService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tCar
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TCar tCar) {
        tCarService.updateById(tCar);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TCar detail(@RequestParam("id") Long id) {
        return tCarService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TCar> userList(@RequestBody(required = false) VQuery query) {
        return tCarService.page(query);
    }

}