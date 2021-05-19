package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.entity.TUserShopRelation;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TUserShopRelationMapper;
import com.doulin.service.TUserShopRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* TUserShopRelationServiceImpl
* @Author malinging
* @Date 2021-05-17
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TUserShopRelationServiceImpl extends ServiceImpl<TUserShopRelationMapper, TUserShopRelation> implements TUserShopRelationService {

    @Override
    public IPage<TUserShopRelation> page(VQuery query) {
        IPage<TUserShopRelation> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

}