package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TUserAddress;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TUserAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TUserAddressController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(description = "TUserAddress Controller")
@RestController
@RequestMapping("/tUserAddress")
public class TUserAddressController {

    @Autowired
    private TUserAddressService tUserAddressService;

    /**
     * 新增
     *
     * @param tUserAddress
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TUserAddress tUserAddress) {
        tUserAddressService.save(tUserAddress);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tUserAddressService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tUserAddress
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TUserAddress tUserAddress) {
        tUserAddressService.updateById(tUserAddress);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TUserAddress detail(@RequestParam("id") Long id) {
        return tUserAddressService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TUserAddress> userList(@RequestBody(required = false) VQuery query) {
        return tUserAddressService.page(query);
    }

}