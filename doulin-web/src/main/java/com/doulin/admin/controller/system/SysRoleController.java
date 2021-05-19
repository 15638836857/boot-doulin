package com.doulin.admin.controller.system;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysRole;
import com.doulin.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * SysRoleController
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "系统角色控制器类")
@RestController
@RequestMapping("/sysRole")
@Slf4j
public class SysRoleController extends BaseWebController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 新增
     *
     * @param requestMap
     */
    @ApiOperation(value = "角色添加", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"roleName\": \"角色名称\",\n" +
            "        \"roleSign\": \"角色标识\",\n" +
            "        \"status\": \"0/正常  1/禁用\",\n" +
            "        \"remark\": \"角色描述\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        SysRole sysRole= BeanUtil.toBean(getVvalue(requestMap), SysRole.class);
        try {
            sysRole.setAddBy(getLoginUserId(requestMap));
            sysRole.setAddDt(new Date());
            sysRole.setDelFlag(SysContent.INTGER_0);
            sysRoleService.addAndUpdateParam(SysContent.OPER_ADD,sysRole);
            if(sysRoleService.save(sysRole)){
              return R.ok(SysContent.OK_OPER);
            }else{
                return R.error(SysContent.ERROR_ADD);
            }
        } catch (MyException e) {
            log.error("/sysRole/add" + e.getMessage());
            return R.error(e.getMessage());
        }

    }

    /**
     * 删除
     *
     * @param requestMap
     */
    @ApiOperation(value = "delete", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"1\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"角色id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(@RequestBody Map<String,Object> requestMap) {
        try {
            String loginUserId = getLoginUserId(requestMap);
            if (null == getVvalue(requestMap).get(SysContent.ID_STR)) {
                throw new MyException(SysContent.ERROR_ID);
            } else {
                Integer id = Integer.valueOf(getVvalue(requestMap).get(SysContent.ID_STR).toString());
                SysRole sysMenu = sysRoleService.getById(id);
                sysMenu.setEditBy(loginUserId);
                sysMenu.setEditDt(new Date());
                sysMenu.setDelFlag(SysContent.INTGER_1);
                sysRoleService.updateById(sysMenu);
            }
            return R.ok();
        } catch (MyException e) {
            log.error("/sysRole/delete" + e.getMessage());
            return R.error(e.getMessage());
        }

    }

    /**
     * 更新
     *
     * @param requestMap
     */
    @ApiOperation(value = "update", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"角色id\",\n" +
            "        \"roleName\": \"角色名称\",\n" +
            "        \"roleSign\": \"角色标识\",\n" +
            "        \"status\": \"0/正常  1/禁用\",\n" +
            "        \"remark\": \"角色描述\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
        SysRole sysRole = BeanUtil.toBean(getVvalue(requestMap), SysRole.class);
        try {
            sysRole.setEditBy(getLoginUserId(requestMap));
            sysRole.setEditDt(new Date());
            sysRoleService.addAndUpdateParam(SysContent.OPER_EDIT, sysRole);
            if (sysRoleService.updateById(sysRole)) {
                return R.ok(SysContent.OK_OPER);
            } else {
                return R.error(SysContent.ERROR_EDIT);
            }
        } catch (MyException e) {
            log.error("/sysRole/update" + e.getMessage());
            return R.error(e.getMessage());
        }
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
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"角色id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/detail")
    public Object detail(@RequestBody Map<String,Object> requestMap) {
        try {
            String idstr = getLoginUserId(requestMap);
            return R.ok(sysRoleService.getById(Integer.valueOf(idstr)));
        } catch (MyException e) {
            log.error("/sysRole/detail" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
     * 分页
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "角色数据分页", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"roleName\": \"角色名称\",\n" +
            "        \"roleSign\": \"角色标识\",\n" +
            "        \"remark\": \"角色描述\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object pageList(@RequestBody Map<String,Object> requestMap) {
        Map<String, Object> smap = getSvalue(requestMap);
        Map<String, Object> vmap = getVvalue(requestMap);
        vmap.putAll(smap);
        IPage<SysRole> pagelist = sysRoleService.pageInfo(vmap);
        if (SysContent.INTGER_0 < pagelist.getRecords().size()) {
            return R.ok(pagelist);
        } else {
            return R.error(SysContent.ERROR_EMPTY);
        }
    }

}