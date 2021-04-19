package com.doulin.mobile.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.doulin.common.date.DateFormatUtil;
import com.doulin.entity.common.ResJson;
import com.doulin.entity.common.SendSmsReq;
import com.doulin.entity.common.ServerTimeRes;
import com.doulin.entity.common.UserLoginReq;
import com.doulin.mobile.code.CommonServiceCode;
import com.doulin.mobile.code.ShopServiceCode;
import com.doulin.mobile.common.BaseAppController;
import com.doulin.service.UtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;

/**
 * @className LoginMobileController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/19 9:35
 * @Version 1.0
 */
@Api(tags = "移动端登录")
@RestController
@RequestMapping("app/api")
@Slf4j
public class LoginMobileController extends BaseAppController {
    @Autowired
    private UtilService utilService;
    @Autowired
    private CommonServiceCode csc;
    @Autowired
    private ShopServiceCode ssc;

    // 服务入口
    @ApiOperation(value = "服务入口")
    @PostMapping(value = "/service")
    public String service(HttpServletRequest request, HttpServletResponse response,   String json) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResJson res = new ResJson();
        try {
             json = URLDecoder.decode(json, "utf-8");
            if (StrUtil.isBlank(json)) {
                res.setResultNote("请求数据不能为空");
                return responseAppRes(res);
            }
            log.info("收：" + json);
            Map<String,Object> obj = getRequestCk(json);
            String cmd = obj.get("cmd").toString(); // 获取请求信息
            String type = obj.get("codeType").toString(); // 获取请求信息
            /**************** 用户端接口 *******************/
//            if ("phoneVerification".equals(cmd)) { // 1.0验证手机号
//                UserRegisterReq req =JSONUtil.toBean(json, UserRegisterReq.class);
//                  utilService.phoneFlag(type,req);
//            } else if ("userRegister".equals(cmd)) { // 1.1用户注册
////                res = usc.codec(request, req);
//            } else if ("phoneVerifCode".equals(cmd)) { // 1.72验证用户是否已注册（验证码）
////                res = usc.codec1(request, req);
//            } else if ("validateLogin".equals(cmd)) { // 1.73 验证登录
////                res = usc.codec(request);
//            } else if ("userLogin".equals(cmd)) { // 1.2用户登录
//                UserLoginReq reqlogin = JSONUtil.toBean(json, UserLoginReq.class);
//                res = utilService.codec(request, reqlogin);
//            } else if ("getVerificationCode".equals(cmd)) { //1.74 JSAPI获取验证码
//                UserLoginReq req = JSONObject.parseObject(json, UserLoginReq.class);
//                res = usc.codeVerification(request, req);
//            } else if ("getOfficialLogin".equals(cmd)) { //1.75 微信公众号登陆
//                UserRegisterReq req = JSONObject.parseObject(json, UserRegisterReq.class);
//                res = usc.codecOfficialAccounts(request, req);
//            } else if ("phoneLogin".equals(cmd)) { // 1.3 短信登录
//                ThirdLoginReq req = JSONObject.parseObject(json, ThirdLoginReq.class);
//                res = usc.codec(request, req);
//            } else if ("phoneLoginVerify".equals(cmd)) { // 1.76 短信登录 验证升级
//                ThirdLoginReq req = JSONObject.parseObject(json, ThirdLoginReq.class);
//                res = usc.codecVerify(request, req);
//            } else if ("findUserPassword".equals(cmd)) { // 1.4用户找回密码
//                FindUserPasswordReq req = JSONObject.parseObject(json, FindUserPasswordReq.class);
//                res = usc.codec(req, request);
//            } else if ("findUserPasswordVerify".equals(cmd)) { // 1.77用户找回密码 验证码升级
//                FindUserPasswordReq req = JSONObject.parseObject(json, FindUserPasswordReq.class);
//                res = usc.codecVerify(req, request);
//            } else if ("editUserPassword".equals(cmd)) { // 1.5用户修改登录密码
//                EditUserPasswordReq req = JSONObject.parseObject(json, EditUserPasswordReq.class);
//                res = usc.codec(req, request);
//            } else if ("editUserPasswordVerify".equals(cmd)) { // 1.51用户修改登陆密码 验证升级
//                EditUserPasswordReq req = JSONObject.parseObject(json, EditUserPasswordReq.class);
//                res = usc.codecVerify(req, request);
//            } else if ("addCommunityMessage".equals(cmd)) { // 1.6完善社区信息
//                AddCommunityMessageReq req = JSONObject.parseObject(json, AddCommunityMessageReq.class);
//                res = usc.codec(request, req);
//            } else if ("getCommunityList".equals(cmd)) { // 1.7 获取社区
//                AddCommunityMessageReq req = JSONObject.parseObject(json, AddCommunityMessageReq.class);
//                res = usc.codec3(req);
//            } else if ("getCommunitMenuList".equals(cmd)) { // 1.8 获取社区单元
//                AddCommunityMessageReq req = JSONObject.parseObject(json, AddCommunityMessageReq.class);
//                res = usc.codec1(req);
//            } else if ("getUserInfo".equals(cmd)) { // 1.9 我的信息
//                UserInfoReq req = JSONObject.parseObject(json, UserInfoReq.class);
//                res = usc.codec(req);
//            } else if ("homepage".equals(cmd)) { // 1.10 个人主页
//                UserInfoReq req = JSONObject.parseObject(json, UserInfoReq.class);
//                res = usc.codec1(req);
//            } else if ("editUserMessage".equals(cmd)) { // 1.11修改用户资料
//                EditUserNicknameReq req = JSONObject.parseObject(json, EditUserNicknameReq.class);
//                res = usc.codec(req);
//            } else if ("deleteImage".equals(cmd)) { // 1.13 删除相册图片
//                EditUserIconReq req = JSONObject.parseObject(json, EditUserIconReq.class);
//                res = usc.codec(req);
//            } else if ("addImageIcon".equals(cmd)) { // 1.14 相册图片设为头像(覆盖之前的)
//                EditUserIconReq req = JSONObject.parseObject(json, EditUserIconReq.class);
//                res = usc.codec1(req);
//            } else if ("getLabelList".equals(cmd)) { // 1.15 获取标签
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec2(req);
//            } else if ("addLabel".equals(cmd)) { // 1.16 提交标签
//                AddLabelReq req = JSONObject.parseObject(json, AddLabelReq.class);
//                res = usc.codec(req);
//            } else if ("signInList".equals(cmd)) { // 1.17 获取签到
//                UserSignReq req = JSONObject.parseObject(json, UserSignReq.class);
//                res = usc.codec1(req);
//            } else if ("signIn".equals(cmd)) { // 1.18 签到
//                UserSignReq req = JSONObject.parseObject(json, UserSignReq.class);
//                res = usc.codec(req);
//            } else if ("getUserBalanceList".equals(cmd)) { // 1.19 零钱明细
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec1(req);
//            } else if ("topUp".equals(cmd)) { // 1.20 充值
//                AddUserRechargeReq req = JSONObject.parseObject(json, AddUserRechargeReq.class);
//                res = usc.codec(req);
//            } else if ("addPayTopUp".equals(cmd)) { //1.79   微信支付宝充值订单
//                AddUserRechargeReq req = JSONObject.parseObject(json, AddUserRechargeReq.class);
//                res = usc.codecPayTopUP(req, request);
//            } else if ("withdrawCash".equals(cmd)) { // 1.21余额提现
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = usc.codec(req);
//            } else if ("securitiesList".equals(cmd)) { // 1.22 我的优惠券列表
//                SecuritiesListReq req = JSONObject.parseObject(json, SecuritiesListReq.class);
//                res = usc.codec(req);
//            } else if ("getCollectList".equals(cmd)) { // 1.23 我的收藏
//                SecuritiesListReq req = JSONObject.parseObject(json, SecuritiesListReq.class);
//                res = usc.codec1(req);
//            } else if ("myShopCar".equals(cmd)) { // 1.24 我的购物车
//                GetUserCartReq req = JSONObject.parseObject(json, GetUserCartReq.class);
//                res = usc.codec(req);
//            } else if ("myShopCarNew".equals(cmd)) { // 1.241我的购物车 版本升级
//                GetUserCartReq req = JSONObject.parseObject(json, GetUserCartReq.class);
//                res = usc.codec1(req);
//            } else if ("deleteMyShopCar".equals(cmd)) { // 1.25 删除购物车
//                DelUserCartReq req = JSONObject.parseObject(json, DelUserCartReq.class);
//                res = usc.codec(req);
//            } else if ("deleteInvalidMyShopCar".equals(cmd)) { // 1.26 删除失效购物车
//                DelUserCartReq req = JSONObject.parseObject(json, DelUserCartReq.class);
//                res = usc.codec26(req);
//            } else if ("editCommunityMessage".equals(cmd)) { // 1.27 更换社区信息
//                AddCommunityMessageReq req = JSONObject.parseObject(json, AddCommunityMessageReq.class);
//                res = usc.codec2(req);
//            } else if ("getHelp".equals(cmd)) { // 1.28 常见问题
//                GetHelpReq req = JSONObject.parseObject(json, GetHelpReq.class);
//                res = usc.codec(req);
//            } else if ("myIrregularities".equals(cmd)) { // 1.29 我的违规
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec5(req);
//            } else if ("myReport".equals(cmd)) { // 1.30 我的举报
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec6(req);
//            } else if ("addFeedback".equals(cmd)) { // 1.31 意见反馈
//                GetHelpReq req = JSONObject.parseObject(json, GetHelpReq.class);
//                res = usc.codec5(req);
//            } else if ("myDynamicList".equals(cmd)) { // 1.32 我的动态
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec7(req);
//            } else if ("myDynamicNewList".equals(cmd)) { // 1.32 我的动态
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec7New(req);
//            } else if ("dynamicDetail".equals(cmd)) { // 1.33 动态详情
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec8(req);
//            } else if ("dynamicDetailComment".equals(cmd)) { // 1.34 获取动态评论
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec9(req);
//            } else if ("dynamicDetailCommentSecond".equals(cmd)) { // 1.35 获取动态二级评论
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec10(req);
//            } else if ("dynamicZan".equals(cmd)) { // 1.36 动态点赞
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec11(req);
//            } else if ("dynamicComment".equals(cmd)) { // 1.37 动态评论
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec12(req);
//            } else if ("myAttention".equals(cmd)) { // 1.38 我的关注
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec13(req);
//            } else if ("userAttention".equals(cmd)) { // 1.39 关注好友
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec14(req);
//            } else if ("getUserAddressList".equals(cmd)) { // 1.40 收获地址列表
//                UserAddressListReq req = JSONObject.parseObject(json, UserAddressListReq.class);
//                res = usc.codec(req);
//            } else if ("addUserAddress".equals(cmd)) { // 1.41 添加收获地址
//                AddUserAddressReq req = JSONObject.parseObject(json, AddUserAddressReq.class);
//                res = usc.codec(req);
//            } else if ("editUserAddress".equals(cmd)) { // 1.42 修改收获地址
//                EditUserAddressReq req = JSONObject.parseObject(json, EditUserAddressReq.class);
//                res = usc.codec(req);
//            } else if ("delUserAddress".equals(cmd)) { // 1.43 删除收获地址
//                DelUserAddressReq req = JSONObject.parseObject(json, DelUserAddressReq.class);
//                res = usc.codec(req);
//            } else if ("getOrderInfo".equals(cmd)) { // 1.44 我的订单
//                UserOrderListReq req = JSONObject.parseObject(json, UserOrderListReq.class);
//                res = usc.codec(req);
//            } else if ("getOrderInfoThreeVersion".equals(cmd)) { // 1.44 1我的订单 1.03本版
//                UserOrderListReq req = JSONObject.parseObject(json, UserOrderListReq.class);
//                res = usc.codec03version(req);
//            } else if ("getOrderInfo1".equals(cmd)) { // 1.441 我的订单 状态详情
//                UserOrderListReq req = JSONObject.parseObject(json, UserOrderListReq.class);
//                res = usc.codec2(req);
//            } else if ("deleteOrder".equals(cmd)) { // 1.45 取消订单(1待付款)
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = usc.codec(req);
//            } else if ("confirmOrder".equals(cmd)) { // 1.46 确认收货(3待收货或7归还中或8退款中)
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = usc.codec1(req);
//            } else if ("returnOrder".equals(cmd)) { // 1.48 请开始归还(6待归还)
//                UserRefundReq req = JSONObject.parseObject(json, UserRefundReq.class);
//                res = usc.codec(req);
//            } else if ("evaluateOrder".equals(cmd)) { // 1.49 评价订单
//                EvaluateOrder1Req req = JSONObject.parseObject(json, EvaluateOrder1Req.class);
//                res = usc.codec(req);
//            } else if ("orderDetailInfo".equals(cmd)) { // 1.50 订单详情
//                UserOrderDetailReq req = JSONObject.parseObject(json, UserOrderDetailReq.class);
//                res = usc.codec(req);
//            } else if ("getOrderPush".equals(cmd)) { //1.80 订单是否已打印
//                UserOrderDetailReq req = JSONObject.parseObject(json, UserOrderDetailReq.class);
//                res = usc.codecOrderPush(req);
//            } else if ("myShield".equals(cmd)) { // 1.51 我的屏蔽
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec15(req);
//            } else if ("adddeleteShield".equals(cmd)) { // 1.52 添加/解除屏蔽
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec16(req);
//            } else if ("getversion".equals(cmd)) { // 1.53 版本更新
//                GetHelpReq req = JSONObject.parseObject(json, GetHelpReq.class);
//                res = usc.codec2(req, request);
//            } else if ("payOrder".equals(cmd)) { // 1.54 余额支付
//                PayByBalanceReq req = JSONObject.parseObject(json, PayByBalanceReq.class);
//                res = usc.codec(req, request);
//            } else if ("mybankcard".equals(cmd)) { // 1.55 我的银行卡
//                UserAddressListReq req = JSONObject.parseObject(json, UserAddressListReq.class);
//                res = usc.codec1(req);
//            } else if ("addbankcard".equals(cmd)) { // 1.56 添加银行卡
//                AddUserAddressReq req = JSONObject.parseObject(json, AddUserAddressReq.class);
//                res = usc.codec1(req);
//            } else if ("editbankcard".equals(cmd)) { // 1.57 编辑银行卡
//                EditUserAddressReq req = JSONObject.parseObject(json, EditUserAddressReq.class);
//                res = usc.codec1(req);
//            } else if ("deletebankcard".equals(cmd)) { // 1.58 删除银行卡
//                DelUserAddressReq req = JSONObject.parseObject(json, DelUserAddressReq.class);
//                res = usc.codec1(req);
//            } else if ("addReport".equals(cmd)) { // 1.59 举报用户
//                GetHelpReq req = JSONObject.parseObject(json, GetHelpReq.class);
//                res = usc.codec6(req);
//            } else if ("pickupOrder".equals(cmd)) { // 1.60 确认取货(4待取货)
//                UserRefundReq req = JSONObject.parseObject(json, UserRefundReq.class);
//                res = usc.codec1(req);
//            } else if ("getInteractionList".equals(cmd)) { // 1.61 我的互动
//                SecuritiesListReq req = JSONObject.parseObject(json, SecuritiesListReq.class);
//                res = usc.codec2(req);
//            } else if ("deleteInteraction".equals(cmd)) { // 1.62 删除互动
//                SecuritiesListReq req = JSONObject.parseObject(json, SecuritiesListReq.class);
//                res = usc.codec3(req);
//            } else if ("updateDynamicState".equals(cmd)) { // 1.63 动态隐藏
//                SecuritiesListReq req = JSONObject.parseObject(json, SecuritiesListReq.class);
//                res = usc.codec4(req);
//            } else if ("mybanklist".equals(cmd)) { // 1.64 获取银行
//                SecuritiesListReq req = JSONObject.parseObject(json, SecuritiesListReq.class);
//                res = usc.codec5(req);
//            } else if ("oneMoreOrder".equals(cmd)) { // 1.65 再来一单
//                UserRefundReq req = JSONObject.parseObject(json, UserRefundReq.class);
//                res = usc.codec2(req);
//            } else if ("effectNumDetail".equals(cmd)) { // 1.66 影响力明细
//                UserRefundReq req = JSONObject.parseObject(json, UserRefundReq.class);
//                res = usc.codec3(req);
//            } else if ("addremarks".equals(cmd)) { // 1.67 设置备注
//                UserRefundReq req = JSONObject.parseObject(json, UserRefundReq.class);
//                res = usc.codec4(req);
//            } else if ("updatemessage".equals(cmd)) { // 1.68 修改留言
//                UserRefundReq req = JSONObject.parseObject(json, UserRefundReq.class);
//                res = usc.codec5(req);
//            } else if ("realdeleteorder".equals(cmd)) { // 1.69 取消订单删除
//                UserRefundReq req = JSONObject.parseObject(json, UserRefundReq.class);
//                res = usc.codec6(req);
//            } else if ("getnewordernum".equals(cmd)) { // 1.70 更新订单号
//                UserRefundReq req = JSONObject.parseObject(json, UserRefundReq.class);
//                res = usc.codec7(req);
//            } else if ("iosbutton".equals(cmd)) { // 1.71 ios开关
//                UserRefundReq req = JSONObject.parseObject(json, UserRefundReq.class);
//                res = usc.codec8(req);
//            } else if ("iosbutton1".equals(cmd)) { // 1.72 ios屏蔽
//                UserRefundReq req = JSONObject.parseObject(json, UserRefundReq.class);
//                res = usc.codec9(req);
//            } else if("getUserQuit".equals(cmd)) {//1.81 用户退出
//                UserLoginReq req = JSONObject.parseObject(json, UserLoginReq.class);
//                res = usc.codeUserQuit(req);
//            } else if ("getCommunityUser".equals(cmd)) { // 2.0 获取社区用户
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec(req);
//            } else if ("myMessageList".equals(cmd)) { // 2.1 我的消息列表
//                GetMessageReq req = JSONObject.parseObject(json, GetMessageReq.class);
//                res = usc.codec(req);
//            } else if ("sysMessageList".equals(cmd)) { // 2.2 官方消息列表
//                GetMessageReq req = JSONObject.parseObject(json, GetMessageReq.class);
//                res = usc.codec1(req);
//            } else if ("orderMessageList".equals(cmd)) { // 2.3 订单消息列表
//                GetMessageReq req = JSONObject.parseObject(json, GetMessageReq.class);
//                res = usc.codec2(req);
//            } else if ("commMessageList".equals(cmd)) { // 2.4 评论消息列表
//                GetMessageReq req = JSONObject.parseObject(json, GetMessageReq.class);
//                res = usc.codec3(req);
//            } else if ("deleteMyMessage".equals(cmd)) { // 2.5 删除消息
//                DeleteMessageReq req = JSONObject.parseObject(json, DeleteMessageReq.class);
//                res = usc.codec(req);
//            } else if ("findList".equals(cmd)) { // 2.6 发现
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec1(req);
//            } else if ("findNewList".equals(cmd)) { // 2.31 发现(新)
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecNew(req);
//            } else if ("activityDetailComment".equals(cmd)) { // 2.7 获取活动/话题评论
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec99(req);
//            } else if ("activityDetailCommentSecond".equals(cmd)) { // 2.8 活动/话题二级评论
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec100(req);
//            } else if ("activityZan".equals(cmd)) { // 2.9 活动/话题点赞
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec111(req);
//            } else if ("secondhandSelled".equals(cmd)) { // 2.9 二手闲置售出
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codecSHSelled(req);
//            } else if ("themeFlag".equals(cmd)) { // 2.32  话题点赞(新)
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec(req);
//            } else if ("activityComment".equals(cmd)) { // 2.10 活动/话题/闲置评论
//                UserScoreListReq req = JSONObject.parseObject(json, UserScoreListReq.class);
//                res = usc.codec122(req);
//            } else if ("getRedmanList".equals(cmd)) { // 2.11 红人榜
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec2(req);
//            } else if ("getCommunityMan".equals(cmd)) { // 2.12 社区达人
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec3(req, request);
//            } else if ("applyCommunityMan".equals(cmd)) { // 2.13 社区达人申请
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec4(req);
//            } else if ("addExperience".equals(cmd)) { // 2.15 添加达人经历
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec5(req);
//            } else if ("editExperience".equals(cmd)) { // 2.16 修改达人经历
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec6(req);
//            } else if ("deleteExperience".equals(cmd)) { // 2.17 删除达人经历
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec7(req);
//            } else if ("getExperienceDetail".equals(cmd)) { //2.33 达人经历详情
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecED(req);
//            } else if ("getManDetail".equals(cmd)) { // 2.18 获取达人信息
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec8(req);
//            } else if ("findDynamicList".equals(cmd)) { // 2.19 发现动态/帮帮
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec9(req);
//            } else if ("GetDynamic".equals(cmd)) { // 2.34 发现首页动态
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecDynamic(req);
//            } else if ("findDynamic".equals(cmd)) { // 2.35  发现首页数据（新）
//                FindListReq req = JSONObject.parseObject(json, FindListReq.class);
//                res = usc.codecList(req);
//            } else if ("findActivityList".equals(cmd)) { // 2.21 发现活动
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec10(req);
//            } else if ("findActivityDetail".equals(cmd)) { // 2.22 活动/闲置详情
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec11(req);
//            } else if ("signupActivity".equals(cmd)) { // 2.23 活动报名
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec12(req);
//            } else if ("getCommunityManLabel".equals(cmd)) { // 2.25 获取达人标签
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec24(req);
//            } else if ("addCollect".equals(cmd)) { // 2.26 收藏
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec25(req);
//            } else if ("deleteComment".equals(cmd)) { // 2.27 评论删除
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec26(req);
//            } else if ("zanMessageList".equals(cmd)) { // 2.28 点赞消息列表
//                GetMessageReq req = JSONObject.parseObject(json, GetMessageReq.class);
//                res = usc.codec4(req);
//            } else if ("getcommentdetail".equals(cmd)) { // 2.29 获取一级评论详情
//                GetMessageReq req = JSONObject.parseObject(json, GetMessageReq.class);
//                res = usc.codec5(req);
//            } else if ("getthemedetail".equals(cmd)) { // 2.30 获取话题详情
//                GetMessageReq req = JSONObject.parseObject(json, GetMessageReq.class);
//                res = usc.codec6(req,request);
//            } else if ("getFindRenew".equals(cmd)) { // 2.36  获取发现是否有更新
//                GetMessageReq req = JSONObject.parseObject(json, GetMessageReq.class);
//                res = usc.codec7(req);
//            } else if ("getSecuritiesList".equals(cmd)) { // 3.1 获取可领取优惠券
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec13(req);
//            } else if ("receiveSecurities".equals(cmd)) { // 3.2 领取优惠券
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec14(req);
//            } else if ("getServicePage".equals(cmd)) { // 3.3 服务首页
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec15(req);
//            } else if ("getServiceComment".equals(cmd)) { // 3.4 获取店铺详情评价
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec16(req);
//            } else if ("getFreshList".equals(cmd)) { // 3.5 新鲜果蔬/洗衣洗鞋/超市便利
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec17(req);
//            } else if("getServicePageIcon".equals(cmd)) {//3.13  服务页图标
//                GetServicePageIcon req = JSONObject.parseObject(json, GetServicePageIcon.class);
//                res = usc.codecSPI(req);
//            } else if ("getCategoryGoods".equals(cmd)) { // 3.6 查询分类下商品
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec18(req);
//            } else if ("getCategoryGoodsNew".equals(cmd)) { // 3.14 查询分类下商品New2019-03-20
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec18New(req);
//            } else if ("getSearchKey".equals(cmd)) { //3.15  搜索商品关键字
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecSearch(req);
//            } else if ("getGoodsDesc".equals(cmd)) { // 3.16 商品介绍详情
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codeGetGoodsDesc(req);
//            } else if ("getGoodsDescNew".equals(cmd)) { // 3.17 商品介绍详情NEW2019-03-20
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codeGetGoodsDescNew(req);
//            } else if ("getGoodsDescNewXcX".equals(cmd)) { //3.18 小程序查看商品介绍详情2019-06-14
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codeGetGoodsDescNewXcX(req);
//            } else if ("getSelectAllGoods".equals(cmd)) { // 3.19模糊搜索查询社区商品
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec08(req);
//            } else if ("getSelectAllGoodsNew".equals(cmd)) { // 3.20模糊搜索查询社区商品NEW2019-03-20
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec08New(req);
//            } else if ("getSellCommuityGoods".equals(cmd)) { // 3.21展示热销商品
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec09(req);
//            } else if ("getSellCommuityGoodsNew".equals(cmd)) { // 3.22展示热销商品NEW2019-03-20
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec63(req);
//            } else if("getGroupPurchase".equals(cmd)) { //3.23团购钜惠
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecGroupPurchase(req);
//            } else if("getShopManagerRecommend".equals(cmd)) { //3.24 店长推荐
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecShopManagerRecommend(req);
//            } else if("getTimedSpecials".equals(cmd)) {  //3.25 限时特价
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecTimedSpecials(req);
//            } else if("getSeriesOfActivities".equals(cmd)) {  //3.26 系列活动
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codeSeriesOfActivities(req);
//            } else if ("getRandomCommuityGoods".equals(cmd)) { //3.27 猜你所想
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecRandom(req);
//            } else if ("getRandomCommuityGoodsNew".equals(cmd)) { //3.28 猜你所想new2019-03-20
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecRandomNew(req);
//            } else if ("addShopCar".equals(cmd)) { // 3.7 加入购物车
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = usc.codec(req);
//            } else if ("generateOrder".equals(cmd)) { // 3.8 提交订单
//                AddCartGoodsOrderReq req = JSONObject.parseObject(json, AddCartGoodsOrderReq.class);
//                res = usc.codec(req);
//            } else if ("generateOrderTreeVersion".equals(cmd)) { // 3.29 提交订单 1.03版本
//                AddCartGoodsOrderNewReq req = JSONObject.parseObject(json, AddCartGoodsOrderNewReq.class);
//                res = usc.codecTreeVersion(req);
//            } else if ("getAttestationTreeVersion".equals(cmd)) { //3.30 验签 1.03
//                GetDictTypeReq req = JSONObject.parseObject(json, GetDictTypeReq.class);
//                res = usc.codecAttestation(req);
//            } else if("getGoodsBarCode".equals(cmd)) { //3.31 扫码
//                AddSettleAccountsReq req = JSONObject.parseObject(json, AddSettleAccountsReq.class);
//                res = usc.getScanQRCode(req,request);
//            } else if("getSubmitCodeOrder".equals(cmd)) {//3.32 扫码 提交订单
//                AddCartGoodsOrderReq req = JSONObject.parseObject(json, AddCartGoodsOrderReq.class);
//                res = usc.getSubmitCodeOrder(req);
//            } else if ("getPayVersion".equals(cmd)) { //3.33 去结算
//                AddSettleAccountsReq req = JSONObject.parseObject(json, AddSettleAccountsReq.class);
//                res = usc.getPayVersion(req);
//            } else if ("getSubmitOrder".equals(cmd)) { //3.34 微信支付宝支付 提交订单
//                AddCartGoodsOrderNewReq req = JSONObject.parseObject(json, AddCartGoodsOrderNewReq.class);
//                res = usc.codeSubmitOrder(req);
//            } else if ("getImmediatePayment".equals(cmd)) { //3.35 立即支付
//                GetPayDetailReq req = JSONObject.parseObject(json, GetPayDetailReq.class);
//                res = usc.codeImmediatePayment(req, request);
//            } else if ("createWXScanPay".equals(cmd)) { //3.36 微信线下扫码支付
//                GetPayDetailReq req = JSONObject.parseObject(json, GetPayDetailReq.class);
//                res = usc.createWXScanPay(req, request);
//            } else if ("createAliScanPay".equals(cmd)) { //3.37 支付宝线下扫码支付
//                GetPayDetailReq req = JSONObject.parseObject(json, GetPayDetailReq.class);
//                res = usc.createAliScanPay(req, request);
//            } else if ("queryAliScanPay".equals(cmd)) { //3.38 支付宝线下扫码支付查询是否到账
//                GetPayDetailReq req = JSONObject.parseObject(json, GetPayDetailReq.class);
//                res = usc.queryAliScanPay(req, request);
//            } else if ("unLockOrder".equals(cmd)) { //3.39 支付失败解锁订单
//                GetVillageShopReq req = JSONObject.parseObject(json, GetVillageShopReq.class);
//                res = usc.codeUnLockOrder(req, request);
//            } else if("getVillageShopOrder".equals(cmd)) {//3.40 小区店铺订单
//                GetVillageShopReq req = JSONObject.parseObject(json, GetVillageShopReq.class);
//                res = usc.getVillageShopOrder(req);
//            } else if("submitVillageShopPayment".equals(cmd)) {//3.41 小区店铺支付
//                GetVillageShopReq req = JSONObject.parseObject(json, GetVillageShopReq.class);
//                res = usc.submitVillageShopPayment(req,request);
//            } else if ("getCommunityShop".equals(cmd)) { // 3.9 小区店铺
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec20(req);
//            } else if ("getBanner".equals(cmd)) { // 3.42 按类别获取banner
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecB(req);
//            } else if ("getCommunityContact".equals(cmd)) { // 3.43 小区店铺黄页
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecCC(req);
//            } else if("getCommunityShopServiceIcon".equals(cmd)) {//3.44 小区店铺服务页图标
//                GetServicePageIcon req = JSONObject.parseObject(json, GetServicePageIcon.class);
//                res = usc.codecCSSI(req);
//            } else if("getCommunityShopServiceGoods".equals(cmd)) {//3.45 小区店铺服务页图标中的商品
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecCSSG(req);
//            } else if ("getCommunityShopDetail".equals(cmd)) { // 3.10 小区店铺详情
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec21(req);
//            } else if ("getShopGoodsDesc".equals(cmd)) { // 3.46小区店铺商品介绍详情
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codeGSGD(req);
//            } else if ("getRecommendShopGoods".equals(cmd)) { // 3.47展示小区店铺推荐商品
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codecRSG(req);
//            } else if ("optimizationGoods".equals(cmd)) { // 3.11 优选商品
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec19(req);
//            } else if ("optimizationGoodsNew".equals(cmd)) { // 3.48 优选商品NEW2019-03-20
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec19New(req);
//            } else if ("userTask".equals(cmd)) { // 3.12 任务
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = usc.codec22(req);
//            } else if ("GetRest".equals(cmd)) { // 3.49 查看商家是否设置休息时间
//                GetMerchantRestReq req = JSONObject.parseObject(json, GetMerchantRestReq.class);
//                res = usc.codecRest1(req);
//            } else if ("getDistance".equals(cmd)) { // 3.50 查询当前位置与社区的距离
//                GetDistance req = JSONObject.parseObject(json, GetDistance.class);
//                res = usc.codecDistance(req);
//            } else
            if ("shopLogin".equals(cmd)) { // 4.1 商家登录
                UserLoginReq req = JSONUtil.toBean(json, UserLoginReq.class);
                res = ssc.codec1(request, req);
            }
//            else if ("findShopPassword".equals(cmd)) { // 4.2 商家忘记密码
//                FindUserPasswordReq req = JSONObject.parseObject(json, FindUserPasswordReq.class);
//                res = ssc.codec1(req);
//            } else if ("notCompleteOrder".equals(cmd)) { // 4.3 未完成订单
//                UserOrderListReq req = JSONObject.parseObject(json, UserOrderListReq.class);
//                res = ssc.codec1(req);
//            } else if ("appReturnOrder".equals(cmd)) { // 4.4 退款审核(8退款中)
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = ssc.codec2(req);
//            }  else if ("deliverOrder".equals(cmd)) { // 4.5 确认发货/确认上门(2待送货4待取货)
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = ssc.codec3(req);
//            } else if ("cleanEndOrder".equals(cmd)) { // 4.6 清洗完成(5清洗中)
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = ssc.codec4(req);
//            } else if ("cleanEndOrder03Version".equals(cmd)) { // 4.6清洗完成 1.03版本
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = ssc.codec41(req);
//            } else if ("getShopCategoryGoods".equals(cmd)) { // 4.7 查询分类下商品
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = ssc.codec23(req);
//            } else if ("getShopCategoryGoodsNew".equals(cmd)) { // 4.7 查询分类下商品New2019-03-20
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = ssc.codec23New(req);
//
//            } else if ("addreplenishment".equals(cmd)) { // 4.8 加入补货单
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.codec1(req);
//            } else if ("replenishmentList".equals(cmd)) { // 4.9 补货单列表
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.codec2(req);
//            } else if ("deletereplenishment".equals(cmd)) { // 4.10 删除补货单
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.codec3(req);
//            } else if ("updatereplenishment".equals(cmd)) { // 4.11 编辑补货单
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.codec4(req);
//            } else if ("subreplenishment".equals(cmd)) { // 4.12 提交补货单
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.codec5(req);
//            } else if ("shopUserinfo".equals(cmd)) { // 4.13 个人中心
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.codec6(req);
//            } else if ("updateUserimg".equals(cmd)) { // 4.14 修改头像
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.codec7(request, req);
//            } else if ("getUserMessage".equals(cmd)) { // 4.15 我的消息
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.codec8(req);
//            } else if ("shopwithdrawCash".equals(cmd)) { // 4.16 余额提现
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec1(req);
//            } else if ("getShopBalanceList".equals(cmd)) { // 4.17 零钱明细
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec2(req);
//            } else if ("myAllorderlist".equals(cmd)) { // 4.18 我的订单
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec3(req);
//            } else if ("mysupplementlist".equals(cmd)) { // 4.19 补充库存记录
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec4(req);
//            } else if ("mysupplementlistDetail".equals(cmd)) { // 4.20 补充库存记录详情
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec5(req);
//            } else if ("communityShopDetail".equals(cmd)) { // 4.21 店铺详情
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec6(req);
//            } else if ("updateCommunityShopDetail".equals(cmd)) { // 4.22 编辑店铺信息
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec7(req);
//            } else if ("getShopComment".equals(cmd)) { // 4.23 获取店铺评价
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec8(req);
//            } else if("getBindingPay".equals(cmd)) { //绑定支付(暂未用)
//
//                res = usc.codeBindingPay();
//            } else if("shopManagerrecommended".equals(cmd)){  //4.24 店长推荐
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.shopManagerrecommended(req);
//            }  else if ("notCompleteOrderNew".equals(cmd)) { // 4.25 未完成订单
//                OrderListReq req = JSONObject.parseObject(json, OrderListReq.class);
//                res = ssc.codecNew(req);
//            }  else if ("codecActivityListNew".equals(cmd)) { // 4.26 未完成活动订单
//                OrderListReq req = JSONObject.parseObject(json, OrderListReq.class);
//                res = ssc.codecActivityListNew(req);
//            }  else if ("codecOrderListInfo".equals(cmd)) { // 4.27 活动订单详情
//                OrderListReq req = JSONObject.parseObject(json, OrderListReq.class);
//                res = ssc.codecOrderListInfo(req);
//            }  else if ("codecAog".equals(cmd)) { // 4.28 产品到货提醒
//                OrderListReq req = JSONObject.parseObject(json, OrderListReq.class);
//                res = ssc.codecAog(req);
//            } else if ("getOrderRefund".equals(cmd)) { // 4.29退款审核(8退款中) 微信支付宝退款
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = ssc.codec2Refund(req);
//            } else if ("codec2OrderDifference".equals(cmd)) { // 4.30 微信支付宝退差额
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = ssc.codec2Difference(req);
//            } else if("submitModifyInventory".equals(cmd)){  //4.31 修改库存
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.updateModifyInventory(req);
//            } else if("merchantSetSeckillGoods".equals(cmd)) {//4.32 商家端设置秒杀商品
//                GetApprovalOfPriceReq req = JSONObject.parseObject(json, GetApprovalOfPriceReq.class);
//                res = ssc.merchantSetSeckillGoods(req);
//            } else if("deleteProcurementGoods".equals(cmd)) {  //4.33 删除采购商品
//                GetProcurementGoodsReq req = JSONObject.parseObject(json,GetProcurementGoodsReq.class);
//                res = ssc.deleteProcurementGoods(req);
//            } else if("clickConfirmCompleted".equals(cmd)) {  //4.34 盘点确认
//                GetProcurementGoodsReq req = JSONObject.parseObject(json,GetProcurementGoodsReq.class);
//                res = ssc.clickConfirmCompleted(req);
//            } else if("getProcurementGoodsShow".equals(cmd)) { //4.35 下单补货商品展示
//                GetProcurementGoodsReq req = JSONObject.parseObject(json,GetProcurementGoodsReq.class);
//                res = ssc.getProcurementGoodsShow(req);
//            } else if ("shopUserinfoNew".equals(cmd)) { // 4.36 个人中心new
//                UserStatisticsReq req = JSONObject.parseObject(json, UserStatisticsReq.class);
//                res = ssc.codec6New(req);
//            } else if ("settleAccounts".equals(cmd)) { // 4.37 结算信息
//                UserStatisticsReq req = JSONObject.parseObject(json, UserStatisticsReq.class);
//                res = ssc.codec6NewJs(req);
//            }  else if ("settleAccountsInfo".equals(cmd)) { // 4.38 结算明细
//                UserStatisticsReq req = JSONObject.parseObject(json, UserStatisticsReq.class);
//                res = ssc.codec6Detail(req);
//            } else if ("operatingStatistics".equals(cmd)) { // 4.39 经营统计
//                UserStatisticsReq req = JSONObject.parseObject(json, UserStatisticsReq.class);
//                res = ssc.operatingStatistics(req);
//            }  else if ("categoryGoodsRanking".equals(cmd)) { // 4.40 经营统计商品排名
//                UserStatisticsReq req = JSONObject.parseObject(json, UserStatisticsReq.class);
//                res = ssc.categoryGoodsRanking(req);
//            } else if ("selectPayList".equals(cmd)) { // 4.41 经营统计  交易明细
//                UserStatisticsReq req = JSONObject.parseObject(json, UserStatisticsReq.class);
//                res = ssc.selectPayList(req);
//            } else if ("shopUserinfoTreeDetails".equals(cmd)) {// 4.42 今日营业额/订单详情详情
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc.codecTreeDetails(req);
//            } else if ("shopUserinfoTreeList ".equals(cmd)) { // 4.43 今日订单列表额详情
//                UserOrderDetailReq req = JSONObject.parseObject(json, UserOrderDetailReq.class);
//                res = usc.codecTreeVersion(req);
//            } else if ("GetPeriodTimeVolume".equals(cmd)) { // 4.44 一段时间营业额
//                GetPeriodTimeReq req = JSONObject.parseObject(json, GetPeriodTimeReq.class);
//                res = ssc.codePeriodTimeTreeVersion(req);
//            } else if("updateApprovalOfPrice".equals(cmd)) { //4.45 商品促销价审批
//                GetApprovalOfPriceReq req = JSONObject.parseObject(json, GetApprovalOfPriceReq.class);
//                res = ssc.getApprovalOfPromotionPrice(req);
//            } else if("updateCommunityPrice".equals(cmd)) { //4.46 社区商品价格修改
//                GetCommunityPrice req = JSONObject.parseObject(json, GetCommunityPrice.class);
//                res = ssc.codeCommunityPrice(req);
//            } else if("goodsInfoModificationReq".equals(cmd)) { //4.47 社区商品价格库存修改
//                GoodsModificationReq req = JSONObject.parseObject(json, GoodsModificationReq.class);
//                res = ssc.goodsInfoModification(req);
//            } else if("getRemittanceDetails".equals(cmd)) { //4.48 打账明细
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec2RemittanceDetails(req);
//            } else if ("myAllorderlistTreeVersion".equals(cmd)) {//4.49 我的订单 升级版
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec3order(req);
//            }  else if ("commtityShopOrder".equals(cmd)) {//4.50  我的订单 升级版new
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc2.codec3orderNew(req);
//            } else if ("GetGoodsDetails".equals(cmd)) { // 4.51商家端商品詳情
//                GetGoodsDetailsReq req = JSONObject.parseObject(json, GetGoodsDetailsReq.class);
//                res = ssc.codeGoodsDetails(req);
//            } else if ("updateCommunityShopDetailNew".equals(cmd)) { // 4.52 编辑店铺信息和休息时间
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc.codec711(req);
//            } else if ("addOrderComment".equals(cmd)) { //4.53 订单评论
//                EvaluateOrder1Req req = JSONObject.parseObject(json, EvaluateOrder1Req.class);
//                res = ssc.addCommentCodec(req);
//            } else if ("deleteOrderComment".equals(cmd)) { //4.54 订单评论删除
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = ssc.deleteCodec(req);
//            } else if ("getMerchantRest".equals(cmd)) { // 4.55 商家休息
//                GetMerchantRestReq req = JSONObject.parseObject(json, GetMerchantRestReq.class);
//                res = ssc.codecRest(req);
//            } else if ("getMerchantsShelves".equals(cmd)) { // 4.56 社区商品上下架
//                GetMerchantsShelvesReq req = JSONObject.parseObject(json, GetMerchantsShelvesReq.class);
//                res = ssc.codeMerchantsShelves(req);
//            } else if ("GetMerchantVersion".equals(cmd)) { // 4.57 商家端版本是否强制跟新
//                GetMerchantVersionReq req = JSONObject.parseObject(json, GetMerchantVersionReq.class);
//                res = ssc.codecMerchantVersion(req);
//            } else if ("GetCodeQuit".equals(cmd)) { // 4.58 商家端退出
//                UserLoginReq req = JSONObject.parseObject(json, UserLoginReq.class);
//                res = ssc.codeQuit(req);
//            } else if ("communityBindWX".equals(cmd)) { //4.59 商户微信公众号绑定
//                UserRegisterReq req = JSONObject.parseObject(json, UserRegisterReq.class);
//                res = ssc.communityBindWX(request, req);
//            } else if ("communityBindAliPay".equals(cmd)) { //4.60  商户支付宝绑定
//                UserRegisterReq req = JSONObject.parseObject(json, UserRegisterReq.class);
//                res = ssc.communityBindAliPay(request, req);
//            } else if ("IPCshopLogin".equals(cmd)) { // 5.1 异业联盟商家登录
//                UserLoginReq req = JSONObject.parseObject(json, UserLoginReq.class);
//                res = ssc2.codec1(request,req);
//            } else if ("IPCfindShopPassword".equals(cmd)) { // 5.2 异业联盟商家忘记密码
//                FindUserPasswordReq req = JSONObject.parseObject(json, FindUserPasswordReq.class);
//                res = ssc2.codec1(req, request);
//            } else if ("IPCnotCompleteOrder".equals(cmd)) { // 5.3 异业联盟订单列表
//                UserOrderListReq req = JSONObject.parseObject(json, UserOrderListReq.class);
//                res = ssc2.codec1(req);
//            } else if ("IPCgetOrderRefund".equals(cmd)) { // 5.4 异业联盟退款审核(8退款中) 微信支付宝退款
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = ssc2.codec2Refund(req);
//            } else if ("IPCdeliverOrder".equals(cmd)) { // 5.5 异业联盟确认发货/确认上门(2待送货4待取货)
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = ssc2.codec3(req);
//            } else if ("IPCconfirmOrder".equals(cmd)) { // 5.6  确认收货(3待收货)
//                CancelUserOrderReq req = JSONObject.parseObject(json, CancelUserOrderReq.class);
//                res = ssc2.codec1(req);
//            } else if ("IPCgetShopGoodsNew".equals(cmd)) { // 5.7 异业联盟查询分类下商品New2019-03-20
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = ssc2.codec23New(req);
//            } else if ("IPCshopUserinfo".equals(cmd)) { // 5.8异业联盟商家个人中心
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc2.codec6(req);
//            } else if ("IPCshopUserinfoTreeDetails".equals(cmd)) {// 5.9 异业联盟今日营业额/订单详情详情
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc2.codecTreeDetails(req);
//            } else if ("IPCorderDetailInfo".equals(cmd)) {// 5.10 异业联盟订单详情
//                UserOrderDetailReq req = JSONObject.parseObject(json, UserOrderDetailReq.class);
//                res = ssc2.codec(req);
//            } else if ("IPCGetPeriodTimeVolume".equals(cmd)) { // 5.11 异业联盟一段时间营业额
//                GetPeriodTimeReq req = JSONObject.parseObject(json, GetPeriodTimeReq.class);
//                res = ssc2.codePeriodTimeTreeVersion(req);
//            } else if ("IPCupdateUserimg".equals(cmd)) { // 5.12 异业联盟修改头像
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc2.codec7(request, req);
//            } else if ("IPCgetUserMessage".equals(cmd)) { // 5.13 异业联盟我的消息
//                AddUserCartReq req = JSONObject.parseObject(json, AddUserCartReq.class);
//                res = ssc2.codec8(req);
//            } else if ("IPCgetShopBalanceList".equals(cmd)) { // 5.14 异业联盟零钱明细
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc2.codec2(req);
//            } else if("IPCgetRemittanceDetails".equals(cmd)) { //5.15 异业联盟打账明细
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc2.codec2RemittanceDetails(req);
//            } else if ("IPCmyAllorderlistTreeVersion".equals(cmd)) {// 5.16 异业联盟我的订单
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc2.codec3order(req);
//            } else if ("IPCcommunityShopDetail".equals(cmd)) { // 5.17 异业联盟店铺详情
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc2.codec6(req);
//            } else if ("IPCupdateCommunityShopDetail".equals(cmd)) { // 5.18 异业联盟编辑店铺信息
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc2.codec7(req);
//            } else if ("IPCgetShopComment".equals(cmd)) { // 5.19 异业联盟获取店铺评价
//                UserTixianReq req = JSONObject.parseObject(json, UserTixianReq.class);
//                res = ssc2.codec8(req);
//            } else if ("IPCaddOrderComment".equals(cmd)) { //5.20 异业联盟订单评论
//                EvaluateOrder1Req req = JSONObject.parseObject(json, EvaluateOrder1Req.class);
//                res = ssc2.addCommentCodec(req);
//            } else if ("IPCdeleteOrderComment".equals(cmd)) { //5.21 异业联盟订单评论删除
//                GetCommunityReq req = JSONObject.parseObject(json, GetCommunityReq.class);
//                res = ssc2.deleteCodec(req);
//            } else if ("IPCgetMerchantsShelves".equals(cmd)) { // 5.22 异业联盟社区商品上下架
//                GetMerchantsShelvesReq req = JSONObject.parseObject(json, GetMerchantsShelvesReq.class);
//                res = ssc2.codeMerchantsShelves(req);
//            } else if ("IPCGetMerchantVersion".equals(cmd)) { // 5.23 异业联盟商家端版本是否强制跟新
//                GetMerchantVersionReq req = JSONObject.parseObject(json, GetMerchantVersionReq.class);
//                res = ssc2.codecMerchantVersion(req);
//            } else if ("authorizationLogin".equals(cmd)) {// 6.1微信登陆
//                UserRegisterReq req = JSONObject.parseObject(json, UserRegisterReq.class);
//                res = usc.getWeiXinLogin(request, req);
//            } else if ("authorizationLoginMsg".equals(cmd)) { // 6.2微信信息完善
//                UserRegisterReq req = JSONObject.parseObject(json, UserRegisterReq.class);
//                res = usc.getWeiXinLoginMessage(request, req);
//            } else if ("authorizationLoginMsgVerify".equals(cmd)) { // 6.3微信信息完善 短信验证升级
//                UserRegisterReq req = JSONObject.parseObject(json, UserRegisterReq.class);
//                res = usc.getWeiXinLoginMessageVerify(request, req);
//            } else if("xcxUserCode".equals(cmd)){//6.4 小程序登录验证
//                ThirdLoginReq req = JSONObject.parseObject(json, ThirdLoginReq.class);
//                res = usc.codecSmall(request, req);
//            } else if ("activityCode".equals(cmd)){//6.5 判断活动
//                ActivityListReq req=JSONObject.parseObject(json, ActivityListReq.class);
//                res=usc.activitycode(request, req);
//            } else if ("activityListCode".equals(cmd)){//6.6 活动列表
//                ActivityListReq req=JSONObject.parseObject(json, ActivityListReq.class);
//                res=usc.activityListcode(request, req);
//            }
            /**************** 公共接口 *******************/
            else if ("getSMSCode".equals(cmd)) {// 6.7发送验证码
                SendSmsReq req = BeanUtil.toBean(obj, SendSmsReq.class);
                res = csc.sendSMSCode(req, request);
            } else if ("getServerTime".equals(cmd)) {// 6.8获取服务器时间
                res = codec3();
            }
        } catch (Exception e) {
            log.error("请求处理异常：959");
            log.error(e.toString());
            log.error("请求处理异常：reqJson=" + json + "\n" + e);
            return responseAppRes(res);
        }
        log.info("发：" + JSONUtil.toJsonStr(res));
         return responseAppRes(res);
//        return responseAppRes(res);
    }

    /*
     * 获取服务器时间
     *
     * @return
     */
    private ResJson codec3() {
        ServerTimeRes res = new ServerTimeRes();
        res.setResultNote("获取失败");
        try {
            res.setServerTime(DateFormatUtil.DEFAULT_ON_SECOND_FORMAT.format(new Date()));
            res.setResult("0");
            res.setResultNote("获取成功");
        } catch (Exception e) {
            log.error("请求处理异常：14815");
            log.error(e.toString());
        }
        return res;
    }
}
