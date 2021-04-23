package com.doulin.admin.controller.shop;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TGoods;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TGoodsController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "商品控制器类")
@CrossOrigin
@RestController
@RequestMapping("/tgoods")
public class TGoodsController {

    @Autowired
    private TGoodsService tGoodsService;

    /**
     * 新增
     *
     * @param tGoods
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TGoods tGoods) {
        tGoodsService.save(tGoods);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tGoodsService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tGoods
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TGoods tGoods) {
        tGoodsService.updateById(tGoods);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TGoods detail(@RequestParam("id") Long id) {
        return tGoodsService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TGoods> userList(@RequestBody(required = false) VQuery query) {
        return tGoodsService.page(query);
    }

}