package com.doulin.entity;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * TGoods Entity
 *
 * @Author: malinging
 * @Date: 2021-04-09
 */
@ApiModel(value = "TGoods Entity", description = "商品表")
@Data
@TableName("t_goods")
public class TGoods implements Serializable {


    /**
     * 分类id
     */
    @ApiModelProperty(value = "分类id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("category_id")
    private Integer categoryId;

    /**
     * 商家编码
     */
    @ApiModelProperty(value = "商家编码")
    @TableField("shop_home_code")
    private String shopHomeCode;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    @TableField("goods_name")
    private String goodsName;

    /**
     * 封面图
     */
    @ApiModelProperty(value = "封面图")
    @TableField("image_title")
    private String imageTitle;

    /**
     * 商品简介
     */
    @ApiModelProperty(value = "商品简介")
    @TableField("goods_title")
    private String goodsTitle;

    /**
     * 是否有效 Y/N
     */
    @ApiModelProperty(value = "是否有效 Y/N")
    @TableField("state")
    private String state;

    /**
     * 商品的详情
     */
    @ApiModelProperty(value = "商品的详情")
    @TableField("content")
    private String content;

    /**
     * 关键字 多个使用英文逗号间隔
     */
    @ApiModelProperty(value = "关键字 多个使用英文逗号间隔")
    @TableField("keyword")
    private String keyword;

    /**
     * 商品备注
     */
    @ApiModelProperty(value = "商品备注")
    @TableField("remark")
    private String remark;

    @TableField("sales_volume")
    private BigDecimal salesVolume;

    /**
     * 商品下架  Y/N
     */
    @ApiModelProperty(value = "商品下架  Y/N")
    @TableField("goods_lowerframe")
    private String goodsLowerframe;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    /**
     * 删除标识 0/1
     */
    @ApiModelProperty(value = "删除标识 0/1")
    @TableField("del_flag")
    private Integer delFlag;

    @TableField("add_by")
    private String addBy;

    @TableField("add_dt")
    private Date addDt;

    @TableField("edit_by")
    private String editBy;

    @TableField("edit_dt")
    private Date editDt;
    /**
     * sku商品list
     */
    @TableField(exist = false)
    private List<TGoodsSku> skuList;
    @TableField(exist = false)
    private Integer  sysGoodsId;
    @TableField(exist = false)
    private String  skuPrice;

    public List<TGoodsSku> getSkuList(){
        if(StrUtil.isEmpty(skuPrice)){
            List<TGoodsSku> list=new LinkedList<>();
            String[] sku=skuPrice.split(",");
            for (String s : sku) {
                String[] price=s.split("-");
                TGoodsSku  tGoodsSku=new TGoodsSku();
                for (String s1 : price) {
                    if(StrUtil.isEmpty(tGoodsSku.getSku())){
                        tGoodsSku.setSku(s1);
                    }else   if(null==tGoodsSku.getPrice()){
                       tGoodsSku.setPrice(BigDecimal.valueOf(Long.valueOf(s1)));
                   }else if(null==tGoodsSku.getCuPrice()){
                        tGoodsSku.setCuPrice(BigDecimal.valueOf(Long.valueOf(s1)));
                    }else if(null==tGoodsSku.getStock()){
                        tGoodsSku.setStock(Integer.valueOf(s1));
                    }
                }
                list.add(tGoodsSku);
            }
            return list;
        }
        return new ArrayList<TGoodsSku>();
    }

}
