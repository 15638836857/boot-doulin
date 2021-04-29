package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.*;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TGoodsMapper;
import com.doulin.mapper.TGoodsSkuMapper;
import com.doulin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * TGoodsServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements TGoodsService {

    @Autowired
    private TShopHomeBaseInfoService shopHomeBaseInfoService;
    @Autowired
    private TGoodsMapper goodsMapper;
    @Autowired
    private TGoodsSkuMapper goodsSkuMapper;
    @Autowired
    private SysGoodsSkuService sysGoodsSkuService;
    @Autowired
    private SysGoodsService sysGoodsService;
    @Autowired
    private SysGoodsShopHomeService sysGoodsShopHomeService;

    //    @Autowired
//    private  shopHomeBaseInfoService;
    @Override
    public IPage<TGoods> page(VQuery query) {
        IPage<TGoods> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public TGoods getInfoByName(String goodsName) {
        return goodsMapper.selectByName(goodsName);
    }

    @Override
    public List<TGoods> getGoodsGategory(String loginNo, String cateid) {

        return goodsMapper.selectGoodsByCateId(cateid);

    }

    @Override
    public void addOrUpdate(String oper, TGoods tGoods) throws Exception {
        try {
            if (StrUtil.isEmpty(tGoods.getGoodsName())) {
                throw new Exception(SysContent.ERROR_PARAM);
            }
            if (StrUtil.isEmpty(tGoods.getState())) {
                tGoods.setState(SysContent.Y_STR);
            }
            TGoods goods = getInfoByName(tGoods.getGoodsName());
            if (SysContent.OPER_ADD.equals(oper)) {
                if (null != goods) {
                    throw new Exception(SysContent.ERROR_EXISIS);
                }
                save(tGoods);
            } else if (SysContent.OPER_EDIT.equals(oper)) {
                if (null != goods && tGoods.getId().equals(goods.getId())) {
                    throw new Exception(SysContent.ERROR_EXISIS);
                }
                updateById(tGoods);
            } else {
                throw new Exception(SysContent.ERROR_OPER);
            }
            //判断sku商品是否存在
            List<TGoodsSku> skuList = goodsSkuMapper.selectList(
                    new QueryWrapper<TGoodsSku>()
                            .eq("goodsId", tGoods.getId())
                            .eq(SysContent.DEL_FLAG, SysContent.INTGER_0));
            if (null != skuList) {
                goodsSkuMapper.delete(new QueryWrapper<TGoodsSku>()
                        .eq("goodsId", tGoods.getId())
                        .eq(SysContent.DEL_FLAG, SysContent.INTGER_0));
            }
            skuList = tGoods.getSkuList();
            for (TGoodsSku tGoodsSku : skuList) {
                if (SysContent.OPER_ADD.equals(oper)) {
                    tGoodsSku.setAddBy(tGoods.getAddBy());
                    tGoodsSku.setAddDt(tGoods.getEditDt());
                } else if (SysContent.OPER_EDIT.equals(oper)) {
                    tGoodsSku.setEditBy(tGoods.getEditBy());
                    tGoodsSku.setEditDt(tGoods.getEditDt());
                }
                tGoodsSku.setGoodsId(tGoods.getId());
            }
            //判断商品是否存在 系统逗邻商品  前端是否传过来id
            //如果移动端没有传值  系统认为 系统商品没有就添加
            SysGoods sysGoods = new SysGoods();
            //系统商品
            Integer id = tGoods.getSysGoodsId();
            if (null == id) {
                sysGoods.setDelFlag(SysContent.INTGER_0);
                sysGoods.setAddDt(new Date());
                sysGoods.setAddBy(tGoods.getAddBy());
                sysGoods.setGoodsName(tGoods.getGoodsName());
                sysGoods.setGoodsImg(tGoods.getImageTitle());
                sysGoodsService.save(sysGoods);
                //系统商品id
                id = sysGoods.getId();
                List<SysGoodsSku> sysSkulist = new ArrayList<SysGoodsSku>();
                for (TGoodsSku tGoodsSku : skuList) {
                    SysGoodsSku skul = new SysGoodsSku();
                    skul.setSysGoodsId(id);
                    skul.setAddDt(new Date());
                    skul.setAddBy(tGoods.getAddBy());
                    skul.setPrices(tGoodsSku.getPrice());
                    skul.setDelFlag(SysContent.INTGER_0);
                    skul.setSku(tGoodsSku.getSku());
                    sysSkulist.add(skul);
                }
                //添加系统sku商品
                sysGoodsSkuService.saveBatch(sysSkulist);
                //商家关联商品 逗邻系统商品
                String shopHomeCode = tGoods.getShopHomeCode();
                SysGoodsShopHome sysGoodsShopHome = new SysGoodsShopHome();
                sysGoodsShopHome.setAddBy(tGoods.getAddBy());
                sysGoodsShopHome.setAddDt(tGoods.getAddDt());
                sysGoodsShopHome.setDelFlag(SysContent.INTGER_0);
                sysGoodsShopHome.setShopHomeCode(shopHomeCode);
                sysGoodsShopHome.setSysGoodsId(id);
                sysGoodsShopHomeService.save(sysGoodsShopHome);
            } else {
                String shopHomeCode = tGoods.getShopHomeCode();
                SysGoodsShopHome sysGoodsShopHome = sysGoodsShopHomeService.getInfoByShopHomeCodeAndSysGoodsId(shopHomeCode, id);
                if (null == sysGoodsShopHome) {
                    //商家关联商品 逗邻系统商品
                    sysGoodsShopHome = new SysGoodsShopHome();
                    sysGoodsShopHome.setAddBy(tGoods.getAddBy());
                    sysGoodsShopHome.setAddDt(tGoods.getAddDt());
                    sysGoodsShopHome.setDelFlag(SysContent.INTGER_0);
                    sysGoodsShopHome.setShopHomeCode(shopHomeCode);
                    sysGoodsShopHome.setSysGoodsId(id);
                    sysGoodsShopHomeService.save(sysGoodsShopHome);
                } else {
                    sysGoodsSkuService.remove(new QueryWrapper<SysGoodsSku>().eq("sys_goods_id", id));
                    List<SysGoodsSku> sysSkulist = new ArrayList<SysGoodsSku>();
                    for (TGoodsSku tGoodsSku : skuList) {
                        SysGoodsSku skul = new SysGoodsSku();
                        skul.setSysGoodsId(id);
                        skul.setEditDt(new Date());
                        skul.setEditBy(tGoods.getAddBy());
                        skul.setPrices(tGoodsSku.getPrice());
                        skul.setDelFlag(SysContent.INTGER_0);
                        skul.setSku(tGoodsSku.getSku());
                        sysSkulist.add(skul);
                    }
                    //添加系统sku商品
                    sysGoodsSkuService.saveBatch(sysSkulist);
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}