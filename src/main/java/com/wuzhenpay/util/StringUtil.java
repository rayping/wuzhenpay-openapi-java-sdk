package com.wuzhenpay.util;

/**
 * Created by steve on 2018/5/21
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class StringUtil {
    /**
     * 判断字串是否为空值
     * NULL、空格均为空值
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        return null == value || value.trim().length() == 0;
    }
}
