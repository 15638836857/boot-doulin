//package com.doulin.WxCommons.authorize;
//
//import com.alibaba.fastjson.JSONObject;
//import com.doulin.entity.TUser;
//import com.doulin.service.TUserService;
//import com.doulin.WxCommons.utils.AuthUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//public class WxAuthController {
//    @Value("${wechat.appId}")
//    private String appId;
//    @Value("${wechat.appSecret}")
//    private String appSecret;
//
//    @Autowired
//    private TUserService userService;
//
//
//
//    protected Integer type;
//
//
//    /**
//     * 判断用户是否注册过 如果没有注册自动注册
//     * @param req
//     * @param res
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/callBack")
//    public String callBack(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        String code = req.getParameter("code");
//        String redUrl=req.getParameter("redUrl");
//
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
//                + appId + "&secret="
//                + appSecret + "&code="
//                + code + "&grant_type=authorization_code";
//        JSONObject jsonObject = AuthUtil.doGetJson(url);
//
//        String openid = jsonObject.getString("openid");
//        String token = jsonObject.getString("access_token");
//        TUser userInfo = userService.getByOpenidAndType(openid);
//        HttpSession session=req.getSession();
//        if(userInfo==null) {//userInfo.getIsAutoLogin().equals(1)
//            String refreshToken = jsonObject.getString("refresh_token");
//            userInfo = new TUser();
//            userInfo.setWxAccessToken(token);
//            userInfo.setWxOperid(openid);
//            userService.save(userInfo);
//        }
//        session.setAttribute("openid", openid);
//        session.setAttribute("userInfo", userInfo);
//        session.setAttribute("token",token);
//        return "redirect:"+redUrl;
//    }
//}
