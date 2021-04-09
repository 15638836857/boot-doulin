package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.entity.TShopHomeBaseInfo;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopHomeBaseInfoMapper;
import com.doulin.service.TShopHomeBaseInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * TShopHomeBaseInfoServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopHomeBaseInfoServiceImpl extends ServiceImpl<TShopHomeBaseInfoMapper, TShopHomeBaseInfo> implements TShopHomeBaseInfoService {

    @Override
    public IPage<TShopHomeBaseInfo> page(VQuery query) {
        IPage<TShopHomeBaseInfo> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

}