package com.wuzhenpay.http;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by steve on 2018/5/21
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class HttpResponse {
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 具体内容
     */
    private Object data;

    /**
     * 业务内容
     */
    private JSONObject bizContent;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 具体的错误代码
     */
    private String subCode;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JSONObject getBizContent() {
        return bizContent;
    }

    public void setBizContent(JSONObject bizContent) {
        this.bizContent = bizContent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }
}
