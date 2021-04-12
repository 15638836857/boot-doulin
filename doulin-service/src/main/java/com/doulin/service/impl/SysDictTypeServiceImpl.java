package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.MyException;
import com.doulin.common.content.SysContent;
import com.doulin.entity.SysDictType;
import com.doulin.entity.SysDictValue;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.SysDictTypeMapper;
import com.doulin.mapper.SysDictValueMapper;
import com.doulin.service.SysDictTypeService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * SysDictTypeServiceImpl
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {

    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;
    @Autowired
    private SysDictValueMapper sysDictValueMapper;

    @Override
    public IPage<SysDictType> page(VQuery query) {
        IPage<SysDictType> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void addAndUpateParamFlag(SysDictType sysDictType) throws MyException {
        if (StrUtil.isEmpty(sysDictType.getTypeCode())) {
            throw new MyException(SysContent.ERROR_DICT_TYPE_CODE);
        } else if (StrUtil.isEmpty(sysDictType.getTypeName())) {
            throw new MyException(SysContent.ERROR_DICT_TYPE_NAME);
        }
    }

    @Override
    @Transactional(rollbackFor = MyException.class)
    public void addOrUpdate(String oper, SysDictType sysDictType) throws MyException {
        addAndUpateParamFlag(sysDictType);
        SysDictType dictType = getOneByCode(sysDictType.getTypeCode());
        //添加
        if (SysContent.OPER_ADD.equals(oper)) {
            if (null != dictType) {
                throw new MyException(SysContent.ERROR_DICT_TYPE_CODE_EXSIS);
            }
            save(sysDictType);
            //编辑
        } else if (SysContent.OPER_EDIT.equals(oper)) {
            if (StrUtil.isEmptyIfStr(sysDictType.getId())) {
                throw new MyException(SysContent.ERROR_ID);
            }
            if (dictType.getId().equals(sysDictType.getId())) {
                updateById(sysDictType);
            } else {
                throw new MyException(SysContent.ERROR_DICT_TYPE_CODE_EXSIS);
            }
            //删除
        } else if (SysContent.OPER_DELETE.equals(oper)) {
            String[] ids=sysDictType.getTypeCode().split(SysContent.EN_D);
            List<Integer> arrayIds=new ArrayList<>();
            for (int i = 0; i < ids.length; i++) {
                arrayIds.add(Integer.valueOf(ids[i]));
            }
            deleteByids(arrayIds);
        } else {
            throw new MyException(SysContent.ERROR_OPER);
        }
    }

    @Override
    public SysDictType getOneByCode(String code) {
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SysContent.DEL_FLAG, SysContent.INTGER_0);
        queryWrapper.eq(SysContent.TYPE_CODE, code);
        return getOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = MyException.class)
    public boolean deleteByids(List<Integer> ids) throws MyException {
        List<SysDictValue> listValue = sysDictValueMapper.selectByTypeIds(ids);
        if (null != listValue) {
            throw new MyException(SysContent.ERROR_DICT_TYPE_DELETE);
        }
        sysDictTypeMapper.deleteByids(ids);
        return true;
    }

    @Override
    public SysDictType getOneById(Integer id) {
        SysDictType dictType = sysDictTypeMapper.selectOneById(id);
        if (null != dictType) {
            return dictType;
        } else {
            return new SysDictType();
        }
    }

}