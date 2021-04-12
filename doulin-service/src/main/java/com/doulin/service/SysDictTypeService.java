package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.common.MyException;
import com.doulin.entity.SysDictType;
import com.doulin.entity.vo.VQuery;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * SysDictTypeService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysDictTypeService extends IService<SysDictType> {

    IPage<SysDictType> page(VQuery query);

    /**
     * 字典类型添加 或修改 参数判断
     * @param sysDictType 实体类对象
     * @return 判断的值 Y
     */
    void addAndUpateParamFlag(SysDictType sysDictType) throws MyException;

    /**
     * 字典类型添加或修改或删除
     * @param oper add/添加  edit/编辑 del/删除
     * @param sysDictType
     */
    void addOrUpdate(String oper,SysDictType sysDictType) throws MyException;

    /**
     * 根据 code 获取 字典信息
     * @param code 编码code
     * @return 对象信息
     */
    SysDictType getOneByCode(String code);

    /**
     * 根据id编辑删除
     * @param ids
     * @return
     */
    boolean deleteByids(List<Integer> ids) throws MyException;

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    SysDictType getOneById(Integer id);
}
