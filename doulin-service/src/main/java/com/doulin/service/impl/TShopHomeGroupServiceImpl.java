package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopHomeGroup;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopHomeGroupMapper;
import com.doulin.service.TShopHomeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * TShopHomeGroupServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
public class TShopHomeGroupServiceImpl extends ServiceImpl<TShopHomeGroupMapper, TShopHomeGroup> implements TShopHomeGroupService {

    @Autowired
    private TShopHomeGroupMapper shopHomeGroupMapper;
    @Override
    public IPage<TShopHomeGroup> page(VQuery query) {
        IPage<TShopHomeGroup> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeBatchByIds(String loginUserId, List<String> ids) {
        shopHomeGroupMapper.deleteInfoBatchIds(loginUserId,ids);
    }

    @Override
    public IPage<TShopHomeGroup> pageInfo(Map<String, Object> map) {
        List<TShopHomeGroup> list=shopHomeGroupMapper.pageInfo(map);
        Integer count=shopHomeGroupMapper.count(map);
        IPage<TShopHomeGroup> page=new Page<>();
        page.setCurrent(Long.valueOf(map.get(SysContent.PAGE).toString()));
        page.setSize(Long.valueOf(map.get(SysContent.ROWS).toString()));
        page.setTotal(Long.valueOf(count.toString()));
        page.setRecords(list);
        return page;
    }

}