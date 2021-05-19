package com.doulin.service.impl;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doulin.common.content.SysContent;
import com.doulin.entity.TFeedback;
import com.doulin.entity.vo.VQuery;
import com.doulin.mapper.TFeedbackMapper;
import com.doulin.service.TFeedbackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
* TFeedbackServiceImpl
* @Author malinging
* @Date 2021-05-19
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class TFeedbackServiceImpl extends ServiceImpl<TFeedbackMapper, TFeedback> implements TFeedbackService {

    @Override
    public IPage<TFeedback> page(VQuery query) {
        IPage<TFeedback> page = new Page<>();
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();
        page.setCurrent(pageNum == null ? 1 : pageNum);
        page.setSize(pageSize == null ? 10 : pageSize);
        return baseMapper.findByQuery(page, query);
    }

    @Override
    public void addInfo(TFeedback feedback) throws Exception {
        if(null==feedback.getUid()){
            throw new Exception(SysContent.ERROR_PARAM);
        }else if(StrUtil.isEmpty(feedback.getNickname())){
            throw new Exception(SysContent.ERROR_PARAM);
        }else if(!PhoneUtil.isMobile(feedback.getPhone())){
            throw new Exception(SysContent.ERROR_PARAM);
        }else if(StrUtil.isEmpty(feedback.getContent())){
            throw new Exception(SysContent.ERROR_PARAM);
        }else{
            feedback.setAdtime(new Date());
            save(feedback);
        }
    }

}