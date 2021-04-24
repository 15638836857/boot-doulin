package com.doulin.service.impl;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.MyException;
import com.doulin.common.StringUtils;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysSalesman;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysSalesmanMapper;
import com.doulin.service.SysSalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * SysSalesmanServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysSalesmanServiceImpl extends ServiceImpl<SysSalesmanMapper, SysSalesman> implements SysSalesmanService {

    @Autowired
    private SysSalesmanMapper sysSalesmanMapper;

    @Override
    public IPage<SysSalesman> page(VQuery query) {
        IPage<SysSalesman> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public String getYwyCodeNum(String phone) {
        String code=sysSalesmanMapper.selectYwyCodeNum();
        Integer num=0;
       if(StrUtil.isEmpty(code)){
           code="01";
           num= Integer.valueOf(code);
       }else{
           code=StrUtil.sub(code,code.length()-2,code.length());
           num=Integer.valueOf(code)+ SysContent.INTGER_1;
       }
       String phonestr=StrUtil.sub(phone,phone.length()-4,phone.length());
       StringBuilder stringBuilder=new StringBuilder();
       stringBuilder.append(SysContent.DLKJLYD);
       stringBuilder.append(phonestr);
       stringBuilder.append(StringUtils.autoGenericCode(num.toString(),2));
        return stringBuilder.toString();
    }

    @Override
    public void addAndUpdateParam(String oper,SysSalesman sysSalesman) throws MyException {
        if(StrUtil.isEmpty(sysSalesman.getPhone()) || !PhoneUtil.isMobile(sysSalesman.getPhone())) {
            throw new MyException(SysContent.ERROR_MOBILE);
        }
        if(SysContent.OPER_ADD.equals(oper)){
           if(null!=getOneByPhone(sysSalesman.getPhone())){
               throw new MyException(SysContent.ERROR_EXISIS);
           }
        }else if(SysContent.OPER_EDIT.equals(oper)){
            SysSalesman salesman=getOneByPhone(sysSalesman.getPhone());
            if(null!=salesman&& !sysSalesman.getId().equals(salesman.getId())){
                throw new MyException(SysContent.ERROR_EXISIS);
            }
        }

    }

    @Override
    public SysSalesman getOneByPhone(String phone) {

        return sysSalesmanMapper.selectOneByPhone(phone);
    }

    @Override
    public SysSalesman getOneByCode(String code) {
        QueryWrapper<SysSalesman> queryWrapper=new QueryWrapper<>();
        //无禁用
        queryWrapper.eq(SysContent.STATUS,SysContent.N_STR);
        queryWrapper.eq(SysContent.DEL_FLAG,SysContent.INTGER_0);
        queryWrapper.eq(SysContent.CODE_STR,code);
        return getOne(queryWrapper);
    }

    @Override
    public void deleteByIds(String loginUserId,List<String> ids) {
        sysSalesmanMapper.deleteByIds(loginUserId,ids);
    }

    @Override
    public IPage<SysSalesman> pageInfo(Map<String, Object> map) {
        List<SysSalesman> list=sysSalesmanMapper.pageInfo(map);
        Integer count=sysSalesmanMapper.count(map);
        IPage<SysSalesman> page=new Page<>();
        page.setCurrent(Long.valueOf(map.get(SysContent.PAGE).toString()));
        page.setSize(Long.valueOf(map.get(SysContent.ROWS).toString()));
        page.setTotal(Long.valueOf(count.toString()));
        page.setRecords(list);
        return page;
    }


}