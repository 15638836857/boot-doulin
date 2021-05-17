package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopScoreCoupon;
import com.doulin.entity.TShopScoreSetting;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopScoreCouponMapper;
import com.doulin.mapper.TShopScoreSettingMapper;
import com.doulin.service.TShopScoreCouponService;
import com.doulin.service.TShopScoreSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
* TShopScoreSettingServiceImpl
* @Author malinging
* @Date 2021-05-13
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopScoreSettingServiceImpl extends ServiceImpl<TShopScoreSettingMapper, TShopScoreSetting> implements TShopScoreSettingService {

    @Autowired
    private TShopScoreSettingMapper tShopScoreSettingMapper;
    @Autowired
    private TShopScoreCouponMapper shopScoreCouponMapper;
    @Autowired
    private TShopScoreCouponService shopScoreCouponService;
    @Override
    public IPage<TShopScoreSetting> page(VQuery query) {
        IPage<TShopScoreSetting> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void saveAndUpdate(String oper, TShopScoreSetting tShopScoreCoupon) throws Exception {
        if (StrUtil.isEmpty(tShopScoreCoupon.getOpenFlag())) {
            throw new Exception(SysContent.ERROR_PARAM);
        } else if (StrUtil.isEmpty(tShopScoreCoupon.getShopHomeCode())) {
            throw new Exception(SysContent.ERROR_PARAM);
        }
        if (SysContent.OPER_ADD.equals(oper)) {
            tShopScoreCoupon.setAddDt(new Date());
            save(tShopScoreCoupon);
        } else if (SysContent.OPER_EDIT.equals(oper)) {
            TShopScoreSetting tssc=getByShopHomeCode(tShopScoreCoupon.getShopHomeCode());
            tssc.setMoneyToOneScore(tShopScoreCoupon.getMoneyToOneScore());
            tssc.setOpenFlag(tShopScoreCoupon.getOpenFlag());
            tssc.setName(tShopScoreCoupon.getName());
            tssc.setShopHomeCode(tShopScoreCoupon.getShopHomeCode());
            tssc.setEditDt(new Date());
            updateById(tssc);
            String shopHomeCode = tShopScoreCoupon.getShopHomeCode();
            //判断是否又设置有效 兑换券的ids
            if (!StrUtil.isEmpty(tShopScoreCoupon.getIds())) {
                //根据商家 没有删除的兑换券的信息
                List<TShopScoreCoupon> list = shopScoreCouponMapper.selectByShopHomeCode(shopHomeCode);
                if (null != list && !list.isEmpty()) {
                    String[] ids = tShopScoreCoupon.getIds().split(SysContent.EN_D);
                    Date UpdateDate = new Date();
                    List<String> listids = Arrays.asList(ids);
                    for (TShopScoreCoupon sc : list) {
                        //判断商家兑换券里有没有传如的id  设置为有效状态  没有设置无效状态
                        if (listids.contains(sc.getId().toString())) {
                            sc.setValidFlag(SysContent.Y_STR);
                        } else {
                            sc.setValidFlag(SysContent.N_STR);
                        }
                        sc.setEditDt(UpdateDate);
                    }
                    shopScoreCouponService.updateBatchById(list);
                }
            }

        }
    }
    @Override
    public TShopScoreSetting getByShopHomeCode(String shopHomeCode) {
        TShopScoreSetting shopScoreSetting = tShopScoreSettingMapper.selectByShopHomeCode(shopHomeCode);
        return shopScoreSetting;
    }

    @Override
    public TShopScoreSetting getByShopLoginNo(String loginNo) {
        return tShopScoreSettingMapper.selectByShopLoginNo(loginNo);
    }

}