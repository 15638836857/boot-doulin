package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysDept;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * SysDeptController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "部门控制器类")
@RestController
@RequestMapping("/sysDept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 新增
     *
     * @param sysDept
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysDept sysDept) {
        sysDeptService.save(sysDept);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysDeptService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param sysDept
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysDept sysDept) {
        sysDeptService.updateById(sysDept);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysDept detail(@RequestParam("id") Long id) {
        return sysDeptService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysDept> userList(@RequestBody(required = false) VQuery query) {
        return sysDeptService.page(query);
    }

}