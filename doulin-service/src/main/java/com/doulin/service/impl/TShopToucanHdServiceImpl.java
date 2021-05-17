package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopToucanHd;
import com.doulin.entity.TShopToucanHdGoods;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopToucanHdMapper;
import com.doulin.service.TShopToucanHdGoodsService;
import com.doulin.service.TShopToucanHdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
* TShopToucanHdServiceImpl
* @Author malinging
* @Date 2021-05-14
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopToucanHdServiceImpl extends ServiceImpl<TShopToucanHdMapper, TShopToucanHd> implements TShopToucanHdService {

    @Autowired
    private TShopToucanHdMapper shopToucanHdMapper;
    @Autowired
    private TShopToucanHdGoodsService shopToucanHdGoodsService;
    @Override
    public IPage<TShopToucanHd> page(VQuery query) {
        IPage<TShopToucanHd> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public TShopToucanHd getByShopHomeCodeAndOrderType(String shopHomeCode, String orderType) {
        TShopToucanHd tShopToucanHd = shopToucanHdMapper.selectByShopHomeCodeAndOrderType(shopHomeCode, orderType);
        if (null != tShopToucanHd) {
            List<TShopToucanHdGoods> list = shopToucanHdGoodsService.getInfoByShopHomeCode(shopHomeCode, orderType);
            if (null != list && !list.isEmpty()) {
            } else {
                list = new ArrayList<TShopToucanHdGoods>();
            }
            tShopToucanHd.setTaoCanList(list);
        }else{
            tShopToucanHd=new TShopToucanHd();
            tShopToucanHd.setAddDt(new Date());
            tShopToucanHd.setOpenFlag(SysContent.N_STR);
            tShopToucanHd.setOrderType(orderType);
            tShopToucanHd.setShopHomeCode(shopHomeCode);
            save(tShopToucanHd);
        }
        return tShopToucanHd;
    }

}