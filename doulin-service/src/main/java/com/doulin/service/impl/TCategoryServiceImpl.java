package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TCategory;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TCategoryMapper;
import com.doulin.service.TCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * TCategoryServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TCategoryServiceImpl extends ServiceImpl<TCategoryMapper, TCategory> implements TCategoryService {

    @Autowired
    private TCategoryMapper tCategoryMapper;
    @Override
    public IPage<TCategory> page(VQuery query) {
        IPage<TCategory> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public List<TCategory> getByShopGroupId(Integer shopGroupId) {
        QueryWrapper<TCategory> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("shop_group_id",shopGroupId);
        queryWrapper.eq(SysContent.DEL_FLAG,SysContent.INTGER_0);
        return list(queryWrapper);
    }

    @Override
    public TCategory getOneByNameOrId(Integer id,String name) {
//        QueryWrapper<TCategory> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("name",name);
//        queryWrapper.eq(SysContent.DEL_FLAG,SysContent.INTGER_0);
//        return getOne(queryWrapper);
        return tCategoryMapper.selectOneByIdOrName(id,name);
    }

    @Override
    public IPage<TCategory> pageInfo(Map<String, Object> map) {
        IPage<TCategory> page=new Page<>();
        List<TCategory> list=getPageList(map);
        Integer total=getPageTotal(map);
        page.setRecords(list);
        page.setTotal(Long.valueOf(total));
        page.setCurrent(Long.valueOf(map.get(SysContent.PAGE).toString()));
        page.setSize(Long.valueOf(map.get(SysContent.ROWS).toString()));
        return page;
    }
    @Override
    public List<TCategory> getPageList(Map<String, Object> map) {
        return tCategoryMapper.selectPageList(map);
    }

    @Override
    public Integer getPageTotal(Map<String, Object> map) {
        return tCategoryMapper.selectTotal(map);
    }

    @Transactional
    @Override
    public void deleteById(Integer id, String loginUserId) {
        tCategoryMapper.deleteByIdAndLoginId(id,loginUserId);
    }

}