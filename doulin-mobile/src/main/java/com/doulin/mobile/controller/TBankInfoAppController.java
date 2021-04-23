package com.doulin.mobile.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TBankInfo;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TBankInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
* TBankInfoController
* @Author malinging
* @Date 2021-04-22
**/
@Api(description = "TBankInfo Controller")
@RestController
@RequestMapping("/tBankInfo")
public class TBankInfoAppController {

    @Autowired
    private TBankInfoService tBankInfoService;

    /**
    * 新增
    *
    * @param tBankInfo
    */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TBankInfo tBankInfo) {
        tBankInfoService.save(tBankInfo);
    }

    /**
    * 删除
    *
    * @param ids
    */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tBankInfoService.removeByIds(Arrays.asList(ids));
    }

    /**
    * 更新
    *
    * @param tBankInfo
    */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TBankInfo tBankInfo) {
        tBankInfoService.updateById(tBankInfo);
    }

    /**
    * 详情
    *
    * @param id
    * @return
    */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TBankInfo detail(@RequestParam("id") Long id) {
        return tBankInfoService.getById(id);
    }

    /**
    * 分页
    *
    * @param query
    * @return
    */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TBankInfo> userList(@RequestBody(required = false) VQuery query) {
        return tBankInfoService.page(query);
    }

}