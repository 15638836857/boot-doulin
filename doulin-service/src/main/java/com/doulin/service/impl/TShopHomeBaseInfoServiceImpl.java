package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.common.UserLoginReq;
import com.doulin.entity.common.UserLoginRes;
import com.doulin.entity.shop.ShopApplicyStatus;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopHomeBaseInfoMapper;
import com.doulin.service.ShopToTreeService;
import com.doulin.service.TCommunnityTokenService;
import com.doulin.service.TShopHomeBaseInfoService;
import com.doulin.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * TShopHomeBaseInfoServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopHomeBaseInfoServiceImpl extends ServiceImpl<TShopHomeBaseInfoMapper, TShopHomeBaseInfo> implements TShopHomeBaseInfoService {

    @Autowired
    private TShopHomeBaseInfoMapper shopHomeBaseInfoMapper;
    @Autowired
    private TCommunnityTokenService communnityTokenService;
    @Autowired
    private UtilService utilService;
    @Autowired
    private ShopToTreeService shopToTreeService;
    @Override
    public IPage<TShopHomeBaseInfo> page(VQuery query) {
        IPage<TShopHomeBaseInfo> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public TShopHomeBaseInfo getInfoByLoginNo(String loginNo) {

        return shopHomeBaseInfoMapper.selectByLoginNo(loginNo);
    }

    @Override
    public TShopHomeBaseInfo getByToken(String token) {
        QueryWrapper<TShopHomeBaseInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(SysContent.DEL_FLAG,SysContent.INTGER_0);
        queryWrapper.eq(SysContent.TOKEN_STR,token);
        return getOne(queryWrapper);
    }

    @Override
    public void updateToken(Integer id, String token) {
        TShopHomeBaseInfo shopHomeBaseInfo=getById(id);
        shopHomeBaseInfo.setToken(token);
        updateById(shopHomeBaseInfo);
    }

    @Override
    public TShopHomeBaseInfo addPassByPhone(HttpServletRequest request, TShopHomeBaseInfo tShopHomeBaseInfo) throws Exception {
        try {
            String loginNo=tShopHomeBaseInfo.getLoginNo(), password=tShopHomeBaseInfo.getPassword();
            TShopHomeBaseInfo shopHomeBaseInfo=getInfoByLoginNo(loginNo);
            if(null==shopHomeBaseInfo){
                shopHomeBaseInfo=new TShopHomeBaseInfo();
                shopHomeBaseInfo.setDelFlag(SysContent.INTGER_0);
                shopHomeBaseInfo.setLoginNo(loginNo);
                shopHomeBaseInfo.setPassword(password);
                shopHomeBaseInfo.setAddDt(new Date());
                shopHomeBaseInfo.setShopHomeCode(SysContent.COMMUNITY_CODE+System.currentTimeMillis());
                shopHomeBaseInfo.setApplyState(ShopApplicyStatus.STATUS_0.getCode());
                save(shopHomeBaseInfo);
            }else{
                shopHomeBaseInfo.setEditDt(new Date());
                shopHomeBaseInfo.setLoginNo(loginNo);
                shopHomeBaseInfo.setPassword(password);
                updateById(shopHomeBaseInfo);
            }
            UserLoginReq req=new UserLoginReq();
            req.setLoginType(SysContent.INTGER_2.toString());
            req.setType(SysContent.INTGER_1.toString());
            req.setCodeType("6");
            UserLoginRes res= UserLoginRes.Ok(SysContent.LOGIN_SUCCESS,String.valueOf(shopHomeBaseInfo.getId()),shopHomeBaseInfo.getRyToken());
            shopHomeBaseInfo.setToken(utilService.getShopLoginSucessToken(request,req,res,shopHomeBaseInfo));
            return shopHomeBaseInfo;
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }
    }

    @Override
    public void updateInfoById(TShopHomeBaseInfo tsb) throws Exception {
        try {
            if (SysContent.INTGER_3 == tsb.getApplyState()) {
                shopToTreeService.operToSykAddOrUpdate(tsb, SysContent.Mchinlet, SysContent.ADD);
                //申请状态 Z申请中
                tsb.setApplyFlag(SysContent.Z_STR);
            }
            updateById(tsb);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}