package com.wuzhenpay.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

/**
 * Created by steve on 2018/5/21
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class JsonUtil extends JSON {
    /**
     * 判断是否为json array
     * @param json
     * @return
     */
    public static boolean isJsonArray(String json) {
        try {
            JSON.parseArray(json);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    /**
     * 判断是否为json object
     * @param json
     * @return
     */
    public static boolean isJsonObject(String json) {
        try {
            JSON.parseObject(json);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
