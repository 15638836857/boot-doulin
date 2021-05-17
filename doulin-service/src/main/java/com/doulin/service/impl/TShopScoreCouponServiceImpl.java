package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopScoreCoupon;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopScoreCouponMapper;
import com.doulin.service.TShopScoreCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
* TShopScoreCouponServiceImpl
* @Author malinging
* @Date 2021-05-13
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopScoreCouponServiceImpl extends ServiceImpl<TShopScoreCouponMapper, TShopScoreCoupon> implements TShopScoreCouponService {

    @Autowired
    private TShopScoreCouponMapper tShopScoreCouponMapper;
    @Override
    public IPage<TShopScoreCoupon> page(VQuery query) {
        IPage<TShopScoreCoupon> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void saveAndUpdate(String oper, TShopScoreCoupon tShopScoreCoupon) throws Exception {
        if(!SysContent.OPER_DELETE.equals(oper)) {
            if (StrUtil.isEmpty(tShopScoreCoupon.getName())) {
                throw new Exception(SysContent.ERROR_PARAM);
            } else if (StrUtil.isEmpty(tShopScoreCoupon.getValidFlag())) {
                throw new Exception(SysContent.ERROR_PARAM);
            } else if (StrUtil.isEmpty(tShopScoreCoupon.getShopHomeCode())) {
                throw new Exception(SysContent.ERROR_PARAM);
            } else if (null == tShopScoreCoupon.getCouponAmount()) {
                throw new Exception("优惠券金额不能为空");
            } else if (null == tShopScoreCoupon.getToScore()) {
                throw new Exception("兑换积分不能为空");
            } else if (null == tShopScoreCoupon.getDemandScore()) {
                throw new Exception(SysContent.ERROR_PARAM);
            }
        }

        if(SysContent.OPER_ADD.equals(oper)){
            tShopScoreCoupon.setDelFlag(SysContent.INTGER_0);
            tShopScoreCoupon.setAddDt(new Date());
            save(tShopScoreCoupon);
        }else if(SysContent.OPER_EDIT.equals(oper)){
            if(null==tShopScoreCoupon.getId()){
                throw new Exception(SysContent.ERROR_PARAM);
            }
            tShopScoreCoupon.setEditDt(new Date());
            updateById(tShopScoreCoupon);
        }else if(SysContent.OPER_DELETE.equals(oper)){
            tShopScoreCoupon.setDelFlag(SysContent.INTGER_1);
            tShopScoreCoupon.setEditDt(new Date());
            updateById(tShopScoreCoupon);
        }
    }

}