package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.common.MyException;
import com.doulin.entity.SysUser;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
 * SysUserService
 *
 * @Author malinging
 * @Date 2021-04-09
 **/
public interface SysUserService extends IService<SysUser> {

    IPage<SysUser> page(VQuery query);

    /**
     * 根据手机号 获取用户的信息
     * @param telePhone 手机号
     * @return 系统用户实体对象
     */
    SysUser getOneByTelePhone(String telePhone);

    /**
     * 系统用户校验
     * @param oper 操作导航
     * @param sysUser  系统用户对象类
     * @throws MyException
     */
    void verificationSysUser(String oper,SysUser sysUser) throws MyException;

    /**
     * 编辑用户 或添加用户
     * @param oper add/添加 edit/编辑
     * @param sysUser
     * @return
     */
    boolean addAndUpdate(String oper, SysUser sysUser) throws MyException;

    /**
     * 根据ids 数组删除修改用户
     * @param ids
     * @return
     */
    boolean deleteByIds(List<Integer> ids) throws MyException;

    /**
     * 分页查询 根据手机号和用户的真实姓名
     * @param vmap
     * @return
     */
    IPage<SysUser> pageInfo(Map<String, Object> vmap);
}
