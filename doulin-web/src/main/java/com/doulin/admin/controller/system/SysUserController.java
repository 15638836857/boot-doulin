package com.doulin.admin.controller.system;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.MyException;
import com.doulin.common.R;
import com.doulin.common.content.ErrorContent;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysUser;
import com.doulin.entity.SysUserRole;
import com.doulin.service.SysUserRoleService;
import com.doulin.service.SysUserService;
import com.doulin.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
@RestController
@RequestMapping("/sysUser")
@Slf4j
public class SysUserController extends BaseWebController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

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
            "        \"loginNo\": \"登录号\",\n" +
            "        \"roleId\": \"角色id 多个角色使用逗号间隔\",\n" +
            "        \"telePhone\": \"联系方式\",\n" +
            "        \"password\": \"用户密码\",\n" +
            "        \"realName\": \"真实姓名\",\n" +
            "        \"email\": \"用户的邮箱\",\n" +
            "        \"deptId\": \"部门id\",\n" +
            "        \"deptIds\": \"部门ids\",\n" +
            "        \"birthDay\": \"生日\",\n" +
            "        \"sex\": \"性别 Y男  X女\",\n" +
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
            sysUser.setStatus(SysContent.N_STR);
            sysUser.setLoginFlag(SysContent.Y_STR);
            sysUser.setPassword(SystemService.entryptPassword(sysUser.getPassword()));
            boolean flag=sysUserService.addAndUpdate(SysContent.OPER_ADD,sysUser);
            if(flag){
                return R.ok();
            }else{
                return R.error(SysContent.ERROR_ADD);
            }
        } catch (Exception e) {
            log.error("sysUser/add"+e.getMessage());
            return R.error(e.getMessage());
        }
    }
    /**
     * 根据用户的id获取角色
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "根据用户的id获取角色", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"用户数据id \"\n" +
            "    }\n" +
            "}")
    @PostMapping("/getRoleByUserId")
    public Object getRoleByUserId(@RequestBody Map<String,Object> requestMap) {
        String id=getVvalue(requestMap).get(SysContent.ID_STR).toString();
        List<SysUserRole> list=sysUserRoleService.getListByUserId(Integer.valueOf(id));
        return R.ok(list);
    }
    @ApiOperation(value = "根据用户的id获取详情", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"用户数据id \"\n" +
            "    }\n" +
            "}")
    @PostMapping("/getByUserId")
    public Object getRInfoByUserId(@RequestBody Map<String,Object> requestMap) {
        String id=getVvalue(requestMap).get(SysContent.ID_STR).toString();
        List<SysUser> list=sysUserService.getInfoByUserId(Integer.valueOf(id));
        return R.ok(list);
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
            boolean flag = sysUserService.deleteByIds(ids,loginUserId);
            if (flag) {
                return R.ok();
            } else {
                return R.error();
            }
        } catch (MyException e) {
            log.error("sysUser/delete****" + e.getMessage());
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
            "        \"deptIds\": \"部门id 回显使用\",\n" +
            "        \"photo\": \"系统用户头像 base64字符串\",\n" +
            "        \"status\": \"账户是否锁定 \",\n" +
            "        \"loginFlag\": \"账户是否可以登录 Y/N\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/update")
    public Object update(@RequestBody Map<String,Object> requestMap) {
        SysUser sysUser = BeanUtil.toBean(getVvalue(requestMap), SysUser.class);
        try {
            sysUser.setEditBy(getLoginUserId(requestMap));
            sysUser.setEditDt(new Date());
            boolean flag = sysUserService.addAndUpdate(SysContent.OPER_EDIT, sysUser);
            if (flag) {
                return R.ok();
            } else {
                return R.error(SysContent.ERROR_EDIT);
            }
        } catch (MyException e) {
            log.error("sysUser/update***" + e.getMessage());
            return R.error(e.getMessage());
        }
    }
 /**
     * 更新
     *
     * @param requestMap
     */
    @ApiOperation(value = "系统用户个人资料修改", tags ={ "密码修改{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"用户id\",\n" +
            "        \"type\": \"1/用户质料  2 密码修改\",\n" +
            "        \"oldPassword\": \"旧密码\",\n" +
            "        \"newPassword\": \"新密码\"\n" +
            "    }\n" +
            "}","基础信息修改{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"id\": \"用户id\",\n" +
            "        \"type\": \"1/用户质料  2 密码修改\",\n" +
            "        \"realName\": \"真实姓名\",\n" +
            "        \"telePhone\": \"联系方式\",\n" +
            "        \"email\": \"邮箱\",\n" +
            "        \"birthDay\": \"生日\",\n" +
            "        \"sex\": \"性别 Y男  X女\",\n" +
            "        \"provinceId\": \"省id\",\n" +
            "        \"cityId\": \"城市id\",\n" +
            "        \"areaId\": \"区id\",\n" +
            "        \"address\": \"地址\",\n" +
            "        \"hobby\": \"爱好\",\n" +
            "        \"photo\": \"系统用户头像 base64字符串\"\n" +
            "    }\n" +
            "}"
    }
    )
    @PostMapping("/updatePassword")
    public Object updatePassword(@RequestBody Map<String,Object> requestMap) {
        Map<String,Object> vmap=getVvalue(requestMap);
        try {
            String type=vmap.get(SysContent.TYPE_STR).toString();
            if(SysContent.INTGER_2.toString().equals(type)) {
                String id = vmap.get(SysContent.ID_STR).toString();
                String oldPassWord = vmap.get("oldPassword").toString();
                String newPassword = vmap.get("newPassword").toString();
                SysUser dbUser = sysUserService.getById(id);
                boolean flag = SystemService.validatePassword(oldPassWord, dbUser.getPassword());
                if (!flag) {
                    throw new Exception("旧密码错误");
                }else{
                    dbUser.setEditDt(new Date());
                    dbUser.setEditBy(getLoginUserId(requestMap));
                    dbUser.setPassword(SystemService.entryptPassword(newPassword));
                    return R.ok(SysContent.EDIT_SUCCESS);
                }
             //基础质料修改
            }else if(SysContent.INTGER_1.toString().equals(type)){
                SysUser sysUser = BeanUtil.toBean(getVvalue(requestMap), SysUser.class);
                boolean flag = sysUserService.save(sysUser);
                if (flag) {
                    return R.ok(SysContent.EDIT_SUCCESS);
                } else {
                    return R.error(SysContent.ERROR_EDIT);
                }
            }else{
                throw new Exception(SysContent.ERROR_PARAM);
            }

        } catch (Exception e) {
            log.error("sysUser/updatePassword******" + e.getMessage());
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
            "        \"page\": 1,\n" +
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
            user.setPassword(null);
            return R.ok(user);
        }else{
            return R.error(ErrorContent.ERROR_EMPTY);
        }
    }
    /**
     * 详情
     *
     * @param requestMap
     * @return
     */
    @ApiOperation(value = "管理员重置普通用户密码", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"passWord\": \"密码\",\n" +
            "        \"id\": \"数据id\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/admin/reset")
    public Object resetPassword(@RequestBody Map<String,Object> requestMap) {
        try {
            SysUser user = sysUserService.getById(getLoginUserId(requestMap));
            if (null != user && SysContent.SYS_ADMIN.equals(user.getLoginNo())) {
                String id = getVvalue(requestMap).get(SysContent.ID_STR).toString();
                SysUser upu = sysUserService.getById(id);
                upu.setEditBy(user.getId().toString());
                upu.setEditDt(new Date());
                String password = getVvalue(requestMap).get(SysContent.PASSWORD).toString();
                upu.setPassword(SystemService.entryptPassword(password));
                sysUserService.updateById(upu);
            } else {
                throw new Exception("用户无权限");
            }
            return R.ok(user);
        } catch (Exception e) {
            log.error("重置密码*****" + e.getMessage());
            return R.error(e.getMessage());
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
            "        \"page\": 1,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"telePhone\": \"用户联系手机号\",\n" +
            "        \"loginNo\": \"用户登录号\",\n" +
            "        \"realName\": \"真实姓名\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/page")
    public Object userList(@RequestBody Map<String,Object> requestMap) {
        IPage<SysUser> page= null;
        try {
            Map<String,Object> vmap=getPageParm(requestMap);
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