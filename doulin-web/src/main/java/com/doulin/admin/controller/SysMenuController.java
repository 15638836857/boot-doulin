package com.doulin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysMenu;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * SysMenuController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "系统菜单控制器类")
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 新增
     *
     * @param sysMenu
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysMenuService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param sysMenu
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateById(sysMenu);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysMenu detail(@RequestParam("id") Long id) {
        return sysMenuService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysMenu> userList(@RequestBody(required = false) VQuery query) {
        return sysMenuService.page(query);
    }

}