package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.MyException;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysDictValue;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysDictValueMapper;
import com.doulin.service.SysDictValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * SysDictValueServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
public class SysDictValueServiceImpl extends ServiceImpl<SysDictValueMapper, SysDictValue> implements SysDictValueService {

    @Autowired
    private SysDictValueMapper sysDictValueMapper;

    @Override
    public IPage<SysDictValue> page(VQuery query) {
        IPage<SysDictValue> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public List<SysDictValue> getByTypeCods(List<String> typeCodes) {

        List<SysDictValue>  list=sysDictValueMapper.selectByTypeCodes(typeCodes);
        return list;
    }

    @Override
    public void addAndUpateParamFlag(String oper,SysDictValue sysDictValue) throws MyException {
        //判断是否符合条件
        if(StrUtil.isEmpty(sysDictValue.getTypeCode())){
            throw new MyException(SysContent.ERROR_DICT_TYPE_CODE);
        }else if(StrUtil.isEmpty(sysDictValue.getLabel())){
            throw new MyException(SysContent.ERROR_DICT_TYPE_VALUE_NAME);
        }else if(StrUtil.isEmpty(sysDictValue.getValue())){
            throw new MyException(SysContent.ERROR_DICT_TYPE_VALUE);
        }else if(null==sysDictValue.getSort()) {
            throw new MyException(SysContent.ERROR_DICT_SORT);
        }

         if(SysContent.OPER_ADD.equals(oper)){
             List<SysDictValue> list= sysDictValueMapper.selectListByTypeCodeOrValue(sysDictValue.getTypeCode(),sysDictValue.getValue());
             if(null!=list && list.size()>0){
                 throw new MyException(SysContent.ERROR_EMPTY_DICT_VALUE);
             }
         }else if(SysContent.OPER_EDIT.equals(oper)){
             if(null==sysDictValue.getId()){
                 throw new MyException(SysContent.ERROR_ID);
             }
         }else if(SysContent.OPER_DELETE.equals(oper)){
             if(null==sysDictValue.getId()){
                 throw new MyException(SysContent.ERROR_ID);
             }

         }else{
             throw new MyException(SysContent.ERROR_OPER);
         }

    }

    @Override
    public List<SysDictValue> getListByTypeCodeOrValue(String typeCode, String value) {
        List<SysDictValue> list=sysDictValueMapper.selectListByTypeCodeOrValue(typeCode,value);
        return list;
    }
    @Override
    @Transactional(rollbackFor = MyException.class)
    public boolean addAndUpdate(String oper, SysDictValue sysDictValue) throws MyException {
        addAndUpateParamFlag(oper, sysDictValue);
        boolean flag = false;
        if (SysContent.OPER_ADD.equals(oper)) {
            save(sysDictValue);
            flag = true;
        } else if (SysContent.OPER_EDIT.equals(oper)) {
            updateById(sysDictValue);
            flag = true;
        } else if (SysContent.OPER_DELETE.equals(oper)) {
            updateById(sysDictValue);
            flag = true;
        } else {
            throw new MyException(SysContent.ERROR_OPER);
        }
        return flag;
    }

    @Override
    public List<SysDictValue> getListByIds(List<Integer> ids) {
        return sysDictValueMapper.selectListByIds(ids);
    }

}