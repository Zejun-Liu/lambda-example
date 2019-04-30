package com.jiuxian.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: jiuxian
 * @date: 2018-12-04 23:50:00
 * @comment:
 */
@Data
@NoArgsConstructor
public class Order {
    private String id;
    private String userId;
    private String code;
    private Integer qty;
    private BigDecimal amount;
    public static List<Order> orders = new ArrayList<>();

    public Order(String id, String userId, String code, Integer qty, BigDecimal amount) {
        this.id = id;
        this.userId = userId;
        this.code = code;
        this.qty = qty;
        this.amount = amount;
    }

    static {
        Order order = new Order(UUID.randomUUID().toString(),
                "1", "001", 2,
                BigDecimal.valueOf(10));
        orders.add(order);

        order = new Order(UUID.randomUUID().toString(),
                "1", "002", 2,
                BigDecimal.valueOf(15));
        orders.add(order);


        order = new Order(UUID.randomUUID().toString(),
                "2", "003", 3,
                BigDecimal.valueOf(10.1));
        orders.add(order);

        order = new Order(UUID.randomUUID().toString(),
                "2", "004", 1,
                BigDecimal.valueOf(100));
        orders.add(order);
    }

}
