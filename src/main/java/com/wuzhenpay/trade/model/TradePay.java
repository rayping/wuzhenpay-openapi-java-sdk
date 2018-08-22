package com.wuzhenpay.trade.model;

/**
 * Created by steve on 2018/5/21
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class TradePay {
    /**
     * @var 支付方式
     */
    private String payType;
    /**
     * @var 商家订单号
     */
    private String outTradeNo;
    /**
     * @var 订单标题
     */
    private String subject;
    /**
     * @var 订单总金额
     */
    private String totalFee;
    /**
     * @var 交易超时时间
     */
    private String timeExpire;
    /**
     * @var 异步请求地址
     */
    private String notifyUrl;
    /**
     * @var 微信子商户appid
     */
    private String subAppid;
    /**
     * @var 是否为小程序支付
     */
    private String isMinipg;
    /**
     * @var 商户微信公众号对应的openid，微信公众号支付时必选
     */
    private String openid;
    /**
     * @var 买家的支付宝用户id，支付宝扫码支付时必选，买家支付宝用户ID
     */
    private String buyerId;
    /**
     * @var 支付授权码，条码支付时必选
     */
    private String authCode;
    /**
     * @var 商户操作员编号
     */
    private String operatorId;
    /**
     * @var 商户机具终端编号
     */
    private String terminalId;
    /**
     * @var 业务扩展参数
     */
    private String attach;
    /**
     * @var 备注
     */
    private String remarks;
    /**
     * @var 推送目标
     */
    private String target;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }

    public String getIsMinipg() {
        return isMinipg;
    }

    public void setIsMinipg(String isMinipg) {
        this.isMinipg = isMinipg;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
