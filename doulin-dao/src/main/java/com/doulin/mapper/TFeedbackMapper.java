package com.doulin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doulin.entity.TFeedback;
import com.doulin.entity.vo.VQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* TFeedbackMapper
* @Author malinging
* @Date 2021-05-19
**/
@Mapper
public interface TFeedbackMapper extends BaseMapper<TFeedback> {

    IPage<TFeedback> findByQuery(IPage<TFeedback> page, @Param("query") VQuery query);

}
