package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysGoodsShopHome;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysGoodsShopHomeMapper;
import com.doulin.service.SysGoodsShopHomeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* SysGoodsShopHomeServiceImpl
* @Author malinging
* @Date 2021-04-27
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysGoodsShopHomeServiceImpl extends ServiceImpl<SysGoodsShopHomeMapper, SysGoodsShopHome> implements SysGoodsShopHomeService {

    @Override
    public IPage<SysGoodsShopHome> page(VQuery query) {
        IPage<SysGoodsShopHome> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public SysGoodsShopHome getInfoByShopHomeCodeAndSysGoodsId(String shopHomeCode, Integer sysGoodsId) {
        QueryWrapper<SysGoodsShopHome> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("shop_home_code",shopHomeCode);
        queryWrapper.eq("sys_goods_id",sysGoodsId);
        queryWrapper.eq(SysContent.DEL_FLAG,SysContent.INTGER_0);
        return getOne(queryWrapper);
    }

}