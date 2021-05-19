package com.doulin.admin.controller.system;

import com.doulin.admin.controller.common.BaseWebController;
import com.doulin.common.IPUtils;
import com.doulin.common.R;
import com.doulin.common.RandomValidateCodeUtil;
import com.doulin.common.ShiroUtils;
import com.doulin.common.content.SysContent;
import com.doulin.common.j2cache.CacheUtils;
import com.doulin.common.password.Encodes;
import com.doulin.common.token.SysUserTokenUtil;
import com.doulin.entity.SysUser;
import com.doulin.service.SysUserRoleService;
import com.doulin.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @className 系统登录控制器类
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/13 10:10
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController extends BaseWebController {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserRoleService userRoleService;

    @ApiOperation(value = "用户登录", httpMethod = "POST", notes = "{\n" +
            "    \"s\": {\n" +
            "        \"loginUserId\": \"登录用户userId\",\n" +
            "        \"page\": 0,\n" +
            "        \"rows\": 10\n" +
            "    },\n" +
            "    \"v\": {\n" +
            "        \"loginNo\": \"登录号\",\n" +
            "        \"passWord\": \"密码\",\n" +
            "        \"randomCode\": \"验证码\"\n" +
            "    }\n" +
            "}")
    @PostMapping("/in")
    public Object login(HttpServletRequest request,@RequestBody Map<String,Object> requestMap) {
        Map<String, Object> map = getVvalue(requestMap);
        Object loginNo = map.get(SysContent.LOGINNO_STR);
        Object password = map.get(SysContent.PASSWORD);
        Object randomCode = map.get(SysContent.RANDOMCODE);
        if (null == loginNo || null == password) {
            return R.error("登录的账号或密码不能为空");
        }
        //从session中获取随机数
        try {
            String ip = IPUtils.getIpAddr(request)+ RandomValidateCodeUtil.RANDOMCODEKEY;
            String random = CacheUtils.get(ip).toString();
            if (random.equals(randomCode.toString())) {
            } else {
                return R.error("请输入正确的验证码");
            }
        } catch (Exception e) {
            return R.error("验证码已失效");
        }
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginNo.toString(), password.toString());
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(usernamePasswordToken);

                SysUser sysUser=userService.getOneByLoginNo(loginNo.toString());
                sysUser.setLastLoginDate(new Date());
                sysUser.setLastLoginIp(IPUtils.getIpAddr(request));
                userService.updateById(sysUser);
//                SecurityUtils.getSubject().getSession().setTimeout(1000*60*30);
//                Serializable token = subject.getSession().getId();

                Map<String,Object> result=new HashMap<>();
                String token=SysUserTokenUtil.getToken(loginNo.toString(),sysUser.getId().toString(),IPUtils.getIpAddr(request));
                result.put(SysUserTokenUtil.tokenHeard,token);
                result.put(SysContent.LOGIN_USERID,sysUser.getId());
                result.put(SysContent.LOGO,sysUser.getPhoto());
                result.put(SysContent.NAME_STR,sysUser.getRealName());
                result.put(SysContent.MENU_STR, Encodes.encodeBase64(sysUser.getMenuId()));
                result.put(SysContent.ROLE_STR,sysUser.getRoleId());

                return R.ok((Object) result);
            } catch (AuthenticationException e) {
                return R.error("用户或密码错误");
            }

        } catch (Exception e) {
            return R.error("登录异常");
        }
    }
    /**
     * 生成验证码
     */
    @ApiOperation(value = "获取验证码")
    @GetMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            String ip= IPUtils.getIpAddr(request);
            randomValidateCode.getRandcode(request, response,ip);//输出验证码图片方法
        } catch (Exception e) {
            log.error("获取验证码失败>>>> ", e);
        }
    }

    @ApiOperation(value = "安全登出")
    @PostMapping("/logout")
    public Object logout() {
        try {
            ShiroUtils.logout();
        } catch (Exception e) {
            log.error("登出*******"+e.getMessage());
            return R.error("注销失败");
        }
        return R.ok("退出成功");
    }


//    /**
//     * 管理登录
//     * @throws IOException
//     */
//    @ApiOperation(notes = "login", httpMethod = "POST", value = "用户登录")
//    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query",dataType = "string"),
//            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query",dataType = "string"),
//            @ApiImplicitParam(name="mobileLogin",value = "接口标志",required = true, paramType = "query",dataType = "string")})
//    @RequestMapping(value = "${adminPath}/login")
//    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Principal principal = UserUtils.getPrincipal();
//
//        if (logger.isDebugEnabled()){
//            logger.debug("login, active session size: {}", sessionDAO.getActiveSessions(false).size());
//        }
//
//        // 如果已登录，再次访问主页，则退出原账号。
//        if (Global.TRUE.equals(Global.getConfig("notAllowRefreshIndex"))){
//            CookieUtils.setCookie(response, "LOGINED", "false");
//        }
//
//        // 如果已经登录，则跳转到管理首页
//        if(principal != null && !principal.isMobileLogin()){
//            return "redirect:" + adminPath;
//        }
//
//
//        SavedRequest savedRequest = WebUtils.getSavedRequest(request);//获取跳转到login之前的URL
//        // 如果是手机没有登录跳转到到login，则返回JSON字符串
//        if(savedRequest != null){
//            String queryStr = savedRequest.getQueryString();
//            if(	queryStr!=null &&( queryStr.contains("__ajax") || queryStr.contains("mobileLogin"))){
//                AjaxJson j = new AjaxJson();
//                j.setSuccess(false);
//                j.setErrorCode("0");
//                j.setMsg("没有登录!");
//                return renderString(response, j);
//            }
//        }
//
//
//        return "modules/sys/login/sysLogin";
//    }




}
