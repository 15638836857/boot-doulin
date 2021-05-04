package com.doulin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.entity.TShopGoodsCategory;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopGoodsCategoryMapper;
import com.doulin.service.TShopGoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
* TShopGoodsCategoryServiceImpl
* @Author malinging
* @Date 2021-04-30
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopGoodsCategoryServiceImpl extends ServiceImpl<TShopGoodsCategoryMapper, TShopGoodsCategory> implements TShopGoodsCategoryService {

    @Autowired
    private  TShopGoodsCategoryMapper tShopGoodsCategoryMapper;
    @Override
    public IPage<TShopGoodsCategory> page(VQuery query) {
        IPage<TShopGoodsCategory> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public TShopGoodsCategory getOneByNameAndHomeCode(String shopHomeCode, String name) {
        return tShopGoodsCategoryMapper.selectOneByNameAndHomeCode(shopHomeCode,name);
    }

    @Override
    public void deleteById(Integer id, String loginUserId) {
        tShopGoodsCategoryMapper.deleteByIdAndLoginId(id,loginUserId);
    }

    @Override
    public List<TShopGoodsCategory> getListByLoginNo(String loginNo) {
        return tShopGoodsCategoryMapper.selectInfoByLoginNo(loginNo);
    }
    /**
     * 商家入驻成功后 系统默认添加一笔 商品分类
     * @param shopHomeCode 商家编号
     * @param shopGroupId 商家分类id
     */
    @Override
    public void insertDefaultCatagory(String shopHomeCode, Integer shopGroupId) {
        tShopGoodsCategoryMapper.insertDefaultCatagory(shopHomeCode,shopGroupId);
    }


}