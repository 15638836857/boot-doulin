package com.doulin.admin.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 系统登录角色控制器类
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "系统登录角色菜单控制器类")
@CrossOrigin
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
            "        \"menuId\": \"菜单id 多个英文逗号间隔\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        try {

            Object roleId = getVvalue(requestMap).get("roleId");
            Object menuId = getVvalue(requestMap).get("menuId");
            if(null==roleId || null==menuId){
                throw new Exception("菜单不能为空");
            }
            List<SysRoleMenu> addList=new ArrayList<>();
            String[] strings=menuId.toString().split(SysContent.EN_D);
            for (String string : strings) {
                SysRoleMenu srm = new SysRoleMenu();
                srm.setAddBy(getLoginUserId(requestMap));
                srm.setAddDt(new Date());
                srm.setDelFlag(SysContent.INTGER_0);
                srm.setMenuId(string);
                srm.setRoleId(roleId.toString());
                addList.add(srm);
            }
            sysRoleMenuService.remove(new QueryWrapper<SysRoleMenu>().eq("role_id",roleId));
            sysRoleMenuService.saveBatch(addList);
        } catch (Exception e) {
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
//    @ApiOperation(value = "编辑接口", notes = "{\n" +
//            "    \"s\": {\n" +
//            "        \"loginUserId\": \"登录用户userId\",\n" +
//            "        \"page\": 1,\n" +
//            "        \"rows\": 10\n" +
//            "    },\n" +
//            "    \"v\": {\n" +
//            "        \"roleId\": \"角色id\",\n" +
//            "        \"menuId\": \"菜单id\"\n" +
//            "    }\n" +
//            "}")
//    @PostMapping("/update")
//    public Object update(@RequestBody Map<String,Object> requestMap) {
//        try {
//            Object menuId = getVvalue(requestMap).get("menuId");
//            Object roleId = getVvalue(requestMap).get("roleId");
//            if(null==roleId || null==menuId){
//                throw new Exception("菜单不能为空");
//            }
//            List<SysRoleMenu> addList=new ArrayList<>();
//            String[] strings=menuId.toString().split(SysContent.EN_D);
//            for (String string : strings) {
//                SysRoleMenu srm = new SysRoleMenu();
//                srm.setAddBy(getLoginUserId(requestMap));
//                srm.setAddDt(new Date());
//                srm.setDelFlag(SysContent.INTGER_0);
//                srm.setMenuId(string);
//                srm.setRoleId(roleId.toString());
//                addList.add(srm);
//            }
//
//            sysRoleMenuService.remove(new QueryWrapper<SysRoleMenu>().eq("role_id",roleId));
//            sysRoleMenuService.saveBatch(addList);
//        } catch (Exception e) {
//            log.error("srm/update" + e.getMessage());
//            return R.error(e.getMessage());
//        }
//        return R.ok();
//    }

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
            "        \"roleId\": \"菜单 \"\n" +
            "    }\n" +
            "}")
    @PostMapping("/detailByRoleId")
    public Object detail(@RequestBody Map<String,Object> requestMap) {
        String roleId=getVvalue(requestMap).get(SysContent.ROLEID).toString();
        List<SysRoleMenu> sysRoleMenu= sysRoleMenuService.getListByRoleId(roleId);
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