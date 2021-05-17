package com.doulin.admin.controller.shop;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopMakeMeter;
import com.doulin.service.TShopMakeMeterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
* TShopMakeMeterController
* @Author malinging
* @Date 2021-05-04
**/
@Api(tags = "web商家物料信息")
@RestController
@CrossOrigin
@RequestMapping("web/tsmm")
@Slf4j
public class TShopMakeMeterWebController extends BaseWebController {

    @Autowired
    private TShopMakeMeterService tShopMakeMeterService;
    /**
    * 删除
    *
    * @param requestMap
    */
    @ApiOperation(value = "delete", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(@RequestParam Map<String,Object> requestMap) {
        try {
            String id = getVvalue(requestMap).get(SysContent.ID_STR).toString();
            tShopMakeMeterService.removeById(id);
            return R.ok();
        } catch (Exception e) {
            log.error("web/tsmm/delete******" + e.getMessage());
            return R.error(e.getMessage());
        }
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
            "        \"shopHomeName\": \"商家名称 模糊查询\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object userList(@RequestBody Map<String,Object> requestMap) {
        Map<String,Object> vmap=getPageParm(requestMap);
        IPage<TShopMakeMeter> page=tShopMakeMeterService.pageInfo(vmap);
        return R.ok(page);
    }

}