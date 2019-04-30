package com.jiuxian.promotion;

import java.io.Serializable;
import java.util.function.Function;

/**
 * Author: LIU ZEJUN
 * Date: 2019-04-29 11:00:00
 * Comment:
 */
@FunctionalInterface
public interface SFunction<T, R> extends Function<T, R>, Serializable {
}
