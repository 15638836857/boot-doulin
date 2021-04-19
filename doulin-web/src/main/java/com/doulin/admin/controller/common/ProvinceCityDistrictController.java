package com.doulin.admin.controller.common;

import com.doulin.entity.ProvinceCityDistrict;
import com.doulin.entity.edo.Tree;
import com.doulin.service.ProvinceCityDistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* ProvinceCityDistrictController
* @Author malinging
* @Date 2021-04-15
**/
@Api(description = "ProvinceCityDistrict Controller",tags = "省市区")
@RestController
@RequestMapping("/pcd")
public class ProvinceCityDistrictController {

    @Autowired
    private ProvinceCityDistrictService provinceCityDistrictService;
    @ApiOperation(value = "getTree", notes = "无")
    @PostMapping("/getTree")
    public Object getTree() {
        Tree<ProvinceCityDistrict> tree =provinceCityDistrictService.getTree();
        return tree ;
    }


//    /**
//    * 新增
//    *
//    * @param provinceCityDistrict
//    */
//    @ApiOperation(value = "add", notes = "")
//    @PostMapping("/add")
//    public void add(@RequestBody ProvinceCityDistrict provinceCityDistrict) {
//        provinceCityDistrictService.save(provinceCityDistrict);
//    }
//
//    /**
//    * 删除
//    *
//    * @param ids
//    */
//    @ApiOperation(value = "delete", notes = "")
//    @GetMapping("/delete")
//    public void delete(@RequestParam("ids") Long... ids) {
//        provinceCityDistrictService.removeByIds(Arrays.asList(ids));
//    }
//
//    /**
//    * 更新
//    *
//    * @param provinceCityDistrict
//    */
//    @ApiOperation(value = "update", notes = "")
//    @PostMapping("/update")
//    public void update(@RequestBody ProvinceCityDistrict provinceCityDistrict) {
//        provinceCityDistrictService.updateById(provinceCityDistrict);
//    }
//
//    /**
//    * 详情
//    *
//    * @param id
//    * @return
//    */
//    @ApiOperation(value = "detail", notes = "")
//    @GetMapping("/detail")
//    public ProvinceCityDistrict detail(@RequestParam("id") Long id) {
//        return provinceCityDistrictService.getById(id);
//    }
//
//    /**
//    * 分页
//    *
//    * @param query
//    * @return
//    */
//    @ApiOperation(value = "page", notes = "")
//    @PostMapping("/page")
//    public IPage<ProvinceCityDistrict> userList(@RequestBody(required = false) VQuery query) {
//        return provinceCityDistrictService.page(query);
//    }

}