package com.doulin.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author jyj
 * @Date 2020/4/26
 **/
@Data
public class VQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pageNum;

    private Integer pageSize;

}
