package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TAbout;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TAboutMapper;
import com.doulin.service.TAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
* TAboutServiceImpl
* @Author malinging
* @Date 2021-04-23
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TAboutServiceImpl extends ServiceImpl<TAboutMapper, TAbout> implements TAboutService {

    @Autowired
    private TAboutMapper tAboutMapper;
    @Override
    public IPage<TAbout> page(VQuery query) {
        IPage<TAbout> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public TAbout geAboutById(String id) {
        QueryWrapper<TAbout> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq(SysContent.ID_STR,id);
        queryWrapper.eq(SysContent.STATUS,SysContent.INTGER_0);
        return getOne(queryWrapper);
    }

    @Override
    public IPage<TAbout> pageInfo(Map<String, Object> map) {
        List<TAbout> pageList=getPageList(map);
        Integer total=getTotalCount(map);
        IPage<TAbout> page=new Page<>();
        page.setRecords(pageList);
        page.setTotal(Long.valueOf(total));
        page.setCurrent(Long.valueOf(map.get(SysContent.PAGE).toString()));
        page.setSize(Long.valueOf(map.get(SysContent.ROWS).toString()));
        return page;
    }
    @Override
    public List<TAbout> getPageList(Map<String, Object> map) {
        return tAboutMapper.selectPageList(map);
    }
    @Override
    public Integer getTotalCount(Map<String, Object> map) {
        return tAboutMapper.selectTotalCount(map);
    }

}