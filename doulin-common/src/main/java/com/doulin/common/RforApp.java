package com.doulin.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @className RforApp
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/15 14:58
 * @Version 1.0
 */
@Data
public class RforApp implements Serializable {
    private String result;
    private String resultNote;
    private Integer mainShow;
    private Object Object;
}
