package com.doulin.entity.edo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @className 行业类别
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/12 12:43
 * @Version 1.0
 */
@Data
public class Industrycate {
    private String pid;
    private String name;
    private String code;
    private List<Industrycate> child=new ArrayList<>();
}
