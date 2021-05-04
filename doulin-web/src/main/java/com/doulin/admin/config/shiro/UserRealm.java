package com.doulin.admin.config.shiro;

import com.doulin.admin.config.ApplicationContextRegister;
import com.doulin.common.content.SysContent;
import com.doulin.common.spring.SpringUtils;
import com.doulin.entity.SysUser;
import com.doulin.service.SysUserRoleService;
import com.doulin.service.SysUserService;
import com.doulin.service.SystemService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserRealm extends AuthorizingRealm {
/*	@Autowired
	UserDao userMapper;
	@Autowired
	MenuService menuService;*/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
//        Long userId = ShiroUtils.getUserId();
//        SysMenuService menuService = ApplicationContextRegister.getBean(SysMenuService.class);
//        Set<String> perms = menuService.listPerms(userId);
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(perms);
//        return info;
        log.info("============用户授权==============");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        /*获取当前的用户,已经登录后可以使用在任意的地方获取用户的信息*/
        String loginNo = (String) SecurityUtils.getSubject().getPrincipal();
        /*查询用户的权限*/
        SysUserRoleService userRoleService= SpringUtils.getObject(SysUserRoleService.class);

        List<Integer> userRoles=userRoleService.getListByLoginNo(loginNo);
        List<String> stringList=new ArrayList<>();
        for (Integer userRole : userRoles) {
            stringList.add(userRole.toString());
        }
        /*将role放在一个集合中,多个权限使用集合*/
        String roleids=String.join(SysContent.EN_D,stringList);
        info.addRole(roleids);
        return info;


    }

    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if(null==token.getPrincipal()||null==token.getCredentials()){
            throw new UnknownAccountException("请先登录");
        }
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        SysUserService userService = ApplicationContextRegister.getBean(SysUserService.class);
        // 查询用户信息
        SysUser user = userService.getOneByLoginNo(username);

        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        // 密码错误
        if (!SystemService.validatePassword(password,user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        // 账号锁定
        if (user.getStatus().equals(SysContent.Y_STR)) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

}
