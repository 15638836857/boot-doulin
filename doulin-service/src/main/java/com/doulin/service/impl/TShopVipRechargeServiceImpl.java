package com.doulin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TShopVipRecharge;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TShopVipRechargeMapper;
import com.doulin.service.TShopVipRechargeService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
* TShopVipRechargeServiceImpl
* @Author malinging
* @Date 2021-05-07
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TShopVipRechargeServiceImpl extends ServiceImpl<TShopVipRechargeMapper, TShopVipRecharge> implements TShopVipRechargeService {

    @Autowired
    private TShopVipRechargeMapper tShopVipRechargeMapper;
    @Override
    public IPage<TShopVipRecharge> page(VQuery query) {
        IPage<TShopVipRecharge> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void operData(String oper, TShopVipRecharge tShopVipRecharge) throws Exception {
        if (SysContent.OPER_ADD.equals(oper)) {
            tShopVipRecharge.setDelFlag(SysContent.INTGER_0);
            if (StrUtil.isEmpty(tShopVipRecharge.getName())) {
                throw new Exception("规则名称不能为空");
            } else if (StrUtil.isEmpty(tShopVipRecharge.getShopHomeCode())) {
                throw new Exception("商家编号不能为空");
            } else if (null == tShopVipRecharge.getToMoney()) {
                throw new Exception("送多少钱不能为空");
            } else if (null == tShopVipRecharge.getRechargeMoney()) {
                throw new Exception("充值多少钱不能为空");
            } else if (StrUtil.isEmpty(tShopVipRecharge.getVipFlag())) {
                throw new Exception(SysContent.ERROR_PARAM);
            } else {
                if (StrUtil.isEmpty(tShopVipRecharge.getOpenFlag())) {
                    tShopVipRecharge.setOpenFlag(SysContent.N_STR);
                }
                if (StrUtil.isEmpty(tShopVipRecharge.getValidFlag())) {
                    tShopVipRecharge.setValidFlag(SysContent.N_STR);
                }
                save(tShopVipRecharge);
            }
        } else if (SysContent.OPER_EDIT.equals(oper)) {
            if (null == tShopVipRecharge.getToMoney()) {
                throw new Exception("送多少钱不能为空");
            } else if (null == tShopVipRecharge.getRechargeMoney()) {
                throw new Exception("充值多少钱不能为空");
            } else if (null == tShopVipRecharge.getId()) {
                throw new Exception(SysContent.ERROR_ID);
            } else {
                updateById(tShopVipRecharge);
            }
        } else if (SysContent.OPER_DELETE.equals(oper)) {
            if (null == tShopVipRecharge.getId()) {
                throw new Exception(SysContent.ERROR_ID);
            } else {
                tShopVipRecharge.setDelFlag(SysContent.INTGER_1);
                updateById(tShopVipRecharge);
            }

            //开启活动
        } else if (SysContent.OPER_OPEN.equals(oper)) {
            List<TShopVipRecharge> selectList = tShopVipRechargeMapper.selectVipStored(null,
                    tShopVipRecharge.getName(), null,
                    tShopVipRecharge.getValidFlag(), tShopVipRecharge.getShopHomeCode());
            List<TShopVipRecharge> updtelist = new ArrayList<>();
            for (TShopVipRecharge ts : selectList) {
                if (tShopVipRecharge.getOpenFlag().equals(SysContent.Y_STR)) {
                    //有效的ids
                    String idsstr=tShopVipRecharge.getIds();
                    if (!StrUtil.isEmpty(idsstr)) {
                        String[] ids = idsstr.split(SysContent.EN_D);
                        List<String> idsList = Arrays.asList(ids);
                        if (idsList.contains(ts.getId().toString())) {
                            //开启
                            ts.setValidFlag(SysContent.Y_STR);
                            ts.setOpenFlag(tShopVipRecharge.getOpenFlag());
                        }else{
                            ts.setValidFlag(SysContent.N_STR);
                            ts.setOpenFlag(tShopVipRecharge.getOpenFlag());
                        }
                        updtelist.add(ts);
                    } else {
                        ts.setValidFlag(SysContent.N_STR);
                        ts.setOpenFlag(tShopVipRecharge.getOpenFlag());
                        updtelist.add(ts);
                    }
                } else if (tShopVipRecharge.getOpenFlag().equals(SysContent.N_STR)) {
                    ts.setOpenFlag(tShopVipRecharge.getOpenFlag());
                    updtelist.add(ts);
                } else {
                    throw new Exception(SysContent.ERROR_PARAM);
                }

            }
            updateBatchById(updtelist);
        } else if (SysContent.OPER_VALID.equals(oper)) {
            String[] ids = tShopVipRecharge.getIds().split(SysContent.EN_D);
            List<TShopVipRecharge> updateList = new ArrayList<>();
            for (String id : ids) {
                TShopVipRecharge ts = new TShopVipRecharge();
                ts.setId(Integer.valueOf(id));
                //有效
                ts.setValidFlag(SysContent.Y_STR);
                updateList.add(ts);
            }
            updateBatchById(updateList);
        } else {
            throw new Exception(SysContent.ERROR_OPER);
        }
    }

    @Override
    public List<Map<String, Object>> getVipStored(String loginNo, String name, String vipFlag,String validFlag,String shopHomeCode) {
        List<TShopVipRecharge> list=tShopVipRechargeMapper.selectVipStored(loginNo,  name,  null,validFlag,shopHomeCode);
        if(null!=list&&!list.isEmpty()) {
             Set<String> listname=new HashSet<String>();
             if(StrUtil.isEmpty(vipFlag)){
                 vipFlag="";
             }
            for (TShopVipRecharge t : list) {
                listname.add(t.getName()+vipFlag);
            }
            List<Map<String, Object>> result =new ArrayList<>();
            String openFlag=SysContent.N_STR;
            for (String s : listname) {
                Map<String, Object> map=Maps.newHashMap();
                List<TShopVipRecharge> listresult=new ArrayList<>();
                for (TShopVipRecharge t : list) {
                    String namestr=t.getName()+vipFlag;
                    //判断会员和非会员 开启或者关闭 给到商家端的是 全部的规则信息（全部规则信息）
                    if(t.getOpenFlag().equals(SysContent.Y_STR)&& t.getVipFlag().equals(vipFlag)){
                        openFlag=SysContent.Y_STR;
                    }
                    if(s.equals(namestr)){
                        listresult.add(t);
                        continue;
                    }
                }
                map.put(SysContent.NAME_STR,s);
                map.put("openFlag",openFlag);
                map.put(SysContent.VALUE,listresult);
                result.add(map);
            }
            return result;
        }
        return null;
    }

    @Override
    public void updateByIdsAndVipBaseId(String[] ids, Integer vipBaseId) throws Exception {
        try {
            tShopVipRechargeMapper.updateByIdsAndVipBaseId(vipBaseId);
            tShopVipRechargeMapper.updateVipByIds(ids,vipBaseId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}