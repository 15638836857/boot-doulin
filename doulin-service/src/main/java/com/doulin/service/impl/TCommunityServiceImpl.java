package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.MyException;
import com.doulin.common.StringUtils;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TCommunity;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TCommunityMapper;
import com.doulin.service.TCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
* TCommunityServiceImpl
* @Author malinging
* @Date 2021-04-15
**/
@Service
public class TCommunityServiceImpl extends ServiceImpl<TCommunityMapper, TCommunity> implements TCommunityService {

    @Autowired
    private TCommunityMapper communityMapper;
    @Override
    public IPage<TCommunity> page(VQuery query) {
        IPage<TCommunity> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void addAndUpdateParam(String oper, TCommunity tCommunity) throws MyException {
        if(StrUtil.isEmpty(tCommunity.getCommunityName())){
            throw new MyException(SysContent.ERROR_COMMUNITY_NAME);
        }else if(StrUtil.isEmpty(tCommunity.getCommunityAddress())){
            throw new MyException(SysContent.ERROR_COMMUNITY_ADRESS);
        }else if(StrUtil.isEmpty(tCommunity.getCommunityState())){
            throw new MyException(SysContent.ERROR_COMMUNITY_STATE);
        }else if(null==tCommunity.getProvinceId()){
            throw new MyException(SysContent.ERROR_PROVICE_ID);
        }else if(null==tCommunity.getCityId()){
            throw new MyException(SysContent.ERROR_CITY_ID);
        }else if(null==tCommunity.getDistrictId()){
            throw new MyException(SysContent.ERROR_DISTRICTY_ID);
        }
        if(SysContent.OPER_ADD.equals(oper)){
            tCommunity.setCommunityCode(addCommunityCode());
        }
    }

    @Override
    public String addCommunityCode() {
        String code=communityMapper.selectLastCode();
        if(StrUtil.isEmpty(code)){
            code=SysContent.COMMUNITY_CODE+SysContent.STR_0001;
        }else{
            String numstr=StrUtil.sub(code,code.length()-4,code.length());
            Integer num=Integer.valueOf(numstr)+1;
            code=SysContent.COMMUNITY_CODE+ StringUtils.autoGenericCode(num.toString(),4);
        }
        return code;
    }

    @Override
    public TCommunity getOneById(Integer id) {
        return communityMapper.selectOneById(id);
    }

    @Override
    public IPage<TCommunity> pageInfo(Map<String, Object> map) {
        List<TCommunity> list=communityMapper.pageInfo(map);
        Integer count=communityMapper.count(map);
        IPage<TCommunity> page=new Page<>();
        page.setCurrent(Long.valueOf(map.get(SysContent.PAGE).toString()));
        page.setSize(Long.valueOf(map.get(SysContent.ROWS).toString()));
        page.setTotal(Long.valueOf(count.toString()));
        page.setRecords(list);
        return page;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBatchByIds(String loginUserId,List<String> ids) {
        communityMapper.deleteInfoBatchIds(loginUserId,ids);
    }

}