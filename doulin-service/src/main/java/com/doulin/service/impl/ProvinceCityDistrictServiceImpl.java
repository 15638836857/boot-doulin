package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.BuildTree;
import com.doulin.entity.ProvinceCityDistrict;
import com.doulin.entity.edo.Tree;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.ProvinceCityDistrictMapper;
import com.doulin.service.ProvinceCityDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* ProvinceCityDistrictServiceImpl
* @Author malinging
* @Date 2021-04-15
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class ProvinceCityDistrictServiceImpl extends ServiceImpl<ProvinceCityDistrictMapper, ProvinceCityDistrict> implements ProvinceCityDistrictService {
  @Autowired
  private ProvinceCityDistrictMapper provinceCityDistrictMapper;
    @Override
    public IPage<ProvinceCityDistrict> page(VQuery query) {
        IPage<ProvinceCityDistrict> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public Tree<ProvinceCityDistrict> getTree() {
        List<Tree<ProvinceCityDistrict>> trees = new ArrayList<Tree<ProvinceCityDistrict>>();
        List<ProvinceCityDistrict> menuDOs =list();
        for (ProvinceCityDistrict sysMenuDO : menuDOs) {
            Tree<ProvinceCityDistrict> tree = new Tree<ProvinceCityDistrict>();
            tree.setId(sysMenuDO.getId().toString());
            tree.setParentId(sysMenuDO.getPid().toString());
            tree.setText(sysMenuDO.getName());
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<ProvinceCityDistrict> t = BuildTree.build(trees);
        return t;
    }

}