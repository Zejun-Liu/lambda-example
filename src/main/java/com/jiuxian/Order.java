package com.jiuxian;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: jiuxian
 * @date: 2018-12-04 23:50:00
 * @comment:
 */
@Data
public class Order {
    private String id;
    private String userId;
    private String code;
    private Integer qty;
    private BigDecimal amount;

    public Order(String id, String userId, String code, Integer qty, BigDecimal amount) {
        this.id = id;
        this.userId = userId;
        this.code = code;
        this.qty = qty;
        this.amount = amount;
    }
}
