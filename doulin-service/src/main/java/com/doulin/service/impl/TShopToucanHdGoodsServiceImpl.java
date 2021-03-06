package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopToucanHd;
import com.doulin.entity.TShopToucanHdGoods;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopToucanHdGoodsMapper;
import com.doulin.service.TShopToucanHdGoodsService;
import com.doulin.service.TShopToucanHdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
* TShopToucanHdGoodsServiceImpl
* @Author malinging
* @Date 2021-05-14
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopToucanHdGoodsServiceImpl extends ServiceImpl<TShopToucanHdGoodsMapper, TShopToucanHdGoods> implements TShopToucanHdGoodsService {

    @Autowired
    private TShopToucanHdGoodsMapper shopToucanHdGoodsMapper;
    @Autowired
    private TShopToucanHdService shopToucanHdService;
    @Override
    public IPage<TShopToucanHdGoods> page(VQuery query) {
        IPage<TShopToucanHdGoods> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void addOrUpdate(String oper, TShopToucanHdGoods tShopToucanHdGoods, String hdName, String tcName, String openFlag) throws Exception {
        if (SysContent.OPER_ADD.equals(oper)) {
//            if (StrUtil.isEmpty(tcName)) {
//                throw new Exception(SysContent.ERROR_PARAM);
//            }
            if (null==tShopToucanHdGoods.getShopGoodsId()) {
                throw new Exception(SysContent.ERROR_PARAM);
            }
            tShopToucanHdGoods.setAddDt(new Date());
            tShopToucanHdGoods.setDelFlag(SysContent.INTGER_0);
            //???????????? ??????
            if (StrUtil.isEmpty(tShopToucanHdGoods.getValidFlag())) {
                tShopToucanHdGoods.setValidFlag(SysContent.N_STR);
            }
            if(!StrUtil.isEmpty(tcName)){
                tShopToucanHdGoods.setName(tcName);
            }
            save(tShopToucanHdGoods);
        } else if (SysContent.OPER_EDIT.equals(oper)) {//??????
            if (null == tShopToucanHdGoods.getId()) {
                throw new Exception(SysContent.ERROR_PARAM);
            }
            if (null==tShopToucanHdGoods.getShopGoodsId()) {
                throw new Exception(SysContent.ERROR_PARAM);
            }
            if(!StrUtil.isEmpty(tcName)) {
                tShopToucanHdGoods.setName(tcName);
            }
            updateById(tShopToucanHdGoods);
        } else if (SysContent.OPER_DELETE.equals(oper)) {//??????
            if (null == tShopToucanHdGoods.getId()) {
                throw new Exception(SysContent.ERROR_PARAM);
            }
            tShopToucanHdGoods.setDelFlag(SysContent.INTGER_1);
            tShopToucanHdGoods.setEditDt(new Date());
            updateById(tShopToucanHdGoods);

        } else if (SysContent.OPER_OPEN.equals(oper)) {
            //???????????????????????????????????? ???????????????
            TShopToucanHd thd = shopToucanHdService.getByShopHomeCodeAndOrderType(tShopToucanHdGoods.getShopHomeCode()
                    , tShopToucanHdGoods.getOrderType());
            if (null == thd) {
                thd = new TShopToucanHd();
                thd.setName(hdName);
                thd.setAddDt(new Date());
                thd.setOpenFlag(openFlag);
                thd.setShopHomeCode(tShopToucanHdGoods.getShopHomeCode());
                thd.setOrderType(tShopToucanHdGoods.getOrderType());
                shopToucanHdService.save(thd);
            } else {
                //??????????????????
                if(!StrUtil.isEmpty(hdName)) {
                    thd.setName(hdName);
                }
                thd.setEditDt(new Date());
                thd.setOpenFlag(openFlag);
                shopToucanHdService.updateById(thd);
            }
           //??????????????????
            List<TShopToucanHdGoods> list = getInfoByShopHomeCode(tShopToucanHdGoods.getShopHomeCode(), tShopToucanHdGoods.getOrderType());
            //?????????  ??????????????????????????????   ???????????????????????? ?????????  ????????????????????? ????????????
            if(SysContent.JJG.equals(tShopToucanHdGoods.getOrderType())){
                    Date upateTime = new Date();
                if(null!=list && !list.isEmpty()){
                    //???????????????ids ????????????id ??????????????????  ??????????????????
                    for (TShopToucanHdGoods coupon : list) {
                        coupon.setValidFlag(SysContent.Y_STR);
                        //????????? ????????????
                        if (null != tShopToucanHdGoods.getConsumeMoney()) {
                            coupon.setConsumeMoney(tShopToucanHdGoods.getConsumeMoney());
                        }
                        coupon.setEditDt(upateTime);
                    }
                    updateBatchById(list);
                }else{
                    tShopToucanHdGoods.setAddDt(upateTime);
                    tShopToucanHdGoods.setDelFlag(SysContent.INTGER_0);
                    tShopToucanHdGoods.setValidFlag(SysContent.Y_STR);
                    save(tShopToucanHdGoods);
//                    TShopToucanHdGoods ts=new TShopToucanHdGoods();
//                    ts.setAddDt(upateTime);
//                    ts.setDelFlag(SysContent.INTGER_0);
//                    ts.setOrderType(tShopToucanHdGoods.getOrderType());
//                    ts.setShopHomeCode(tShopToucanHdGoods.getShopHomeCode());
//                    ts.setShopGoodsId(tShopToucanHdGoods.getShopGoodsId());
//                    ts.setShopGoodsSkuId(tShopToucanHdGoods.getShopGoodsSkuId());
//                    ts.setConsumeMoney(tShopToucanHdGoods.getConsumeMoney());
//                    ts.setAddMoney(tShopToucanHdGoods.getAddMoney());
                }


            }else {
                //???????????????????????????
                String ids = tShopToucanHdGoods.getIds();
                if (SysContent.Y_STR.equals(openFlag)) {
                    if (StrUtil.isEmpty(ids)) {
                        throw new Exception(SysContent.ERROR_PARAM);
                    } else {
                        if (null != list && !list.isEmpty()) {
                            List<String> idsList = Arrays.asList(ids.split(SysContent.EN_D));
                            Date upateTime = new Date();
                            //???????????????ids ????????????id ??????????????????  ??????????????????
                            for (TShopToucanHdGoods coupon : list) {
                                if (idsList.contains(coupon.getId().toString())) {
                                    coupon.setValidFlag(SysContent.Y_STR);
                                } else {
                                    coupon.setValidFlag(SysContent.N_STR);
                                }
                                //????????? ????????????
                                if (null != tShopToucanHdGoods.getConsumeMoney()) {
                                    coupon.setConsumeMoney(tShopToucanHdGoods.getConsumeMoney());
                                }
                                coupon.setEditDt(upateTime);
                            }
                            updateBatchById(list);
                        } else {
                            throw new Exception(SysContent.ERROR_DATA);
                        }
                    }
                }
            }
        } else {
            throw new Exception(SysContent.ERROR_PARAM);
        }
    }

    @Override
    public List<TShopToucanHdGoods> getInfoByShopHomeCode(String shopHomeCode, String orderType) {
        return  shopToucanHdGoodsMapper.selectByShopHomeCodeAndOrderType(shopHomeCode,orderType);
    }
}