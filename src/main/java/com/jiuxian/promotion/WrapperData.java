package com.jiuxian.promotion;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: LIU ZEJUN
 * Date: 2019-04-30 15:39:00
 * Comment:
 */

@Getter
@Setter
public class WrapperData<T> {
    private Class<T> clazz;
    private List<FieldOperation> fieldOperations = new ArrayList<>();

    public void set(String field, Expression expression, Object value) {
        FieldOperation operation = FieldOperation.builder()
                .field(field)
                .expression(expression)
                .value(value)
                .build();
        fieldOperations.add(operation);
    }


}
