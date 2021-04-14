package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.BuildTree;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysDept;
import com.doulin.entity.edo.Tree;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysDeptMapper;
import com.doulin.service.SysDeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * SysDeptServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public IPage<SysDept> page(VQuery query) {
        IPage<SysDept> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public Tree<SysDept> getTree() {

        List<Tree<SysDept>> trees = new ArrayList<Tree<SysDept>>();
        List<SysDept> menuDOs =list(new QueryWrapper<SysDept>()
                .eq(SysContent.DEL_FLAG,SysContent.INTGER_0).orderByAsc("sort_num"));
        for (SysDept sysMenuDO : menuDOs) {
            Tree<SysDept> tree = new Tree<SysDept>();
            tree.setId(sysMenuDO.getId().toString());
            tree.setParentId(sysMenuDO.getParentId().toString());
            tree.setText(sysMenuDO.getName());
            tree.setSort(sysMenuDO.getSortNum());
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<SysDept> t = BuildTree.build(trees);
        return t;
    }

}