package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TCommunnityToken;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TCommunnityTokenMapper;
import com.doulin.service.TCommunnityTokenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
* TCommunnityTokenServiceImpl
* @Author malinging
* @Date 2021-04-19
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TCommunnityTokenServiceImpl extends ServiceImpl<TCommunnityTokenMapper, TCommunnityToken> implements TCommunnityTokenService {

    @Override
    public IPage<TCommunnityToken> page(VQuery query) {
        IPage<TCommunnityToken> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public List<TCommunnityToken> getByToken(String token) {
        QueryWrapper<TCommunnityToken> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(SysContent.TOKEN_STR,token);

        return list(queryWrapper);
    }

}