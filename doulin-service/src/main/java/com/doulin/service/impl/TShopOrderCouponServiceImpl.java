package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopOrderCoupon;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopOrderCouponMapper;
import com.doulin.service.TShopOrderCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
* TShopOrderCouponServiceImpl 商家订单返券
* @Author malinging
* @Date 2021-05-13
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopOrderCouponServiceImpl extends ServiceImpl<TShopOrderCouponMapper, TShopOrderCoupon> implements TShopOrderCouponService {

    @Autowired
    private TShopOrderCouponMapper tShopOrderCouponMapper;
    @Override
    public IPage<TShopOrderCoupon> page(VQuery query) {
        IPage<TShopOrderCoupon> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void saveAndUpdate(String oper, TShopOrderCoupon tShopOrderCoupon) throws Exception {
        if (SysContent.OPER_ADD.equals(oper) || SysContent.OPER_EDIT.equals(oper)) {
             if (null == tShopOrderCoupon.getConsumeMoney()) {
                throw new Exception(SysContent.ERROR_PARAM);
            } else if (StrUtil.isEmpty(tShopOrderCoupon.getShopHomeCode())) {
                throw new Exception(SysContent.ERROR_PARAM);
            }  else if (null == tShopOrderCoupon.getToMoneySend()) {
                throw new Exception(SysContent.ERROR_PARAM);
            }
        }

        if (SysContent.OPER_ADD.equals(oper)) {
            tShopOrderCoupon.setAddDt(new Date());
            tShopOrderCoupon.setDelFlag(SysContent.INTGER_0);
            if(StrUtil.isEmpty( tShopOrderCoupon.getOpenFlag())) {
                tShopOrderCoupon.setOpenFlag(SysContent.N_STR);
            }
            save(tShopOrderCoupon);
        } else if (SysContent.OPER_EDIT.equals(oper)) {//修改
            if (null == tShopOrderCoupon.getId()) {
                throw new Exception(SysContent.ERROR_PARAM);
            }
            updateById(tShopOrderCoupon);
        } else if (SysContent.OPER_DELETE.equals(oper)) {//删除
            if (null == tShopOrderCoupon.getId()) {
                throw new Exception(SysContent.ERROR_PARAM);
            }
            tShopOrderCoupon.setDelFlag(SysContent.INTGER_1);
            tShopOrderCoupon.setEditDt(new Date());
            updateById(tShopOrderCoupon);

        } else if (SysContent.OPER_OPEN.equals(oper)) {
            if (SysContent.N_STR.equals(tShopOrderCoupon.getOpenFlag())) {//设置关闭
                String shopHomeCode=tShopOrderCoupon.getShopHomeCode();
                String orderType= tShopOrderCoupon.getOrderType();
                String openFlag=tShopOrderCoupon.getOpenFlag();
                tShopOrderCouponMapper.openOrCloseBy(shopHomeCode,orderType,openFlag);
            } else {//设置有效
                List<TShopOrderCoupon> list = getInfoByShopHomeCode(tShopOrderCoupon.getShopHomeCode(), tShopOrderCoupon.getOrderType());
                String ids = tShopOrderCoupon.getIds();
                if (StrUtil.isEmpty(ids)) {
                    throw new Exception(SysContent.ERROR_PARAM);
                }

                if (null != list && !list.isEmpty()) {
                    List<String> idsList = Arrays.asList(ids.split(SysContent.EN_D));
                    Date upateTime = new Date();
                    //判断生效的ids 是否包含id 设置生效状态  其它修改无效
                    for (TShopOrderCoupon coupon : list) {
                        if (idsList.contains(coupon.getId().toString())) {
                            coupon.setValidFlag(SysContent.Y_STR);
                        } else {
                            coupon.setValidFlag(SysContent.N_STR);
                        }
                        coupon.setEditDt(upateTime);
                        coupon.setOpenFlag(tShopOrderCoupon.getOpenFlag());
                    }
                    updateBatchById(list);
                } else {
                    throw new Exception(SysContent.ERROR_DATA);
                }
            }


        } else {
            throw new Exception(SysContent.ERROR_PARAM);
        }
    }

    @Override
    public List<TShopOrderCoupon> getInfoByShopHomeCode(String shopHomeCode,String orderType) {
        return tShopOrderCouponMapper.selectInfoByShopHomeCode(shopHomeCode,orderType);
    }

}