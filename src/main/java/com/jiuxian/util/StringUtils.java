package com.jiuxian.util;

/**
 * Author: LIU ZEJUN
 * Date: 2019-04-30 16:06:00
 * Comment:
 */


public class StringUtils {

    public static String resolveFieldName(String getMethodName) {
        if (getMethodName.startsWith("get")) {
            getMethodName = getMethodName.substring(3);
        } else if (getMethodName.startsWith("is")) {
            getMethodName = getMethodName.substring(2);
        }
        // 小写第一个字母
        char[] chars = getMethodName.toCharArray();
        chars[0] += 32;
        return new String(chars);
    }
}
