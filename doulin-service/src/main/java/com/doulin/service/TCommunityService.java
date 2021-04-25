package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.common.MyException;
import com.doulin.entity.TCommunity;
import com.doulin.entity.common.SelectVo;
import com.doulin.entity.edo.TreeUtil;
import com.doulin.entity.vo.VQuery;

import java.util.List;
import java.util.Map;

/**
* TCommunityService
* @Author malinging
* @Date 2021-04-15
**/
public interface TCommunityService extends IService<TCommunity> {

    IPage<TCommunity> page(VQuery query);

    /**
     * 添加或编辑
     * @param oper
     * @param tCommunity
     * @throws MyException
     */
    void addAndUpdateParam(String oper,TCommunity tCommunity) throws MyException;

    /**
     * 新增一个社区code
     * @return
     */
    String addCommunityCode();

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    TCommunity getOneById(Integer id);

    IPage<TCommunity> pageInfo(Map<String, Object> map);

    void deleteBatchByIds(String loginUserId,List<String> ids);

    /**
     * 下拉
     * @return
     */
    List<SelectVo> getSelectVo();


    TreeUtil<SelectVo> getTreeSelectVo();
}
