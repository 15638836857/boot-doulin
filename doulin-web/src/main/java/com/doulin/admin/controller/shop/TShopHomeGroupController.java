package com.doulin.admin.controller.shop;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopHomeGroup;
import com.doulin.service.TShopHomeGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 商家类型接口控制器类
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "商家分组控制器类")
@RestController
@RequestMapping("/tshg")
@Slf4j
public class TShopHomeGroupController extends BaseWebController {

    @Autowired
    private TShopHomeGroupService tShopHomeGroupService;

    /**
     * 新增
     * @param requestMap
     */
    @ApiOperation(value = "add", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"groupImg\": \"分类图标 base64字符串\",\n" +
            "        \"groupName\": \"分类名称\",\n" +
            "        \"status\": \"是否被禁用 Y/N\",\n" +
            "        \"sort\": \"排序\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        TShopHomeGroup tShopHomeGroup= BeanUtil.toBean(requestMap,TShopHomeGroup.class);
        try {
            tShopHomeGroup.setAddBy(getLoginUserId(requestMap));
            tShopHomeGroup.setAddDt(new Date());
            tShopHomeGroup.setDelFlag(SysContent.INTGER_0);
            //时间戳
            tShopHomeGroup.setGroupCode(String.valueOf(System.currentTimeMillis()));
            tShopHomeGroupService.save(tShopHomeGroup);
        } catch (MyException e) {
           log.error("tshg/add"+e.getMessage());
           return R.error(e.getMessage());
        }
        return R.ok();
    }

    /**
     * 删除
     * @param requestMap
     */
    @ApiOperation(value = "delete", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id 多个数据id使用英文逗号间隔\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(Map<String,Object> requestMap) {
        String ids=getVvalue(requestMap).get(SysContent.ID_STR).toString();
        try {
            String loginUserId=getLoginUserId(requestMap);
            tShopHomeGroupService.removeBatchByIds(loginUserId,Arrays.asList(ids));
        } catch (MyException e) {
            log.error("tshg/delete"+e.getMessage());
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    /**
     * 更新
     * @param requestMap
     */
    @ApiOperation(value = "update", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\",\n" +
            "        \"groupImg\": \"分类图标 base64字符串\",\n" +
            "        \"groupName\": \"分类名称\",\n" +
            "        \"status\": \"是否被禁用 Y/N\",\n" +
            "        \"sort\": \"排序\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
        TShopHomeGroup tShopHomeGroup= BeanUtil.toBean(requestMap,TShopHomeGroup.class);
        try {
            tShopHomeGroup.setEditBy(getLoginUserId(requestMap));
            tShopHomeGroup.setEditDt(new Date());
            tShopHomeGroupService.updateById(tShopHomeGroup);
        } catch (MyException e) {
            log.error("tshg/add"+e.getMessage());
            return R.error(e.getMessage());
        }
        return R.ok();
    }
    /**
     * 详情
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "detail", notes = "{\n" +
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
        Object id =getVvalue(requestMap).get(SysContent.ID_STR);
        return R.ok(tShopHomeGroupService.getById(Integer.valueOf(id.toString())));
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
            "        \"value\": \"名称查询\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object pageList(@RequestBody Map<String,Object> requestMap) {
        Map<String,Object> smap=getSvalue(requestMap);
        Map<String,Object> vmap=getVvalue(requestMap);
        vmap.putAll(smap);
        IPage<TShopHomeGroup> page=tShopHomeGroupService.pageInfo(vmap);
        if(page.getRecords().size()>0){
            return R.ok(page);
        }
        return R.error(SysContent.ERROR_EMPTY);
    }

}