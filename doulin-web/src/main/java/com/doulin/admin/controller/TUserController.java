package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TUser;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TUserController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "用户控制器类")
@RestController
@RequestMapping("/tUser")
public class TUserController {

    @Autowired
    private TUserService tUserService;

    /**
     * 新增
     *
     * @param tUser
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TUser tUser) {
        tUserService.save(tUser);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tUserService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tUser
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TUser tUser) {
        tUserService.updateById(tUser);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TUser detail(@RequestParam("id") Long id) {
        return tUserService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TUser> userList(@RequestBody(required = false) VQuery query) {
        return tUserService.page(query);
    }

}