package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopVipBase;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopVipBaseMapper;
import com.doulin.service.TShopVipBaseService;
import com.doulin.service.TShopVipConsumerCouponService;
import com.doulin.service.TShopVipRechargeService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
* TShopVipBaseServiceImpl
* @Author malinging
* @Date 2021-05-07
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopVipBaseServiceImpl extends ServiceImpl<TShopVipBaseMapper, TShopVipBase> implements TShopVipBaseService {
    @Autowired
    private TShopVipBaseMapper tShopVipBaseMapper;
    @Autowired
    private TShopVipRechargeService shopVipRechargeService;
    @Autowired
    private TShopVipConsumerCouponService shopVipConsumerCouponService;
    @Override
    public IPage<TShopVipBase> page(VQuery query) {
        IPage<TShopVipBase> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public TShopVipBase getInfoByLoginNo(String loginNo) {
        return tShopVipBaseMapper.selectInfoByLoginNo(loginNo);
    }

    @Override
    public void addVipInfo(String oper,TShopVipBase tShopVipBase) throws Exception {
        if (SysContent.OPER_ADD.equals(oper)) {
            TShopVipBase ts=getInfoByLoginNo(tShopVipBase.getAddBy());
            if(null!=ts){
                throw new Exception(SysContent.ERROR_EXISIS);
            }
            save(tShopVipBase);
        } else if (SysContent.OPER_EDIT.equals(oper)) {
            TShopVipBase ts=getInfoByLoginNo(tShopVipBase.getEditBy());
            if(null!=ts && tShopVipBase.getId()!=ts.getId()){
                throw new Exception(SysContent.ERROR_EXISIS);
            }
            if (null == tShopVipBase.getId()) {
                throw new Exception(SysContent.ERROR_ID);
            }
            updateById(tShopVipBase);
        } else if(SysContent.OPER_OPEN.equals(oper)){
            if (null == tShopVipBase.getId()) {
                throw new Exception(SysContent.ERROR_ID);
            }
            updateById(tShopVipBase);
            return;
        }else {
            throw new Exception(SysContent.ERROR_OPER);
        }
        Integer id = tShopVipBase.getId();

        //绑定权益 充值列表ids 逗号间隔
        String vipRechargeIds = tShopVipBase.getVipRechargeIds();
        if (!StrUtil.isEmpty(vipRechargeIds)) {
            shopVipRechargeService.updateByIdsAndVipBaseId(vipRechargeIds.split(SysContent.EN_D), id);
        }
        //绑定权益 会员消费券列表ids
        String vipConsumerCouponIds = tShopVipBase.getVipConsumerCouponIds();
        if (!StrUtil.isEmpty(vipConsumerCouponIds)) {
            shopVipConsumerCouponService.updateVipByBaseId(id);
            shopVipConsumerCouponService.updateByIdsAndVipBaseId(vipConsumerCouponIds.split(SysContent.EN_D),id);
        }
    }

    @Override
    public List<Map<String, Object>> getActivity(String loginNo,String isOpen) {
        Map<String, Object> map = tShopVipBaseMapper.selectActivity(loginNo);
        if (null != map) {
            List<Map<String, Object>> listmap = new ArrayList<>();
            for (Map.Entry<String, Object> e : map.entrySet()) {
                Map<String, Object> mapResult = Maps.newHashMap();
                String value=StrUtil.isBlankIfStr(e.getValue())?SysContent.N_STR:e.getValue().toString();
                if (StrUtil.isEmpty(isOpen)) {
                    mapResult.put(SysContent.NAME_STR, e.getKey());
                    mapResult.put(SysContent.VALUE, value);
                    listmap.add(mapResult);
                } else if (value.equals(isOpen)) {
                    mapResult.put(SysContent.NAME_STR, e.getKey());
                    mapResult.put(SysContent.VALUE, e.getValue());
                    listmap.add(mapResult);
                }
            }
            return listmap;
        }
        return null;
    }

}