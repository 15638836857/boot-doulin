package com.doulin.admin.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysRole;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * SysRoleController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "系统控制器类")
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 新增
     *
     * @param sysRole
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysRole sysRole) {
        sysRoleService.save(sysRole);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysRoleService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param sysRole
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysRole sysRole) {
        sysRoleService.updateById(sysRole);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysRole detail(@RequestParam("id") Long id) {
        return sysRoleService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysRole> userList(@RequestBody(required = false) VQuery query) {
        return sysRoleService.page(query);
    }

}