package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.SysDept;
import com.doulin.entity.edo.Tree;
import com.doulin.entity.vo.VQuery;

/**
 * SysDeptService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysDeptService extends IService<SysDept> {

    IPage<SysDept> page(VQuery query);

    Tree<SysDept> getTree();
}
