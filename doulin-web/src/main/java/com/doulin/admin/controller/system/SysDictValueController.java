package com.doulin.admin.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.entity.SysDictValue;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysDictValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * SysDictValueController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "字典值控制器类")
@RestController
@RequestMapping("/sysDictValue")
public class SysDictValueController extends BaseWebController {

    @Autowired
    private SysDictValueService sysDictValueService;

    /**
     * 新增
     *
     * @param sysDictValue
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysDictValue sysDictValue) {
        sysDictValueService.save(sysDictValue);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysDictValueService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param sysDictValue
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysDictValue sysDictValue) {
        sysDictValueService.updateById(sysDictValue);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysDictValue detail(@RequestParam("id") Long id) {
        return sysDictValueService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysDictValue> userList(@RequestBody(required = false) VQuery query) {
        return sysDictValueService.page(query);
    }

}