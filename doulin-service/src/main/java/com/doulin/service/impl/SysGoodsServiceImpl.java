package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysGoods;
import com.doulin.entity.SysGoodsSku;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysGoodsMapper;
import com.doulin.service.SysGoodsService;
import com.doulin.service.SysGoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
* SysGoodsServiceImpl
* @Author malinging
* @Date 2021-04-27
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysGoodsServiceImpl extends ServiceImpl<SysGoodsMapper, SysGoods> implements SysGoodsService {
    @Autowired
    private SysGoodsMapper sysGoodsMapper;
    @Autowired
    private SysGoodsSkuService sysGoodsSkuService;

    @Override
    public IPage<SysGoods> page(VQuery query) {
        IPage<SysGoods> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public IPage<SysGoods> getPageInfo(Map<String, Object> map) {
        List<SysGoods> pageList = pageList(map);
        Integer total = pageCount(map);
        IPage<SysGoods> page = new Page<>();
        page.setCurrent(Long.valueOf(map.get(SysContent.PAGE).toString()));
        page.setTotal(Long.valueOf(total));
        page.setRecords(pageList);
        page.setSize(Long.valueOf(map.get(SysContent.ROWS).toString()));
        return page;
    }

    @Override
    public List<SysGoods> pageList(Map<String, Object> map) {
        return sysGoodsMapper.pageList(map);
    }

    @Override
    public Integer pageCount(Map<String, Object> map) {
        return sysGoodsMapper.pageCount(map);
    }

    @Override
    public void saveAndUpdate(String operAdd, SysGoods sysGoods) throws Exception {
        try {
            String name = sysGoods.getGoodsName();
            if (StrUtil.isEmpty(name)) {
                throw new Exception(SysContent.ERROR_PARAM);
            }
            QueryWrapper<SysGoods> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("goods_name", name);
            queryWrapper.eq(SysContent.DEL_FLAG, SysContent.INTGER_0);
            SysGoods sg = getOne(queryWrapper);
            if (SysContent.OPER_ADD.equals(operAdd)) {
                if (null != sg) {
                    throw new Exception(SysContent.ERROR_EXISIS);
                }
                save(sysGoods);
            } else if (SysContent.OPER_EDIT.equals(operAdd)) {
                if (null == sysGoods.getId()) {
                    throw new Exception(SysContent.ERROR_ID);
                }
                if (null != sg && !sysGoods.getId().equals(sg.getId())) {
                    throw new Exception(SysContent.ERROR_EXISIS);
                }
                updateById(sysGoods);
            }
            List<SysGoodsSku> list = sysGoods.getSkuList();
            if (null != list) {
                for (SysGoodsSku sysGoodsSku : list) {
                    sysGoodsSku.setDelFlag(SysContent.INTGER_0);
                    if (SysContent.OPER_ADD.equals(operAdd)) {
                        sysGoodsSku.setAddBy(sysGoods.getAddBy());
                        sysGoodsSku.setAddDt(sysGoods.getAddDt());
                    } else {
                        sysGoodsSku.setEditBy(sysGoods.getEditBy());
                        sysGoodsSku.setEditDt(sysGoods.getEditDt());
                    }
                    sysGoodsSku.setSysGoodsId(sysGoods.getId());
                }
                sysGoodsSkuService.remove(new QueryWrapper<SysGoodsSku>().eq("sys_goods_id", sysGoods.getId()));
                sysGoodsSkuService.saveBatch(list);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        //删除sku
        sysGoodsSkuService.remove(new QueryWrapper<SysGoodsSku>().eq("sys_goods_id", id));
        SysGoods sg = getById(id);
        sg.setDelFlag(SysContent.INTGER_1);
        updateById(sg);
    }

    @Override
    public List<Map<String, Object>> getListByName(String goodsName) {
        List<Map<String, Object>> map = sysGoodsMapper.getListByName(goodsName);
        List<Map<String,Object>> namelist=new ArrayList<>();
        for (Map<String, Object> strMap : map) {
            Map<String, Object> nameMap=new LinkedHashMap<>();
            String[] skuList=strMap.get("sku").toString().split(SysContent.EN_D);
            nameMap.put("id",strMap.get(SysContent.ID_STR));
            nameMap.put("goodsName",strMap.get("goodsName"));
            //商品简介
            nameMap.put("goodsTitle","");
            nameMap.put("goodsImg",strMap.get("goodsImg"));
            List skuP=new ArrayList();
            for (String s : skuList) {
                Map<String,Object> skuc=new HashMap<>();
                String[] sku=s.split("-");
                String prices = sku[1];
                String skuName=sku[0];
                skuc.put("sku", skuName);
                skuc.put("price", prices);
                skuc.put("cuPrice", prices);
                skuc.put("stock", 0);
                skuP.add(skuc);
            }
            nameMap.put("skuList", skuP);
            namelist.add(nameMap);
        }

        return namelist;
    }

}