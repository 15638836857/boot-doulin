package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.entity.SysGoodsSku;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysGoodsSkuMapper;
import com.doulin.service.SysGoodsSkuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* SysGoodsSkuServiceImpl
* @Author malinging
* @Date 2021-04-27
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysGoodsSkuServiceImpl extends ServiceImpl<SysGoodsSkuMapper, SysGoodsSku> implements SysGoodsSkuService {

    @Override
    public IPage<SysGoodsSku> page(VQuery query) {
        IPage<SysGoodsSku> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

}