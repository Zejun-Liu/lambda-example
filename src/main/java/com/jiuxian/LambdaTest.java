package com.jiuxian;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: jiuxian
 * Date: 2018-12-04 23:52:00
 * Comment:
 */
public class LambdaTest {
    private static List<Order> orders = new ArrayList<>();

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


    @Test
    public void forEachTest() {
        orders.forEach(System.out::println);

        orders.forEach(order -> {
            System.out.println(order.getId());
        });
        //如果代码就一行，可以去掉括号
        orders.forEach(order -> System.out.println(order.getId()));

    }

    @Test
    public void filterTest() {
        String userId = "1";
        List<Order> orderList = orders.stream()
                .filter(s -> userId.equals(s.getUserId()))
                .collect(Collectors.toList());
        System.out.println(orderList);
    }

    @Test
    public void mapTest() {
        List<Integer> collect = orders.stream().map(order -> {
            return 1;
        }).collect(Collectors.toList());
        System.out.println(collect);

        List<String> orderIds = orders.stream().map(Order::getId).collect(Collectors.toList());
        System.out.println(orderIds);
    }

    @Test
    public void reduceTest() {
        Optional<Order> reduce = orders.stream().reduce((order1, order2) -> {
            if (order1.getQty() > order2.getQty()) {
                return order1;
            } else {
                return order2;
            }
        });
        reduce.ifPresent(System.out::println);

        Optional<Integer> reduce1 = orders.stream().map(Order::getQty).reduce((sum, item) -> sum + item);
        reduce1.ifPresent(System.out::println);

        Integer reduce2 = orders.stream().map(Order::getQty).reduce(10, (sum, item) -> sum + item);
        System.out.println(reduce2);

        Optional<BigDecimal> reduce3 = orders.stream().map(Order::getAmount).reduce(BigDecimal::add);
        reduce3.ifPresent(System.out::println);
    }

    @Test
    public void collectTest() {

    }

}
