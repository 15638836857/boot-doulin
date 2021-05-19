package com.doulin.WxCommons.task;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

public class TokenTaskParent {
//    @Autowired
//    private WeChatParams weChatParams;
    @Value("${wechat.appId}")
    private String appid;
    @Value("${wechat.appSecret}")
    private String appSecret;
    protected Logger logger;
    @Scheduled(cron= "0 0 0/1 * * ? ")
    public void refreshToken(){
        logger.info("刷新token定时任务开始执行......................");
        long timeMillis=System.currentTimeMillis()+7200*1000;
        Date timeOutDate=new Date(timeMillis);
//        weChatParams.setAccessToken(WeChatUtil.getAccessToken(appid,appSecret));
//        weChatParams.setTokenTimeOutTime(timeOutDate);
//        weChatParams.setApiTicket(WeChatUtil.getApiTicket(weChatParams.getAccessToken()));
//        weChatParams.setTicketTimeOutTime(timeOutDate);
        logger.info("刷新token定时任务已完成......................");
    }
}
