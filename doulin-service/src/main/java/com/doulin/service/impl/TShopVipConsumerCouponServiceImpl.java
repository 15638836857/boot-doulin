package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopVipConsumerCoupon;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopVipConsumerCouponMapper;
import com.doulin.service.TShopVipConsumerCouponService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
* TShopVipConsumerCouponServiceImpl
* @Author malinging
* @Date 2021-05-07
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopVipConsumerCouponServiceImpl extends ServiceImpl<TShopVipConsumerCouponMapper, TShopVipConsumerCoupon> implements TShopVipConsumerCouponService {

    @Autowired
    private TShopVipConsumerCouponMapper shopVipConsumerCouponMapper;
    @Override
    public IPage<TShopVipConsumerCoupon> page(VQuery query) {
        IPage<TShopVipConsumerCoupon> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void operData(String oper, TShopVipConsumerCoupon shopVipConsumerCoupon) throws Exception {
        if (SysContent.OPER_ADD.equals(oper)) {
           if(StrUtil.isEmpty(shopVipConsumerCoupon.getName())){
               throw new Exception("规则名称不能为空");
           }else if(StrUtil.isEmpty(shopVipConsumerCoupon.getShopHomeCode())){
               throw new Exception(SysContent.ERROR_SHOP_HOME_CODE);
           }else if(null==shopVipConsumerCoupon.getConsumeMoney()){
               throw new Exception("使用门槛的不能为空");
           }else if(null==shopVipConsumerCoupon.getToMoneySend()){
               throw new Exception("优惠券金额不能为空");
           }else if(null==shopVipConsumerCoupon.getTimeDay()){
               throw new Exception("有效期不能为空");
           }else{
               shopVipConsumerCoupon.setDelFlag(SysContent.INTGER_0);
               save(shopVipConsumerCoupon);
           }
        } else if (SysContent.OPER_EDIT.equals(oper)) {
            if(null==shopVipConsumerCoupon.getId()){
                throw new Exception(SysContent.ERROR_ID);
            }else if(null==shopVipConsumerCoupon.getConsumeMoney()){
                throw new Exception("使用门槛的不能为空");
            }else if(null==shopVipConsumerCoupon.getToMoneySend()){
                throw new Exception("优惠券金额不能为空");
            }else if(null==shopVipConsumerCoupon.getTimeDay()){
                throw new Exception("有效期不能为空");
            }else{
                updateById(shopVipConsumerCoupon);
            }
        } else if (SysContent.OPER_DELETE.equals(oper)) {
            if(null==shopVipConsumerCoupon.getId()){
                throw new Exception(SysContent.ERROR_ID);
            }else{
                shopVipConsumerCoupon.setDelFlag(SysContent.INTGER_1);
                updateById(shopVipConsumerCoupon);
            }
        } else {
            throw new Exception(SysContent.ERROR_OPER);
        }
    }

    @Override
    public List<Map<String, Object>> getVipCoupons(String loginNo,String name) {
        List<TShopVipConsumerCoupon> list=shopVipConsumerCouponMapper.selectVipCoupons(loginNo,name);
        if(null!=list&&!list.isEmpty()) {
            Set<String> listname=new HashSet<String>();
            for (TShopVipConsumerCoupon t : list) {
                listname.add(t.getName());
            }
            List<Map<String, Object>> result = new ArrayList<>();
            for (String s : listname) {
                Map<String, Object> map=Maps.newHashMap();
                List<TShopVipConsumerCoupon> listresult=new ArrayList<>();
                for (TShopVipConsumerCoupon t : list) {
                    String namestr=t.getName();
                    if(s.equals(namestr)){
                        listresult.add(t);
                        continue;
                    }
                }
                map.put(SysContent.NAME_STR,s);
                map.put(SysContent.VALUE,listresult);
                result.add(map);
            }
            return result;
        }
        return null;
    }
    @Override
    public void updateByIdsAndVipBaseId(String[] ids, Integer vipBaseId) {
        shopVipConsumerCouponMapper.updateByIdsAndVipBaseId(ids,vipBaseId);
    }

    @Override
    public void updateVipByBaseId(Integer vipBaseId) {
        shopVipConsumerCouponMapper.updateVipByBaseId(vipBaseId);
    }
}