package com.wuzhenpay.trade.model;

/**
 * Created by steve on 2018/8/22
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class TradeRefund {
    /**
     * @var 商户订单号
     */
    private String outTradeNo;

    /**
     * @var 平台流水号
     */
    private String transactionId;

    /**
     * @var 退款单号
     */
    private String outRefundNo;

    /**
     * @var 退款金额，单位为元，可以做部分退款
     */
    private String refundFee;

    /**
     * @var 退款原因
     */
    private String reason;

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

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
