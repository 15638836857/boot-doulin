package com.doulin.entity.common;

import lombok.Data;

/**
 * @className BusinessVo
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/22 14:20
 * @Version 1.0
 */
@Data
public class BusinessVo {
    //信用代码
    private String creditCode;
    //单位名称
    private String commpayName;
    //成立日期
    private String createDt;
    //有效期
    private String validTime;
    //类型
    private String type;
    //经营范围
    private String businessScope;
}
