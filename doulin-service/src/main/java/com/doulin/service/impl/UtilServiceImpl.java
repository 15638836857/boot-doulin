package com.doulin.service.impl;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.extension.api.R;
import com.doulin.common.Base64Utils;
import com.doulin.common.DateTimeUtil;
import com.doulin.common.DateUtils;
import com.doulin.common.SMS.SMSVerificationCode;
import com.doulin.common.StringUtils;
import com.doulin.common.baidu.OcrBaiduUtil;
import com.doulin.common.content.ErrorContent;
import com.doulin.common.content.SysContent;
import com.doulin.common.encrymlbgo.AESUtils;
import com.doulin.common.j2cache.CacheUtils;
import com.doulin.common.token.JwtToken;
import com.doulin.entity.*;
import com.doulin.entity.common.*;
import com.doulin.entity.edo.Tree;
import com.doulin.entity.edo.TreeUtil;
import com.doulin.entity.image.ImgDoConfig;
import com.doulin.entity.shop.BankCardTypeVo;
import com.doulin.entity.shop.BankDo;
import com.doulin.service.*;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * @className UtilServiceImpl
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/17 13:38
 * @Version 1.0
 */
@Service
@Slf4j
public class UtilServiceImpl implements UtilService {
    @Autowired
    private ImgDoConfig imgDoConfig;
    @Autowired
    private TShopHomeBaseInfoService shopHomeBaseInfoService;
    @Autowired
    private TUserService tUserService;
    @Autowired
    private TCommunnityTokenService communnityTokenService;
    @Autowired
    private TBankInfoService tBankInfoService;
    @Autowired
    private TAboutService tAboutService;
    @Autowired
    private SysSalesmanService sysSalesmanService;
    @Autowired
    private TCommunityService tCommunityService;
    @Autowired
    private TShopHomeGroupService shopHomeGroupService;
    @Autowired
    private BankDo bankDo;


    @Override
    public void shortMassge(String phone, String type, String ip) throws Exception {
        try {
            if (!PhoneUtil.isMobile(phone)) {
                throw new Exception(SysContent.ERROR_PHONE);
            } else if (StrUtil.isEmpty(type)) {
                throw new Exception(ErrorContent.ERROR_SHORT_MSG_TYPE);
            } else {
                SMSVerificationCode.getRequest2(phone, type);
                Long dateTime = System.currentTimeMillis();// 获取服务器的时间
                // rides储存
                CacheUtils.put("dateTime" + ip, type, dateTime, 180);
                CacheUtils.put("ip" + ip, type, ip, 180);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<String> uploadImg(MultipartFile[] file,  String type) throws Exception {
        List<String> fileUrl = new LinkedList<>();

        if (file != null && file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                String realPath = "";
                if (SysContent.INTGER_1.toString().equals(type)) {

                    realPath = imgDoConfig.getFilePath()  + "/shop";
                } else if (SysContent.INTGER_2.toString().equals(type)) {
                    realPath = imgDoConfig.getFilePath()  + "/user";
                }
                String[] split = DateTimeUtil.dateConvtoFmt(new Date(), "yyyy-MM").split("-");
                String dateDir = split[0] + "/" + split[1];
                File path = new File(realPath + File.separator + dateDir);
                if (!path.exists()) {
                    path.mkdirs();
                }
                String filename1 = file[i].getOriginalFilename();
                String ext1 = filename1.substring(filename1.lastIndexOf(".")).toLowerCase();
                String fileName1 = DateTimeUtil.dateFormat("yyyyMMddHHmmss", new Date()) + StringUtils.randomString(4) + ext1;
                File localFile1 = new File(path + File.separator + fileName1);
                file[i].transferTo(localFile1);
                String reurnurl = imgDoConfig.getPrefix();
                StringBuilder st=new StringBuilder();

                if (SysContent.INTGER_1.toString().equals(type)) {
                    st.append("shop/" );
                } else if (SysContent.INTGER_2.toString().equals(type)) {
                    st.append("user/");
                }
                st.append(dateDir + "/" + fileName1);
                String strr=st.toString();
                fileUrl.add(reurnurl+st.toString());
            }

            return fileUrl;
        } else {
            throw new Exception(SysContent.ERROR_EMPTY_FILE);
        }
    }

    /**
     * 验证手机号 是否存在
     *
     * @param type 1，商户   2/客户
     * @param req
     * @throws Exception
     */
    @Override
    public void phoneFlag(String type, UserRegisterReq req) throws Exception {
        if (StrUtil.isEmpty(req.getPhone()) || PhoneUtil.isMobile(req.getPhone())) {
            throw new Exception(SysContent.ERROR_PHONE);
        }
        // 判断手机号是否已存在
        if (SysContent.INTGER_1.toString().equals(type)) {
            TShopHomeBaseInfo shopHomeBaseInfo = shopHomeBaseInfoService.getInfoByLoginNo(req.getPhone());
            if (null != shopHomeBaseInfo) {
                throw new Exception(SysContent.ERROR_PHONE_EXSIS);
            }
        } else if (SysContent.INTGER_2.toString().equals(type)) {
            TUser tUser = tUserService.getOneByLoginPhone(req.getPhone());
            if (null != tUser) {
                throw new Exception(SysContent.ERROR_PHONE_EXSIS);
            }
        }
    }

//    /**
//     * 1.1用户注册
//     *
//     * @param req
//     * @return
//     * @throws Exception
//     */
//    public ResJson codec(HttpServletRequest request, UserRegisterReq req,String type) throws Exception {
//
//        if (StrUtil.isBlank(req.getPhone())) {
//            throw new Exception(SysContent.ERROR_PHONE_EXSIS);
//        }
//        // 判断手机号是否已存在
//        phoneFlag(type, req);
//        if (StrUtil.isBlank(req.getPassword())) {
//            throw new Exception(SysContent.ERROR_PASSORD_EXSIS);
//        }
//
//        if(SysContent.INTGER_1.toString().equals(type)){
//
//        }
//        // 创建用户
//        Tuser u = new Tuser();
//        String id = IdGen.uuid();
//        u.setId(id);// id
//        u.setPhone(req.getPhone());// 手机号
//        u.setPassword(req.getPassword());// 登录密码
//        u.setNickname(
//                req.getPhone().length() > 4 ? "邻友" + req.getPhone().substring(req.getPhone().length() - 4) : "邻友0000");// 昵称
//        u.setSex("1");
//        // u.setIcon("/wisdom/userfiles/1/files/user/icon/default.png"); // 头像
////		u.setIcon("/wisdom/userfiles/1/files/user/icon/default.png");
//        String random = String.valueOf(Math.random());
//        String code = random.substring(random.length() - 8);
//        u.setBalance(0d);
//        u.setToken(req.getToken());
//        u.setInvitenum(code);
//        u.setEffectnum(0);
//        u.setDynamicnum(0);
//        u.setAttennum(0);
//        u.setFansnum(0);
//        u.setReportnum(0);
//        u.setIntegralnum(0);
//        u.setHometown("");
//        u.setAuthentication("0");
//        u.setIsapply("0");
//        u.setIsperfect("0");
//        u.setBinvitenum(req.getUserInviteCode());// 邀请人
//        u.setStatus("0");// 状态 0正常 1禁用
//        u.setAdtime(new Date());
//        int result = tuserService.addUser(u);
//        res.setUid(id);
//        try {
//            if (result > 0) {
//                // 赠送积分
//                if (StringUtils.isNotBlank(req.getUserInviteCode())) {
//                    try {
//                        Tuser uu = tuserService.findUniqueByProperty("invitenum", req.getUserInviteCode());
//                        if(null != uu) {
//                            tuserService.updateScore(uu.getId(), 20, 0, "邀请好友");
//                        }
//
//                    } catch (Exception e) {
//                        logger.error("请求处理异常：1060" );
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        res.setToken(JwtToken.createToken(request, u));
//        res.setResult("0");
//        res.setResultNote("注册成功");
//        return res;
//    }

//    /**
//     * 验证登录
//     * @param request
//     * @return
//     * @throws Exception
//     */
//    public ResJson codec(HttpServletRequest request) throws Exception {
//        UserLoginRes res = new UserLoginRes();
//        res.setResult("0");
//        res.setResultNote("登录成功");
//        Tuser tuser = new Tuser();
//        if (StringUtils.isBlank(request.getHeader("token"))) {
//            JSONObject req = JSONObject.parseObject(request.getParameter("json").toString());
//            if(req.containsKey("uid")&&StringUtils.isNotBlank(req.getString("uid"))){
//                tuser = tuserService.get(req.getString("uid"));
//                res.setToken(JwtToken.createToken(request, tuser));
//            }else{
//                res.setResult("2");//登录已失效专用字CODE
//                res.setResultNote("登录已失效，请重新登录！");
//            }
//        } else if (JwtToken.validateToken(request.getHeader("token"))) {
//            tuser = tuserService.get(JwtToken.getAppUID(request.getHeader("token")));
//            res.setToken(JwtToken.createToken(request, tuser));
//        } else {
//            res.setResult("2");//登录已失效专用字CODE
//            res.setResultNote("登录已失效，请重新登录！");
//        }
//        if(res.getResult().equals("0")){
//            Map<String,Object>ordernum = couponService.execSelectSqlEntityObjMap("SELECT COUNT(1) as num FROM t_user_order a where a.uid='"+tuser.getId()+"' AND a.`status`!='12'");
//            if(Double.valueOf(ordernum.get("num").toString())==0&&StringUtils.isNotBlank(tuser.getCommunityid())){//未购买过的用户
//                //添加用户指定的天数
//                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//                // 查看是否有特定优惠劵
//                List<Coupon> coupon = couponService.selectSpecificCoupon(tuser.getCommunityid(), "1");
//                List<Map<String, String>> dataList = new ArrayList<>();
//                if (null != coupon && coupon.size() > 0) {
//                    for (Coupon coupon2 : coupon) {
//                        UserCoupon uc = new UserCoupon();
//                        String startDays = DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getStartCouponDay()));
//                        String endDays= DateTimeUtil.addDate(new Date(), StringUtils.isBlank(coupon2.getEndCouponDay())?
//                                0:StringUtils.isBlank(coupon2.getStartCouponDay())?0:Integer.valueOf(coupon2.getEndCouponDay())+Integer.valueOf(coupon2.getStartCouponDay()));
//                        uc.setUid(tuser.getId());
//                        uc.setCouponid(coupon2.getId());
//                        List<UserCoupon> list = userCouponService.findList(uc);
//                        if (list != null && list.size() > 0) {
//                            //							res.setResultNote("不能重复领取");
//                            //							return res;
//                            continue;
//                        }
//                        uc.setCommunityid(coupon2.getCommunityid());
//                        uc.setCommunityname(coupon2.getCommunityname());
//                        uc.setAllmoney(coupon2.getAllmoney());
//                        uc.setAmount(coupon2.getAmount());
//                        uc.setType(coupon2.getType());
//                        uc.setStartdate(sf.parse(startDays));
//                        uc.setEnddate(sf.parse(endDays));
//                        uc.setStatus("0");
//                        uc.setAdtime(new Date());
//                        userCouponService.save(uc);// 插入到我的优惠劵表
//
//                        Map<String, String> map = new HashMap<String, String>();
//                        map.put("securitiesid", coupon2.getId());
//                        map.put("communityId", coupon2.getCommunityid());
//                        map.put("communityName", coupon2.getCommunityname());
//                        map.put("securitiesMoney", coupon2.getAllmoney() + "");
//                        map.put("securitiesType", coupon2.getType());
//                        map.put("securitiesName", coupon2.getName());
//                        map.put("securitiesImg", filePath + coupon2.getImage());
//                        map.put("securitiesPrice", coupon2.getAmount() + "");
//                        map.put("securitiesStartTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(startDays)));
//                        map.put("securitiesEndTime", DateFormatUtil.ISO_ON_DATE_FORMAT.format(sf.parse(endDays)));
//                        dataList.add(map);
//
//                    }
//                    res.setDataList(dataList);
//                }
//            }
//        }
//        return res;
//    }


    /**
     * 1.2用户登录
     *
     * @param req
     * @return
     * @throws Exception
     */
    @Override
    public ResJson codec(HttpServletRequest request, UserLoginReq req) throws Exception {
        UserLoginRes res = new UserLoginRes();
        res.setResultNote("登录失败");
        if (StrUtil.isBlank(req.getPhone())) {
            res.setResultNote("手机号不能为空");
            return res;
        }
        TShopHomeBaseInfo tuser = shopHomeBaseInfoService.getInfoByLoginNo(req.getPhone());
        if (StrUtil.isBlank(req.getPassword())) {
            res.setResultNote("密码不能为空");
            return res;
        }
        if (null == tuser || !req.getPassword().equals(tuser.getPassword())) {
            res.setResultNote("手机号或密码错误");
        } else if (!SysContent.INTGER_0.equals(tuser.getStatus())) {
            res.setResultNote("该用户已被禁用");
        } else {
            res.setResult("0");
            res.setResultNote("登录成功");
            res.setUid(tuser.getId().toString());
            res.setToken(JwtToken.createToken(request, tuser));
        }
        try {
            // 登录成功后修改token
            if (StrUtil.isNotBlank(req.getToken()) && "0".equals(res.getResult())) {
                tUserService.updateToken(tuser.getId(), req.getToken());
            }
        } catch (Exception e) {
           log.error(e.getMessage());
        }
        return res;
    }

    @Override
    public String getRandomCodesByPhone(String phone,String codeType) {
        String randomCodes = String.valueOf( CacheUtils.get("code" + phone,codeType));
        return randomCodes;
    }
    /**
     * 获取登录成功的token
     * @param req
     * @return
     */
    @Override
    public String getShopLoginSucessToken(HttpServletRequest request,UserLoginReq req,UserLoginRes res ,TShopHomeBaseInfo c) throws Exception {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(req.getToken()) &&
                SysContent.INTGER_0.toString().equals(res.getResult())) {
            shopHomeBaseInfoService.updateToken(c.getId(), req.getToken());
            List<TCommunnityToken> listTokens = communnityTokenService.getByToken(req.getToken());
            if (null == listTokens || listTokens.size() == 0) {
                TCommunnityToken tt = new TCommunnityToken();
                tt.setAdtime(new Date());
                tt.setDelFlag(SysContent.INTGER_0.toString());
                tt.setShopId(c.getId());
                tt.setToken(req.getToken());
                communnityTokenService.save(tt);
            }
        }
        TShopHomeBaseInfo user = new TShopHomeBaseInfo();
        user.setId(c.getId());
        user.setPassword(c.getPassword());
        String token= JwtToken.createToken(request, user);
        return token;
    }

    @Override
    public void deleteImag(String[] url) throws Exception {
        try {
            for (String s : url) {
                String imgUrl=s.replace(imgDoConfig.getPrefix(),imgDoConfig.getFilePath());
                File file=new File(imgUrl);
                if(file.exists()){
                    file.delete();
                }
            }

        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }

    }

    @Override
    public ResJson getZjInfo(Map<String, Object> map) {
        try {
            String type=map.get(SysContent.ZJTYPE_STR).toString();
            String url=imgDoConfig.getFilePath()+map.get(SysContent.URL_STR).toString().replace(imgDoConfig.getPrefix(),"");
            //身份证
            if(SysContent.CARDZ_STR.equals(type)){
                CardInfo cardInfo=new CardInfo();
                String json=  OcrBaiduUtil.idcard(url);
                cardInfo.setCardNum(getWords(SysContent.NUM_CARD,json));
                cardInfo.setName(getWords(SysContent.NAME_CARD,json));
                return ResJson.Ok(cardInfo);
            }else if(SysContent.CARDF_STR.equals(type)){
                CardInfo cardInfo=new CardInfo();
                String json=  OcrBaiduUtil.idcard(url);
                String time1=getWords(SysContent.JFRQ_CARD,json);
                String time2=getWords(SysContent.SXRJ_CARD,json);
                time1= DateUtils.dateFormat(time1,"yyyyMMdd","yyyy/MM/dd");
                if(!SysContent.CQ_STR.equals(time2)) {
                    time2 = DateUtils.dateFormat(time2, "yyyyMMdd", "yyyy/MM/dd");
                }
                cardInfo.setTime(time1+"-"+time2);
                return ResJson.Ok(cardInfo);
            }else if(SysContent.BANK_CARD_STR.equals(type)){
                String json=JSONUtil.parseObj(OcrBaiduUtil.bankCard(url)).getStr(SysContent.RESULT);
                BankCardVo bankCardVo= JSONUtil.toBean(json,BankCardVo.class);
                if(BankCardTypeVo.TYPE_0.getCode().equals(bankCardVo.getBank_card_type())){
                    return ResJson.error(BankCardTypeVo.TYPE_0.getName());
                }
                bankCardVo.setBank_card_type_name(BankCardTypeVo.getNameByCode(bankCardVo.getBank_card_type()));
                return ResJson.Ok(bankCardVo);
            }else if(SysContent.SHOPSHIRO.equals(type)){
                String json=OcrBaiduUtil.businessLicense(url);
                BusinessVo vo=new BusinessVo();
                vo.setCreditCode(getWords(SysContent.XYDM_STR,json));
                vo.setCommpayName(getWords(SysContent.DWMC_STR,json));
                vo.setCreateDt(getWords(SysContent.CJSJ_STR,json));
                vo.setType(getWords(SysContent.LX_STR,json));
                vo.setValidTime(getWords(SysContent.YXQ_STR,json));
                vo.setBusinessScope(getWords(SysContent.JYFW_STR,json));
                vo.setLegalPerson(getWords(SysContent.FR_NAME,json));
                return ResJson.Ok(vo);
            }else{
                return ResJson.error(SysContent.ERROR_ZJLX);
            }
        } catch (Exception e) {
            return ResJson.error(SysContent.ERROR_ZJLX+e.getMessage());
        }
    }

    @Override
    public ResJson getBankIfo(String btype,String province,String city,String bank) throws Exception {
        List<Tree<TBankInfo>> trees = new ArrayList<Tree<TBankInfo>>();
        List<TBankInfo> data = tBankInfoService.getInfoByType(Integer.valueOf(btype), province, city, bank);
        if(null==data){
            throw new Exception(SysContent.ERROR_WUSHUJU);
        }
        Set<SelectVo> selectPVos = new HashSet<>();
        if (SysContent.INTGER_1.toString().equals(btype)) {
            for (TBankInfo tb : data) {
                SelectVo selectVo = new SelectVo();
                selectVo.setCode(tb.getProvince());
                selectVo.setLabel(tb.getProvince());
                selectPVos.add(selectVo);
            }
            for (SelectVo selectPVo : selectPVos) {
                Set<SelectVo> sp = new HashSet<>();
                for (TBankInfo tb : data) {
                    if (tb.getProvince().equals(selectPVo.getCode())) {
                        SelectVo sv = new SelectVo();
                        sv.setCode(tb.getCity());
                        sv.setLabel(tb.getCity());
                        sp.add(sv);
                        continue;
                    }
                    continue;
                }
                selectPVo.setChildList(new ArrayList<>(sp));
            }

            return ResJson.Ok(selectPVos);
        } else if (SysContent.INTGER_2.toString().equals(btype)) {
            for (TBankInfo tb : data) {
                SelectVo selectVo = new SelectVo();
                selectVo.setCode(tb.getBankName());
                selectVo.setLabel(tb.getBankName());
                selectPVos.add(selectVo);
            }
            for (SelectVo selectPVo : selectPVos) {
                Set<SelectVo> sp = new HashSet<>();
                for (TBankInfo tb : data) {
                    if (tb.getBankName().equals(selectPVo.getCode())) {
                        SelectVo sv = new SelectVo();
                        sv.setCode(tb.getBankChild());
                        sv.setLabel(tb.getBankChild());
                        sv.setCode(tb.getBankNum());
                        sp.add(sv);
                        continue;
                    }
                    continue;
                }
                selectPVo.setChildList(new ArrayList<>(sp));
            }
            return ResJson.Ok(selectPVos);
        } else {
            throw new Exception(SysContent.ERROR_PARAM);
        }
    }

    @Override
    public ResJson geAboutById(String id) {
        TAbout tAbout = tAboutService.geAboutById(id);
        if (null != tAbout) {
            return ResJson.Ok(tAbout);
        }
        return ResJson.error(SysContent.ERROR_WUSHUJU);
    }

    @Override
    public ResJson getYwyByCode(String code) {
        SysSalesman sysSalesman = sysSalesmanService.getOneByCode(code);
        if (null != sysSalesman) {
            return ResJson.Ok(SysContent.YWY_OK);
        }
        return ResJson.error(SysContent.ERROR_YWY);
    }

    @Override
    public Object getCommunitySelect(String type) {
        List<SelectVo> list = new ArrayList<>();
        if (SysContent.INTGER_1.toString().equals(type)) {
            list = tCommunityService.getSelectVo();
        } else if (SysContent.INTGER_2.toString().equals(type)) {
            TreeUtil<SelectVo> listdata = tCommunityService.getTreeSelectVo();
            return listdata;
        }

        return list;
    }

    @Override
    public Object getShopClassSelect() {
        List<SelectVo> list = shopHomeGroupService.getSelectInfo();
        return list;
    }

    @Override
    public String getBankLogoByCardNo(String cardNo) throws Exception {

        String image= null;
        try {
            String result=bankDo.getHttpUrl();
            String url=result.replace("{cardNo}",cardNo);
            String str=HttpUtil.get(url);
            JSONObject jsonObject=JSONUtil.parseObj(str);
            //{
            //    "bank": "PSBC",
            //    "cardType": "DC",
            //    "key": "6221506020009066385",
            //    "messages": [],
            //    "stat": "ok",
            //    "validated": true
            //}
            String bank=jsonObject.getStr("bank");
            String logourl=bankDo.getLogoUrl();
            image = logourl.replace("{code}",bank);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return image;
    }

    public String getWords(String key,String json){
          JSONObject jsonObject= JSONUtil.parseObj(json).getJSONObject(SysContent.WORDSRESULT);
          return jsonObject.getJSONObject(key).getStr(SysContent.WORDS);
    }
    /**
     * 验证Token
     * @param token
     * @return
     * @throws Exception
     */
    public  boolean validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JwtToken.SECRET)).build();
            verifier.verify(token);
            String uid=getAppUID(token);
            TUser tuser = tUserService.getByToken(getAppUID(token));
            if(null == tuser || null == tuser.getId()){//社区
                TShopHomeBaseInfo comm = shopHomeBaseInfoService.getByToken(uid);
                String pw = comm.getPassword()==null?"":comm.getPassword();
                if(!pw.equals(getOldPw(token))){
                    return false;
                }
            }else{//用户
                String pw = tuser.getPassword()==null?"":tuser.getPassword();
                if(!pw.equals(getOldPw(token))){
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /**
     * 验证Token如果成功并返回用户信息
     * @param token
     * @return
     * @throws Exception
     */
    public R validateToken2(String token) {
        Map<String,String> result = Maps.newHashMap();
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JwtToken.SECRET)).build();
            verifier.verify(token);
            String uid=getAppUID(token);
            TUser tuser = tUserService.getByToken( uid);
            if(null == tuser){//社区
                TShopHomeBaseInfo comm = shopHomeBaseInfoService.getByToken(uid);
                String pw = comm.getPassword()==null?"":comm.getPassword();
                if(!pw.equals(getOldPw(token)) || !SysContent.INTGER_0.equals(comm.getStatus())){
                   return  R.ok(null);
                }
            }else{//用户
                String pw = tuser.getPassword()==null?"":tuser.getPassword();
                if(!pw.equals(getOldPw(token)) || !SysContent.INTGER_0.equals(tuser.getStatus())){
                    return  R.ok(null);
                }
            }
           return R.failed("error");
        } catch (Exception e) {
            return R.failed("error");
        }
    }
    /**
     * (异业联盟)验证Token如果成功并返回用户信息
     * @param token
     * @return
     * @throws Exception
     */
//    public  Map<String,String> validateToken3(String token) {
//        Map<String,String> result = Maps.newHashMap();
//        try {
//            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JwtToken.SECRET)).build();
//            verifier.verify(token);
//            String uid = getAppUID(token);
//            TShopHomeBaseInfo comm = s.findUniqueByProperty("id", uid);
//            String pw = comm.getPassword()==null?"":comm.getPassword();
//            if(!pw.equals(getOldPw(token))||!"0".equals(comm.getState())){
//                result.put("flag", "0");
//                return result;
//            }
//            result.put("flag", "1");
//            result.put("uid", uid);
//            result.put("communityid", comm.getCommunityId());
//        } catch (Exception e) {
//            result.put("flag", "0");
//            return result;
//        }
//        return result;
//    }
    /**
     * 只验证Token是否过期
     * @param token
     * @return
     * @throws Exception
     */
    public static boolean validateTokenSimple(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JwtToken.SECRET)).build();
            verifier.verify(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /**
     * 解密Token
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JwtToken.SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            Map failMap = Maps.newHashMap();
            failMap.put("failMsg",JwtToken.DEFAULT_FAIL_MSG);
            return failMap;
        }
        return jwt.getClaims();
    }
    public static Map<String, Claim> getToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        log.info(jwt.getClaim(JwtToken.DEFAULT_KEYNAME_PHONE_ID).asString());
        log.info(jwt.getIssuer());
        log.info(DateUtils.formatDate(jwt.getIssuedAt(), "yyyy-MM-dd HH:mm:ss"));
        log.info(DateUtils.formatDate(jwt.getExpiresAt(), "yyyy-MM-dd HH:mm:ss"));
        log.info(jwt.getClaim(JwtToken.DEFAULT_KEYNAME_USER_ID).asString());
        log.info(jwt.getClaim(JwtToken.DEFAULT_KEYNAME_USER_PW).asString());
        return jwt.getClaims();
    }
    /**
     * 根据Token获取user_id
     * @param token
     * @return user_id
     */
    public static String getAppUID(String token){
        Map<String, Claim> claims = verifyToken(token);
        Claim user_id_claim = claims.get(JwtToken.DEFAULT_KEYNAME_USER_ID);
        if (null == user_id_claim || StringUtils.isEmpty(user_id_claim.asString())) {
            return JwtToken.DEFAULT_FAIL_MSG;
            // token 校验失败, 抛出Token验证非法异常
        }
        return decrypt(user_id_claim.asString());
    }
    /**
     * 根据Token获取communityid
     * @param token
     * @return communityid
     */
    public  String getAppCID(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JwtToken.SECRET)).build();
            verifier.verify(token);
            TShopHomeBaseInfo shopHomeBaseInfo = shopHomeBaseInfoService.getByToken(getAppUID(token));
            if(null == shopHomeBaseInfo ){
                return "";
            }
            return shopHomeBaseInfo.getId().toString();
        } catch (Exception e) {
            return "";
        }
    }
    /**
     * 获取TOKEN中的pw
     * @param token
     * @return
     */
    public static String getOldPw(String token){
        Map<String, Claim> claims = verifyToken(token);
        Claim user_id_claim = claims.get(JwtToken.DEFAULT_KEYNAME_USER_PW);
        if (null == user_id_claim) {
            return JwtToken.DEFAULT_FAIL_MSG;
            // token 校验失败, 抛出Token验证非法异常
        }
        return decrypt(user_id_claim.asString());
    }
    //加密
    private static String encrypt(String ss){
        try {
            if(null!=ss && !"".equals(ss)){
                SecretKey aesKey = AESUtils.loadKeyAES(JwtToken.SECRET.substring(0, 16));
                IvParameterSpec ivAes = AESUtils.loadIvAES(JwtToken.SECRET.substring(0, 16));
                return new String(Base64Utils.byte2Base64(AESUtils.encryptAES(ss.getBytes(), aesKey, ivAes)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    //解密
    private static String decrypt(String ss){
        try {
            SecretKey aesKey = AESUtils.loadKeyAES(JwtToken.SECRET.substring(0, 16));
            IvParameterSpec ivAes = AESUtils.loadIvAES(JwtToken.SECRET.substring(0, 16));
            return new String(AESUtils.decryptAES(Base64Utils.base642Byte(ss), aesKey, ivAes));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "";
    }
}
