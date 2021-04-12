package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysSalesman;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysSalesmanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * SysSalesmanController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "业务员控制器类")
@RestController
@RequestMapping("/sysSalesman")
public class SysSalesmanController {

    @Autowired
    private SysSalesmanService sysSalesmanService;

    /**
     * 新增
     *
     * @param sysSalesman
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysSalesman sysSalesman) {
        sysSalesmanService.save(sysSalesman);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysSalesmanService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param sysSalesman
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysSalesman sysSalesman) {
        sysSalesmanService.updateById(sysSalesman);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysSalesman detail(@RequestParam("id") Long id) {
        return sysSalesmanService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysSalesman> userList(@RequestBody(required = false) VQuery query) {
        return sysSalesmanService.page(query);
    }

}