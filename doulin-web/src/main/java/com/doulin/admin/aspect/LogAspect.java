package com.doulin.admin.aspect;


import com.doulin.admin.annotation.Log;
import com.doulin.admin.config.ApplicationContextRegister;
import com.doulin.common.HttpContextUtils;
import com.doulin.common.IPUtils;
import com.doulin.common.JSONUtils;
import com.doulin.common.ShiroUtils;
import com.doulin.entity.SysLog;
import com.doulin.entity.SysUser;
import com.doulin.mapper.SysLogMapper;
import com.doulin.mapper.SysUserMapper;
import com.doulin.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

//    @Autowired
//    private SysLogService logService;


    @Pointcut("@annotation(com.doulin.admin.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveLog(point, time);
        return result;
    }

    void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        Log syslog = method.getAnnotation(Log.class);
        if (syslog != null) {
            // 注解上的描述
            sysLog.setOperation(syslog.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = JSONUtils.beanToJson(args[0]).substring(0, 4999);
            sysLog.setParams(params);
        } catch (Exception e) {

        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));
        // 用户名
        SysUser currUser = ShiroUtils.getUser();
        if (null == currUser) {
            if (null != sysLog.getParams()) {
                sysLog.setUserId(sysLog.getUserId());
                sysLog.setParams(sysLog.getParams());
            } else {
                sysLog.setUserId(sysLog.getUserId());
                sysLog.setParams("获取用户信息为空");
            }
        } else {
            sysLog.setUserId(Integer.parseInt(ShiroUtils.getUserId().toString()));
            sysLog.setUserId(Integer.parseInt(ShiroUtils.getUser().getId().toString()));
        }
        sysLog.setTime((int) time);
        // 系统当前时间
        Date date = new Date();
        sysLog.setAddDt(date);
        SysLogMapper logService = ApplicationContextRegister.getBean(SysLogMapper.class);
        // 保存系统日志
        logService.insert(sysLog);
    }
}
