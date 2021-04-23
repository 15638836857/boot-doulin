package com.doulin.admin.controller.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TAbout;
import com.doulin.service.TAboutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
* TAboutController
* @Author malinging
* @Date 2021-04-23
**/
@Api(description = "关于我们")
@RestController
@RequestMapping("/tAbout")
public class TAboutController extends BaseWebController{

    @Autowired
    private TAboutService tAboutService;

    /**
    * 新增
    *
    * @param tAbout
    */
    @ApiOperation(value = "add", notes = "")
    @PostMapping("/add")
    public void add(@RequestBody TAbout tAbout) {
        tAboutService.save(tAbout);
    }

    /**
    * 删除
    *
    * @param ids
    */
    @ApiOperation(value = "delete", notes = "")
    @GetMapping("/delete")
    public void delete(@RequestParam("ids") Long... ids) {
        tAboutService.removeByIds(Arrays.asList(ids));
    }

    /**
    * 更新
    *
    * @param tAbout
    */
    @ApiOperation(value = "update", notes = "")
    @PostMapping("/update")
    public void update(@RequestBody TAbout tAbout) {
        tAboutService.updateById(tAbout);
    }

    /**
    * 详情
    *
    * @param id
    * @return
    */
    @ApiOperation(value = "detail", notes = "")
    @GetMapping("/detail")
    public TAbout detail(@RequestParam("id") Long id) {
        return tAboutService.getById(id);
    }

    /**
    * 分页
    *
    * @param requestMap
    * @return
    */
    @ApiOperation(value = "page", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"value\": \"关键字查询\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object userList(@RequestBody Map<String,Object> requestMap) {
        Map<String,Object> smap=getSvalue(requestMap);
        Map<String,Object> vmap=getVvalue(requestMap);
        vmap.putAll(smap);
        IPage<TAbout> page=tAboutService.pageInfo(vmap);
        if(page.getRecords().isEmpty()){
            return R.error(SysContent.ERROR_EMPTY);
        }
        return R.ok(page);
    }

}