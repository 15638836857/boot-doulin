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
    private TGoodsSkuService skuService;
    @Autowired
    private SysGoodsSkuService sysGoodsSkuService;
    @Autowired
    private SysGoodsService sysGoodsService;
    @Autowired
    private SysGoodsShopHomeService sysGoodsShopHomeService;
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
    public TGoods getInfoByName(String shopHomeCode,String goodsName) {
        return goodsMapper.selectByName(shopHomeCode,goodsName);
    }

    @Override
    public List<TGoods> getGoodsGategory(String loginNo, String cateid,String goodsLowerFrame) {

        return goodsMapper.selectGoodsByCateId(loginNo,cateid,goodsLowerFrame);

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
            TGoods goods = getInfoByName(tGoods.getShopHomeCode(),tGoods.getGoodsName());
            if (SysContent.OPER_ADD.equals(oper)) {
                if (null != goods) {
                    throw new Exception(SysContent.ERROR_EXISIS);
                }
                save(tGoods);
            } else if (SysContent.OPER_EDIT.equals(oper)) {
                if (null != goods && !tGoods.getId().equals(goods.getId())) {
                    throw new Exception(SysContent.ERROR_EXISIS);
                }
                updateById(tGoods);
            } else {
                throw new Exception(SysContent.ERROR_OPER);
            }
            //??????sku??????????????????
            List<TGoodsSku> skuList = goodsSkuMapper.selectList(
                    new QueryWrapper<TGoodsSku>()
                            .eq("goods_id", tGoods.getId())
                            .eq(SysContent.DEL_FLAG, SysContent.INTGER_0));
            if (null != skuList && !skuList.isEmpty()) {
                goodsSkuMapper.delete(new QueryWrapper<TGoodsSku>()
                        .eq("goods_id", tGoods.getId())
                        .eq(SysContent.DEL_FLAG, SysContent.INTGER_0));
            }
            skuList = tGoods.getSkuList();
            for (TGoodsSku tGoodsSku : skuList) {
                tGoodsSku.setDelFlag(SysContent.INTGER_0);
                if (SysContent.OPER_ADD.equals(oper)) {
                    tGoodsSku.setAddBy(tGoods.getAddBy());
                    tGoodsSku.setAddDt(tGoods.getEditDt());
                } else if (SysContent.OPER_EDIT.equals(oper)) {
                    tGoodsSku.setEditBy(tGoods.getEditBy());
                    tGoodsSku.setEditDt(tGoods.getEditDt());
                }
                tGoodsSku.setGoodsId(tGoods.getId());
            }
            //??????????????????
            skuService.saveBatch(skuList);

            //???????????????????????? ??????????????????  ?????????????????????id
            //???????????????????????????  ???????????? ???????????????????????????
            SysGoods sysGoods = new SysGoods();
            //????????????
            Integer id = tGoods.getSysGoodsId();
            if (null == id) {
                sysGoods.setDelFlag(SysContent.INTGER_0);
                sysGoods.setAddDt(new Date());
                sysGoods.setAddBy(tGoods.getAddBy());
                sysGoods.setGoodsName(tGoods.getGoodsName());
                sysGoods.setGoodsImg(tGoods.getImageTitle());
                sysGoodsService.save(sysGoods);
                //????????????id
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
                //????????????sku??????
                sysGoodsSkuService.saveBatch(sysSkulist);
                //?????????????????? ??????????????????
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
                    //?????????????????? ??????????????????
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
                    //????????????sku??????
                    sysGoodsSkuService.saveBatch(sysSkulist);
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<TGoods> getGoodsByValue(String loginNo,String goodsLowerFrame,Integer categoryId,String value) {
        return goodsMapper.selectGoodsByValue(loginNo,goodsLowerFrame,categoryId,value);
    }

}