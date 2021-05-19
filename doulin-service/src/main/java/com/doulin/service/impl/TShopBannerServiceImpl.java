package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopBanner;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopBannerMapper;
import com.doulin.service.TShopBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
* TShopBannerServiceImpl
* @Author malinging
* @Date 2021-05-18
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopBannerServiceImpl extends ServiceImpl<TShopBannerMapper, TShopBanner> implements TShopBannerService {

    @Autowired
    private TShopBannerMapper tShopBannerMapper;
    @Override
    public IPage<TShopBanner> page(VQuery query) {
        IPage<TShopBanner> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public IPage<TShopBanner> getPageInfo(Map<String, Object> map) {
        IPage<TShopBanner> page=new Page<>();
        List<TShopBanner> list=getListPage(map);
        Integer total=getPageCount(map);
        page.setRecords(list);
        page.setTotal(Long.valueOf(total));
        page.setCurrent(Long.valueOf(map.get(SysContent.PAGE).toString()));
        page.setSize(Long.valueOf(map.get(SysContent.ROWS).toString()));
        return page;
    }

    @Override
    public List<TShopBanner> getListPage(Map<String, Object> map) {
        return tShopBannerMapper.selectPageList(map);
    }

    @Override
    public Integer getPageCount(Map<String, Object> map) {
        return tShopBannerMapper.selectPageCount(map);
    }

    @Override
    public List<TShopBanner> getInfoByCommunityCode(String communityCode) {
        return tShopBannerMapper.selectInfoByCommunityCode(communityCode);
    }

}