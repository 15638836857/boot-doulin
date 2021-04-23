

package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.entity.TBankInfo;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TBankInfoMapper;
import com.doulin.service.TBankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
* TBankInfoServiceImpl
* @Author malinging
* @Date 2021-04-22
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TBankInfoServiceImpl extends ServiceImpl<TBankInfoMapper, TBankInfo> implements TBankInfoService {
@Autowired
private TBankInfoMapper bankInfoMapper;
    @Override
    public IPage<TBankInfo> page(VQuery query) {
        IPage<TBankInfo> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public List<TBankInfo> getInfoByType(Integer type,String province,String city,String bank) {
        return bankInfoMapper.selectInfoByType(type, province, city, bank);
    }

}