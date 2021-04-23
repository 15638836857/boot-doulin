package com.doulin.admin.controller.shop;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TOrder;
import com.doulin.entity.vo.VQuery;
import com.doulin.service.TOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TOrderController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "用户订单控制器类")
@CrossOrigin
@RestController
@RequestMapping("/torder")
public class TOrderController {

    @Autowired
    private TOrderService tOrderService;

    /**
     * 新增
     *
     * @param tOrder
     */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TOrder tOrder) {
        tOrderService.save(tOrder);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tOrderService.removeByIds(Arrays.asList(ids));
    }

    /**
     * 更新
     *
     * @param tOrder
     */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TOrder tOrder) {
        tOrderService.updateById(tOrder);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TOrder detail(@RequestParam("id") Long id) {
        return tOrderService.getById(id);
    }

    /**
     * 分页
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "page", notes = "")
    @PostMapping("/page")
    public IPage<TOrder> userList(@RequestBody(required = false) VQuery query) {
        return tOrderService.page(query);
    }

}