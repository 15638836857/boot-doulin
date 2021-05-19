package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.entity.TUserAddress;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TUserAddressMapper;
import com.doulin.service.TUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * TUserAddressServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TUserAddressServiceImpl extends ServiceImpl<TUserAddressMapper, TUserAddress> implements TUserAddressService {
    @Autowired
    private TUserAddressMapper userAddressMapper;

    @Override
    public IPage<TUserAddress> page(VQuery query) {
        IPage<TUserAddress> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public List<TUserAddress> getByOpenId(String openId) {
        return userAddressMapper.selectByOpenId(openId);
    }

}