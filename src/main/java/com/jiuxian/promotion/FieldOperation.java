package com.jiuxian.promotion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldOperation {
    private String field;
    private Expression expression;
    private Object value;
}