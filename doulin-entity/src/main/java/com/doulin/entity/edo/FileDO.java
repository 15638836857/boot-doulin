package com.doulin.entity.edo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-19 16:02:20
 */
@Data
public class FileDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    // 文件类型
    private Integer type;
    // URL地址
    private String url;
    // 创建时间
    private Date createDate;


    public FileDO() {
        super();
    }


    public FileDO(Integer type, String url, Date createDate) {
        super();
        this.type = type;
        this.url = url;
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "FileDO{" +
                "id=" + id +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
