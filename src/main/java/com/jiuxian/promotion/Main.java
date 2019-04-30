package com.jiuxian.promotion;

import com.jiuxian.entity.Order;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Author: LIU ZEJUN
 * Date: 2019-04-29 14:31:00
 * Comment:
 */


public class Main {

    @Test
    public void test1() {
        Wrapper<Order> wrapper = new LambdaWrapper<Order>()
                .eq(Order::getId, 1L)
                .ge(Order::getCode, "001")
                .le(Order::getAmount, new BigDecimal(10));
        System.out.println(wrapper.getEntityClass());
        System.out.println(wrapper.getFieldOperations());

        LambdaWrapper<Order> orderLambdaWrapper = new LambdaWrapper<>();
        System.out.println(orderLambdaWrapper.getEntityClass());
        System.out.println(orderLambdaWrapper.getFieldOperations());
    }
}
