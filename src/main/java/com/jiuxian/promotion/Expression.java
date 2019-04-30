package com.jiuxian.promotion;

/**
 * Author: LIU ZEJUN
 * Date: 2019-04-30 16:41:00
 * Comment:
 */

public enum Expression {
    EQ("="),
    GE(">="),
    LE("<=");
    private String operation;

    Expression(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
