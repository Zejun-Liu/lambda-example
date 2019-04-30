package com.jiuxian.promotion;

import com.jiuxian.util.StringUtils;

import java.util.List;


/**
 * Author: LIU ZEJUN
 * Date: 2019-04-29 14:13:00
 * Comment:
 */

public abstract class AbstractLambdaWrapper<T, Children, R> implements Compare<R, Children>, Wrapper<T> {

    @SuppressWarnings("unchecked")
    protected Children children = (Children) this;

    protected WrapperData<T> wrapperData;

    protected Class<T> entityClass;


    protected AbstractLambdaWrapper() {
        wrapperData = new WrapperData<>();
    }

    @SuppressWarnings("unchecked")
    private void columnToString(R column, Expression expression, Object value) {
        SerializedLambda serializedLambda = serializedLambda(column);
        String fieldName = StringUtils.resolveFieldName(serializedLambda.getImplMethodName());
        wrapperData.set(fieldName, expression, value);
        wrapperData.setClazz(serializedLambda.getImplClass());
        entityClass = serializedLambda.getImplClass();
    }

    private SerializedLambda serializedLambda(R column) {
        SFunction sFunction = (SFunction) column;
        return SerializedLambda.resolve(sFunction);
    }

    @Override
    public Class<T> getEntityClass() {
        return entityClass;
    }

    @Override
    public List<FieldOperation> getFieldOperations() {
        return wrapperData.getFieldOperations();
    }

    @Override
    public Children eq(R column, Object val) {
        columnToString(column, Expression.EQ, val);
        return children;
    }

    @Override
    public Children ge(R column, Object val) {
        columnToString(column, Expression.GE, val);
        return children;
    }

    @Override
    public Children le(R column, Object val) {
        columnToString(column, Expression.LE, val);
        return children;
    }

}
