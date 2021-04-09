package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TOrderAfterDetail;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TOrderAfterDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TOrderAfterDetailController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(description = "TOrderAfterDetail Controller")
@RestController
@RequestMapping("/tOrderAfterDetail")
public class TOrderAfterDetailController {

    @Autowired
    private TOrderAfterDetailService tOrderAfterDetailService;

    /**
     * 新增
     *
     * @param tOrderAfterDetail
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TOrderAfterDetail tOrderAfterDetail) {
        tOrderAfterDetailService.save(tOrderAfterDetail);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tOrderAfterDetailService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tOrderAfterDetail
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TOrderAfterDetail tOrderAfterDetail) {
        tOrderAfterDetailService.updateById(tOrderAfterDetail);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TOrderAfterDetail detail(@RequestParam("id") Long id) {
        return tOrderAfterDetailService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TOrderAfterDetail> userList(@RequestBody(required = false) VQuery query) {
        return tOrderAfterDetailService.page(query);
    }

}