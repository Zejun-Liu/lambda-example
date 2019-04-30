package com.jiuxian.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Author: LIU ZEJUN
 * Date: 2019-04-29 14:37:00
 * Comment:
 */


public class ClassUtils {

    @SuppressWarnings("unchecked")
    public static <T> Class<T> toClassConfident(String className) {
        try {
            return (Class<T>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> Class<T> getModelClass(Class clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        // 得到泛型父类
        //一个泛型类可能有多个泛型形参，比如ClassName<T,K> 这里有两个泛型形参T和K，Class Name<T> 这里只有1个泛型形参T
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<T> modelClass;
        if (params.length - 1 < index) {
            modelClass = null;
        } else {
            modelClass = (Class<T>) params[index];
        }
        return modelClass;
    }
}
