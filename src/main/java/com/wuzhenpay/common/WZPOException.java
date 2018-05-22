package com.wuzhenpay.common;

/**
 * Created by steve on 2018/5/21
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class WZPOException extends RuntimeException {
    public WZPOException() {
    }

    public WZPOException(String message) {
        super(message);
    }

    public WZPOException(String message, Throwable cause) {
        super(message, cause);
    }
}
