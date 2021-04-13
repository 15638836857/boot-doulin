package com.doulin.admin.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysLog;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * SysLogController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "系统请求日志控制器类")
@RestController
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 新增
     *
     * @param sysLog
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysLog sysLog) {
        sysLogService.save(sysLog);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysLogService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param sysLog
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysLog sysLog) {
        sysLogService.updateById(sysLog);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysLog detail(@RequestParam("id") Long id) {
        return sysLogService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysLog> userList(@RequestBody(required = false) VQuery query) {
        return sysLogService.page(query);
    }

}