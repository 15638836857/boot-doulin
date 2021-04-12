package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysUser;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * SysUserController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "系统用户控制器类")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 新增
     *
     * @param sysUser
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysUserService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param sysUser
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysUser sysUser) {
        sysUserService.updateById(sysUser);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysUser detail(@RequestParam("id") Long id) {
        return sysUserService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysUser> userList(@RequestBody(required = false) VQuery query) {
        return sysUserService.page(query);
    }

}