package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysRoleMenu;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysRoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * SysRoleMenuController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "系统登录角色控制器类")
@RestController
@RequestMapping("/sysRoleMenu")
public class SysRoleMenuController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 新增
     *
     * @param sysRoleMenu
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysRoleMenu sysRoleMenu) {
        sysRoleMenuService.save(sysRoleMenu);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysRoleMenuService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param sysRoleMenu
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysRoleMenu sysRoleMenu) {
        sysRoleMenuService.updateById(sysRoleMenu);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysRoleMenu detail(@RequestParam("id") Long id) {
        return sysRoleMenuService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysRoleMenu> userList(@RequestBody(required = false) VQuery query) {
        return sysRoleMenuService.page(query);
    }

}