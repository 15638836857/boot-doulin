package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.entity.TGoods;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TGoodsMapper;
import com.doulin.service.TGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * TGoodsServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements TGoodsService {

    @Override
    public IPage<TGoods> page(VQuery query) {
        IPage<TGoods> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

}