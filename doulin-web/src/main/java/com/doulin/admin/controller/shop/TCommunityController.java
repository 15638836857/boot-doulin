package com.doulin.admin.controller.shop;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TCommunity;
import com.doulin.service.TCommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
* TCommunityController
* @Author malinging
* @Date 2021-04-15
**/
@Api(description = "TCommunity Controller",tags = "社区管理控制器")
@CrossOrigin
@RestController
@RequestMapping("/tccy")
@Slf4j
public class TCommunityController extends BaseWebController {

    @Autowired
    private TCommunityService tCommunityService;

    /**
    * 新增
    * @param requestMap
    */
    @ApiOperation(value = "社区添加", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"communityName\": \"社区名称\",\n" +
            "        \"communityAddress\": \"社区地址\",\n" +
            "        \"communityLogo\": \"社区logo  base64字符串\",\n" +
            "        \"provinceId\": \"省份id\",\n" +
            "        \"cityId\": \"城市id\",\n" +
            "        \"districtId\": \"县区id\",\n" +
            "        \"communityState\": \"是否禁用 Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        TCommunity tCommunity = BeanUtil.toBean(getVvalue(requestMap), TCommunity.class);
        try {
            tCommunity.setAddBy(getLoginUserId(requestMap));
            tCommunity.setAddDt(new Date());
            tCommunity.setDelFlag(SysContent.INTGER_0);
            tCommunityService.addAndUpdateParam(SysContent.OPER_ADD, tCommunity);
            tCommunityService.save(tCommunity);
        } catch (MyException e) {
            log.error("tccy/add" + e.getMessage());
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    /**
    * 删除
    *
    * @param requestMap
    */
    @ApiOperation(value = "删除", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id 多个使用逗号间隔\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(@RequestBody Map<String,Object> requestMap) {
        String ids=getVvalue(requestMap).get(SysContent.ID_STR).toString();
        try {
            tCommunityService.deleteBatchByIds(getLoginUserId(requestMap),Arrays.asList(ids));
        } catch (MyException e) {
            log.error("tccy/delete" + e.getMessage());
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    /**
    * 更新
    *
    * @param requestMap
    */
    @ApiOperation(value = "修改", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\",\n" +
            "        \"communityName\": \"社区名称\",\n" +
            "        \"communityAddress\": \"社区地址\",\n" +
            "        \"communityLogo\": \"社区logo  base64字符串\",\n" +
            "        \"provinceId\": \"省份id\",\n" +
            "        \"cityId\": \"城市id\",\n" +
            "        \"districtId\": \"县区id\",\n" +
            "        \"communityState\": \"是否禁用 Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
        TCommunity tCommunity = BeanUtil.toBean(getVvalue(requestMap), TCommunity.class);
        try {
            tCommunity.setEditBy(getLoginUserId(requestMap));
            tCommunity.setEditDt(new Date());
            tCommunityService.addAndUpdateParam(SysContent.OPER_ADD, tCommunity);
            tCommunityService.updateById(tCommunity);
        } catch (MyException e) {
            log.error("tccy/update" + e.getMessage());
            return R.error(e.getMessage());
        }
        return R.ok();


    }

    /**
    * 详情
    *
    * @param requestMap
    * @return
    */
    @ApiOperation(value = "根据id获取详情", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/detail")
    public Object detail(@RequestBody Map<String,Object> requestMap) {
        Object id=getVvalue(requestMap).get(SysContent.ID_STR);
        TCommunity community=tCommunityService.getOneById(Integer.valueOf(id.toString()));
        return R.ok(community);
    }

    /**
    * 分页
    *
    * @param requestMap
    * @return
    */
    @ApiOperation(value = "分页数据", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"value\": \"社区名称\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object userList(@RequestBody Map<String,Object> requestMap) {
        Map<String,Object> smap=getSvalue(requestMap);
        Map<String,Object> vmap=getVvalue(requestMap);
        vmap.putAll(smap);
        IPage<TCommunity> page=tCommunityService.pageInfo(vmap);
        if(page.getRecords().size()>0){
            return R.ok(page);
        }
        return R.error(SysContent.ERROR_EMPTY);
    }

}