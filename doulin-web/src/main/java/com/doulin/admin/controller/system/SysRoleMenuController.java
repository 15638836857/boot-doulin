package com.doulin.admin.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysRoleMenu;
import com.doulin.service.SysRoleMenuService;
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
import java.util.List;
import java.util.Map;

/**
 * 系统登录角色控制器类
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "系统登录角色控制器类")
@RestController
@RequestMapping("/srm")
@Slf4j
public class SysRoleMenuController  extends BaseWebController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 新增
     *
     * @param requestMap
     */
    @ApiOperation(value = "添加接口", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"roleId\": \"角色id\",\n" +
            "        \"menuId\": \"菜单id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        try {
            SysRoleMenu srm = new SysRoleMenu();
            Object roleId = getVvalue(requestMap).get("roleId");
            Object menuId = getVvalue(requestMap).get("menuId");
            srm.setAddBy(getLoginUserId(requestMap));
            srm.setAddDt(new Date());
            srm.setDelFlag(SysContent.INTGER_0);
            srm.setMenuId(Integer.valueOf(menuId.toString()));
            srm.setRoleId(Integer.valueOf(roleId.toString()));
            sysRoleMenuService.save(srm);
        } catch (MyException e) {
            log.error("srm/add" + e.getMessage());
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    /**
     * 删除
     * @param requsetMap
     */
    @ApiOperation(value = "删除", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id 多个使用英文逗号间隔\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(@RequestBody Map<String,Object> requsetMap) {
        try {
            String loginuseid=getLoginUserId(requsetMap);
            String ids=getVvalue(requsetMap).get(SysContent.ID_STR).toString();
            sysRoleMenuService.deleteByIds(Arrays.asList(ids), loginuseid);
            return R.ok();
        } catch (MyException e) {
            log.error("srm/delete" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
     * 更新
     * @param requestMap
     */
    @ApiOperation(value = "编辑接口", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\",\n" +
            "        \"roleId\": \"角色id\",\n" +
            "        \"menuId\": \"菜单id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
        try {
            SysRoleMenu srm = new SysRoleMenu();
            Object id = getVvalue(requestMap).get("id");
            Object roleId = getVvalue(requestMap).get("roleId");
            Object menuId = getVvalue(requestMap).get("menuId");
            srm.setEditBy(getLoginUserId(requestMap));
            srm.setEditDt(new Date());
            srm.setMenuId(Integer.valueOf(menuId.toString()));
            srm.setRoleId(Integer.valueOf(roleId.toString()));
            sysRoleMenuService.updateById(srm);
        } catch (MyException e) {
            log.error("srm/update" + e.getMessage());
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
            "        \"id\": \"数据id \"\n" +
            "    }\n" +
            "}")
    @PostMapping("/detail")
    public Object detail(@RequestBody Map<String,Object> requestMap) {
        String id=getVvalue(requestMap).get(SysContent.ID_STR).toString();
        SysRoleMenu sysRoleMenu= sysRoleMenuService.getOneById(Integer.valueOf(id));
        return R.ok(sysRoleMenu);
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
            "        \"roleName\":\"\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object pageList(@RequestBody Map<String,Object> requestMap) {
        Map<String, Object> smap = getVvalue(requestMap);
        Map<String, Object> vmap = getVvalue(requestMap);
        vmap.putAll(smap);
        List<SysRoleMenu> list = sysRoleMenuService.pageInfo(vmap);
        Integer count = sysRoleMenuService.countByMap(vmap);
        IPage<SysRoleMenu> page=new Page<>();
        if(SysContent.INTGER_0==count){
            return R.error(SysContent.ERROR_EMPTY);
        }
        page.setTotal(Long.valueOf(count.toString()));
        page.setRecords(list);
        return R.ok(page);
    }
}