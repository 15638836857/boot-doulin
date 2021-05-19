package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TFeedback;
import com.doulin.entity.vo.VQuery;

/**
* TFeedbackService
* @Author malinging
* @Date 2021-05-19
**/
public interface TFeedbackService extends IService<TFeedback> {

    IPage<TFeedback> page(VQuery query);

    /**
     * 意见反馈 添加
     * @param feedback
     */
    void addInfo(TFeedback feedback) throws Exception;
}
