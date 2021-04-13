package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.common.MyException;
import com.doulin.entity.SysDictValue;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
 * SysDictValueService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysDictValueService extends IService<SysDictValue> {

    IPage<SysDictValue> page(VQuery query);

    /**
     * 根据类型code获取值
     * @param typeCodes
     * @return
     */
    List<SysDictValue> getByTypeCods(List<String> typeCodes);

    /**
     * 字典值的添加 或编辑 验证
     * @param sysDictValue
     * @param oper add/添加  edit/编辑    del/删除
     * @throws MyException
     */
    void addAndUpateParamFlag(String oper,SysDictValue sysDictValue) throws MyException;

    /**
     * 根据字典的类型code 或 字典值 value 查询信息
     * @param typeCode 类型code
     * @param value sysDictValue表 的值
     * @return
     */
    List<SysDictValue> getListByTypeCodeOrValue(String typeCode,String value);

    /**
     * 字典添加或修改删除
     * @param sysDictValue
     * @param oper
     * @return
     */
    boolean addAndUpdate(String oper,SysDictValue sysDictValue) throws MyException;

    /**
     * 根据ids 获取信息
     * @param ids
     * @return
     */
    List<SysDictValue> getListByIds(List<Integer> ids);

}
