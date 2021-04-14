package com.doulin.admin.controller.system;

import cn.hutool.core.bean.BeanUtil;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysMenu;
import com.doulin.entity.edo.Tree;
import com.doulin.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统菜单控制器
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "系统菜单控制器类")
@RestController
@RequestMapping("/sysMenu")
@Slf4j
public class SysMenuController extends BaseWebController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 新增
     *
     * @param requestMap
     */
    @ApiOperation(value = "系统菜单添加", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"parentId\": \"父级id 默认传0\",\n" +
            "        \"name\": \"菜单名称\",\n" +
            "        \"type\": \"菜单类型 1菜单 2 按钮\",\n" +
            "        \"icon\": \"图标名称\",\n" +
            "        \"orderNum\": \"排序\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        SysMenu sysMenu = getByRequestMap(requestMap);
        try {
            sysMenu.setAddBy(getLoginUserId(requestMap));
            sysMenu.setAddDt(new Date());
            sysMenu.setDelFlag(SysContent.INTGER_0);
            sysMenuService.addAndUpdateParam(SysContent.OPER_ADD, sysMenu);
            sysMenuService.save(sysMenu);
        } catch (MyException e) {
            log.error("/sysMenu/add" + e.getMessage());
            return R.error(e.getMessage());
        }
        return R.ok(SysContent.OK_OPER);
    }

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
    @GetMapping("/delete")
    public Object delete(@RequestBody Map<String,Object> requestMap) {
        try {
            String loginUserId = getLoginUserId(requestMap);
            Integer id = Integer.valueOf(getVvalue(requestMap).get(SysContent.ID_STR).toString());
            if (null != sysMenuService.getListByPid(id)) {
                throw new MyException("删除失败有子集信息");
            } else {
                SysMenu sysMenu = sysMenuService.getInfoById(id);
                sysMenu.setEditBy(loginUserId);
                sysMenu.setEditDt(new Date());
                sysMenu.setDelFlag(SysContent.INTGER_1);
                sysMenuService.updateById(sysMenu);
            }
            return R.ok();
        } catch (MyException e) {
            log.error("/sysMenu/delete" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
     * 更新
     *
     * @param requestMap
     */
    @ApiOperation(value = "菜单编辑", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"数据id\",\n" +
            "        \"parentId\": \"父级id 默认传0\",\n" +
            "        \"name\": \"菜单名称\",\n" +
            "        \"type\": \"菜单类型 1菜单 2 按钮\",\n" +
            "        \"icon\": \"图标名称\",\n" +
            "        \"orderNum\": \"排序\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
        SysMenu sysMenu = getByRequestMap(requestMap);
        try {
            sysMenu.setEditBy(getLoginUserId(requestMap));
            sysMenu.setEditDt(new Date());
            sysMenuService.addAndUpdateParam(SysContent.OPER_EDIT, sysMenu);
            sysMenuService.updateById(sysMenu);
        } catch (MyException e) {
            log.error("/sysMenu/update" + e.getMessage());
            return R.error(e.getMessage());
        }
        return R.ok(SysContent.OK_OPER);
    }

    /**
     * 详情
     *
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
    @GetMapping("/detail")
    public Object detail(@RequestBody Map<String,Object> requestMap) {
        String id= null;
        try {
            id = (String) getVvalue(requestMap).get(SysContent.ID_STR);
            SysMenu sysMenu=sysMenuService.getInfoById(Integer.valueOf(id));
            if(null!=sysMenu){
                return R.ok(sysMenu);
            }else{
                return R.error(SysContent.ERROR_EMPTY);
            }
        } catch (Exception e) {
           log.error("/sysRole/detail"+e.getMessage());
           return R.error(e.getMessage());
        }
    }
    /**
     * 根据pid 获取下一级信息
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "根据pid 获取下一级信息", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"父级数据id\"\n" +
            "    }\n" +
            "}")
    @GetMapping("/getInfoByPid")
    public Object getInfoByPid(@RequestBody Map<String,Object> requestMap) {
        String pid= null;
        try {
            pid = (String) getVvalue(requestMap).get(SysContent.ID_STR);
            List<SysMenu> list=sysMenuService.getListByPid(Integer.valueOf(pid));
            if(null!=list){
                return R.ok(list);
            }else{
                return R.error(SysContent.ERROR_EMPTY);
            }
        } catch (Exception e) {
           log.error("/sysRole/getInfoByPid"+e.getMessage());
           return R.error(e.getMessage());
        }
    }

    /**
     * @return
     */
    @ApiOperation(value = "获取列表信息接口", notes = "无")
    @PostMapping("/getMenuList")
    public Tree<SysMenu> menuList() {
        Tree<SysMenu> tree = sysMenuService.getTree();
        return tree;
    }


    private SysMenu getByRequestMap(Map<String,Object> requestMap){
        return BeanUtil.toBean(requestMap,SysMenu.class);
    }
}