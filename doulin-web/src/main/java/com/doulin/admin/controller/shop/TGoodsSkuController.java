package com.doulin.admin.controller.shop;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TGoodsSku;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TGoodsSkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TGoodsSkuController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "产品规格控制器类")
@CrossOrigin
@RestController
@RequestMapping("/tgoodsSku")
public class TGoodsSkuController {

    @Autowired
    private TGoodsSkuService tGoodsSkuService;

    /**
     * 新增
     *
     * @param tGoodsSku
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TGoodsSku tGoodsSku) {
        tGoodsSkuService.save(tGoodsSku);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tGoodsSkuService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tGoodsSku
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TGoodsSku tGoodsSku) {
        tGoodsSkuService.updateById(tGoodsSku);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TGoodsSku detail(@RequestParam("id") Long id) {
        return tGoodsSkuService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TGoodsSku> userList(@RequestBody(required = false) VQuery query) {
        return tGoodsSkuService.page(query);
    }

}