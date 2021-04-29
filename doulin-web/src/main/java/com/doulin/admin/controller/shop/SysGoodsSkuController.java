package com.doulin.admin.controller.shop;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.SysGoodsSku;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.SysGoodsSkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
* SysGoodsSkuController
* @Author malinging
* @Date 2021-04-27
**/
@Api(description = "系统商品规格")
@CrossOrigin
@RestController
@RequestMapping("/sysGoodsSku")
public class SysGoodsSkuController {

    @Autowired
    private SysGoodsSkuService sysGoodsSkuService;

    /**
    * 新增
    *
    * @param sysGoodsSku
    */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody SysGoodsSku sysGoodsSku) {
        sysGoodsSkuService.save(sysGoodsSku);
    }

    /**
    * 删除
    *
    * @param ids
    */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        sysGoodsSkuService.removeByIds(Arrays.asList(ids));
    }

    /**
    * 更新
    *
    * @param sysGoodsSku
    */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody SysGoodsSku sysGoodsSku) {
        sysGoodsSkuService.updateById(sysGoodsSku);
    }

    /**
    * 详情
    *
    * @param id
    * @return
    */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public SysGoodsSku detail(@RequestParam("id") Long id) {
        return sysGoodsSkuService.getById(id);
    }

    /**
    * 分页
    *
    * @param query
    * @return
    */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<SysGoodsSku> userList(@RequestBody(required = false) VQuery query) {
        return sysGoodsSkuService.page(query);
    }

}