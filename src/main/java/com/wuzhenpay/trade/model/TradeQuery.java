package com.wuzhenpay.trade.model;

/**
 * Created by steve on 2018/8/22
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class TradeQuery {
    /**
     * @var 商户订单号
     */
    private String outTradeNo;
    /**
     * @var 平台流水号
     */
    private String transactionId;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
