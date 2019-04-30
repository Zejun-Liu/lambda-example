package com.jiuxian.promotion;

import java.util.List;

/**
 * Author: LIU ZEJUN
 * Date: 2019-04-30 15:55:00
 * Comment:
 */

public interface Wrapper<T> {
    Class<T> getEntityClass();

    List<FieldOperation> getFieldOperations();
}
