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
        Optional<Order> reduce4 = orders.stream().reduce((o1, o2) -> o1.getQty() > o2.getQty() ? o1 : o2);
        reduce4.ifPresent(System.out::println);

        Optional<Integer> reduce1 = orders.stream().map(Order::getQty).reduce((sum, item) -> sum + item);
        reduce1.ifPresent(System.out::println);

        Integer reduce2 = orders.stream().map(Order::getQty).reduce(10, (sum, item) -> sum + item);
        System.out.println(reduce2);

        Optional<BigDecimal> reduce3 = orders.stream().map(Order::getAmount).reduce(BigDecimal::add);
        reduce3.ifPresent(System.out::println);
    }

    @Test
    public void collectTest() {
        Map<String, Order> orderIdMap = orders.stream().collect(Collectors.toMap(Order::getUserId, v -> v));
        System.out.println(orderIdMap);

        Map<String, String> orderIdUserIdMap = orders.stream().collect(Collectors.toMap(Order::getId, Order::getUserId));
        System.out.println(orderIdUserIdMap);

        Map<String, Order> userIdMap = orders.stream().collect(Collectors.toMap(Order::getUserId, v -> v, (k1, k2) -> k1));
        System.out.println(userIdMap);

        Map<String, List<Order>> userIdOrdersMap = orders.stream().collect(Collectors.groupingBy(Order::getUserId));
        System.out.println(userIdOrdersMap);

        Map<String, Optional<BigDecimal>> userIdAmountMap = userIdOrdersMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        v -> v.getValue().stream().map(Order::getAmount).reduce(BigDecimal::add)));
        System.out.println(userIdAmountMap);

        Map<String, BigDecimal> userIdAmountMap2 = userIdOrdersMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        v -> v.getValue().stream().map(Order::getAmount)
                                .reduce(BigDecimal::add)
                                .orElse(BigDecimal.ZERO)));
        System.out.println(userIdAmountMap2);

        Map<String, LongSummaryStatistics> collect = userIdOrdersMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        v -> v.getValue().stream().collect(Collectors.summarizingLong(Order::getQty))));

        System.out.println(collect);


        //1. 查找最大最小值
        //maxBy(Comparator)
        //minBy(Comparator)

        //求和:
        //summingInt(XX::getX)
        //summingLong(XX::getX)
        //summingDouble(XX::getX)
        //求平均值:
        //averagingInt(XX::getX)
        //averagingDouble(XX::getX)
        //averagingLong(XX::getX)
        //综合方法，和，平均，最大最小全求出来:
        //summarizingInt(XX:getX)
        //summarizingDouble(XX:getX)
        //summarizingLong(XX:getX)




    }

}
