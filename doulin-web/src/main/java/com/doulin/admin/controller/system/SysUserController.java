package com.doulin.admin.controller.system;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.ErrorContent;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysUser;
import com.doulin.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Api(tags = "系统用户控制器类")
@RestController
@RequestMapping("/sysUser")
@Slf4j
public class SysUserController extends BaseWebController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 新增
     *
     * @param requestMap
     */
    @ApiOperation(value = "系统用户添加接口", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"telePhone\": \"手机号\",\n" +
            "        \"password\": \"用户密码\",\n" +
            "        \"realName\": \"真实姓名\",\n" +
            "        \"email\": \"用户的邮箱\",\n" +
            "        \"deptId\": \"部门id\",\n" +
            "        \"photo\": \"系统用户头像 base64字符串\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/add")
    public Object add(@RequestBody Map<String,Object> requestMap) {
        SysUser sysUser= BeanUtil.toBean(getVvalue(requestMap),SysUser.class);
        try {
            String loginuserid=getLoginUserId(requestMap);
            sysUser.setAddBy(loginuserid);
            sysUser.setAddDt(new Date());
            sysUser.setDelFlag(SysContent.INTGER_0);
            sysUser.setStatus(SysContent.INTGER_0);
            sysUser.setLoginFlag(SysContent.Y_STR);
            boolean flag=sysUserService.addAndUpdate(SysContent.OPER_ADD,sysUser);
            if(flag){
                return R.ok();
            }else{
                return R.error(SysContent.ERROR_ADD);
            }
        } catch (MyException e) {
            log.error("sysUser/add"+e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
     * 删除
     *
     * @param requstMap
     */
    @ApiOperation(value = "系统用户删除", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"用户id，多个使用逗号间隔\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/delete")
    public Object delete(@RequestBody Map<String,Object> requstMap) {
        try {
            String loginUserId = getLoginUserId(requstMap);
            String idstr = getVvalue(requstMap).get(SysContent.ID_STR).toString();
            List<Integer> ids = new ArrayList<>();
            String[] idArray = idstr.split(SysContent.EN_D);
            for (String s : idArray) {
                ids.add(Integer.valueOf(s));
            }
            boolean flag = sysUserService.deleteByIds(ids);
            if (flag) {
                return R.ok();
            } else {
                return R.error();
            }
        } catch (MyException e) {
            log.error("sysUser/delete" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
     * 更新
     *
     * @param requestMap
     */
    @ApiOperation(value = "系统用户编辑", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"用户id\",\n" +
            "        \"realName\": \"真实姓名\",\n" +
            "        \"email\": \"用户的邮箱\",\n" +
            "        \"deptId\": \"部门id\",\n" +
            "        \"photo\": \"系统用户头像 base64字符串\",\n" +
            "        \"status\": \"账户是否锁定 0/1\",\n" +
            "        \"loginFlag\": \"账户是否可以登录 Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
        SysUser sysUser = BeanUtil.toBean(getVvalue(requestMap), SysUser.class);
        try {
            Integer id = Integer.valueOf(getVvalue(requestMap).get(SysContent.ID_STR).toString());
            SysUser dbUser = sysUserService.getById(id);
            dbUser.setEditBy(getLoginUserId(requestMap));
            dbUser.setEditDt(new Date());
            dbUser.setRealName(sysUser.getRealName());
            dbUser.setEmail(sysUser.getEmail());
            dbUser.setDeptId(sysUser.getDeptId());
            dbUser.setStatus(sysUser.getStatus());
            dbUser.setLoginFlag(sysUser.getLoginFlag());
            boolean flag = sysUserService.addAndUpdate(SysContent.OPER_EDIT, dbUser);
            if (flag) {
                return R.ok();
            } else {
                return R.error(SysContent.ERROR_EDIT);
            }
        } catch (MyException e) {
            log.error("sysUser/update" + e.getMessage());
            return R.error(e.getMessage());
        }
    }

    /**
     * 详情
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "根据用户id获取用户的信息", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"用户id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/detail")
    public Object detail(@RequestBody Map<String,Object> requestMap) {
        String id=getVvalue(requestMap).get(SysContent.ID_STR).toString();
        SysUser user=sysUserService.getById(id);
        if(null!=user) {
            return R.ok(user);
        }else{
            return R.error(ErrorContent.ERROR_EMPTY);
        }
    }

    /**
     * 分页
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"telePhone\": \"用户手机号\",\n" +
            "        \"realName\": \"真实姓名\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object userList(@RequestBody Map<String,Object> requestMap) {
        IPage<SysUser> page= null;
        try {
            Map<String,Object> smap=getSvalue(requestMap);
            Map<String,Object> vmap=getVvalue(requestMap);
            vmap.putAll(smap);
            page = sysUserService.pageInfo(vmap);
            if(SysContent.INTGER_0==page.getRecords().size()){
                return R.error(SysContent.ERROR_EMPTY);
            }
            return R.ok(page);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return R.error(SysContent.ERROR_SELECT);

    }

}