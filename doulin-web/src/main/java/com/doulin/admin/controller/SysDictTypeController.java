package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysDictType;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * SysDictTypeController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(description = "字典类型控制器")
@RestController
@RequestMapping("/sysDictType")
public class SysDictTypeController {

    @Autowired
    private SysDictTypeService sysDictTypeService;

    /**
     * 新增
     *
     * @param sysDictType
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysDictType sysDictType) {
        sysDictTypeService.save(sysDictType);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysDictTypeService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param sysDictType
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysDictType sysDictType) {
        sysDictTypeService.updateById(sysDictType);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysDictType detail(@RequestParam("id") Long id) {
        return sysDictTypeService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysDictType> userList(@RequestBody(required = false) VQuery query) {
        return sysDictTypeService.page(query);
    }

}