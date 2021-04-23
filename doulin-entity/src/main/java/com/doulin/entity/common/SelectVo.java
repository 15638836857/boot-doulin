package com.doulin.entity.common;

import lombok.Data;

import java.util.List;

/**
 * @className SelectVo
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/22 16:09
 * @Version 1.0
 */
@Data
public class SelectVo {
    private String label;
    private String value;
    private String code;
    private String parent;
    List<SelectVo> childList;
}
