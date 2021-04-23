package com.doulin.entity.common;

import lombok.Data;
import lombok.ToString;

/**
 * @className BankCardVo
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/22 10:39
 * @Version 1.0
 */
@Data
@ToString
public class BankCardVo {
    private String valid_date;
    private String bank_card_number;
    private String bank_name;
    private int bank_card_type;
    private String bank_card_type_name;
}
