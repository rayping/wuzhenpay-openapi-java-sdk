package com.wuzhenpay.trade;

import com.alibaba.fastjson.JSON;
import com.wuzhenpay.auth.MD5;
import com.wuzhenpay.config.InitConfig;
import com.wuzhenpay.http.HttpClient;
import com.wuzhenpay.http.HttpResponse;
import com.wuzhenpay.trade.model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by steve on 2018/5/21
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class Application {

    /**
     * 配置信息
     */
    private static ThreadLocal<InitConfig> initConfig = new ThreadLocal<>();
    public static InitConfig getInitConfig() {
        return initConfig.get();
    }
    public static void setInitConfig(InitConfig config) {
        initConfig.set(config);
    }

    /**
     * 初始化
     * @param initConfig 配置
     */
    public Application(InitConfig initConfig) {
        setInitConfig(initConfig);
    }

    /**
     * 请求统一支付
     * @param tradePay 请求支付实体类
     * @return HttpResponse
     */
    public HttpResponse pay(TradePay tradePay) {
        Map<String, String> map = new HashMap<>();
        map.put("pay_type", tradePay.getPayType());
        map.put("out_trade_no", tradePay.getOutTradeNo());
        map.put("subject", tradePay.getSubject());
        map.put("total_fee", tradePay.getTotalFee());
        map.put("time_expire", tradePay.getTimeExpire());
        map.put("notify_url", tradePay.getNotifyUrl());
        map.put("openid", tradePay.getOpenid());
        map.put("buyer_id", tradePay.getBuyerId());
        map.put("auth_code", tradePay.getAuthCode());
        map.put("operator_id", tradePay.getOperatorId());
        map.put("terminal_id", tradePay.getTerminalId());
        map.put("attach", tradePay.getAttach());
        map.put("remarks", tradePay.getRemarks());
        map.put("target", tradePay.getTarget());

        // 获取请求参数
        Map<String, String> requestParams = getRequestParams(map);

        // 请求
        return HttpClient.post("/trade/pay", requestParams, getInitConfig().getSecret());
    }

    /**
     * 交易退款
     * @param tradeRefund 请求退款实体类
     * @return HttpResponse
     */
    public HttpResponse refund(TradeRefund tradeRefund) {
        Map<String, String> map = new HashMap<>();
        map.put("out_trade_no", tradeRefund.getOutTradeNo());
        map.put("transaction_id", tradeRefund.getTransactionId());
        map.put("out_refund_no", tradeRefund.getOutRefundNo());
        map.put("refund_fee", tradeRefund.getRefundFee());
        map.put("reason", tradeRefund.getReason());

        // 获取请求参数
        Map<String, String> requestParams = getRequestParams(map);

        // 请求
        return HttpClient.post("/trade/refund", requestParams, getInitConfig().getSecret());
    }

    /**
     * 关闭订单
     * @param tradeClose 请求关单实体类
     * @return HttpResponse
     */
    public HttpResponse close(TradeClose tradeClose) {
        Map<String, String> map = new HashMap<>();
        map.put("out_trade_no", tradeClose.getOutTradeNo());

        // 获取请求参数
        Map<String, String> requestParams = getRequestParams(map);

        // 请求
        return HttpClient.post("/trade/close", requestParams, getInitConfig().getSecret());
    }

    /**
     * 交易查询
     * @param tradeQuery 请求查询实体类
     * @return HttpResponse
     */
    public HttpResponse query(TradeQuery tradeQuery) {
        Map<String, String> map = new HashMap<>();
        map.put("out_trade_no", tradeQuery.getOutTradeNo());
        map.put("transaction_id", tradeQuery.getTransactionId());

        // 获取请求参数
        Map<String, String> requestParams = getRequestParams(map);

        // 请求
        return HttpClient.post("/trade/query", requestParams, getInitConfig().getSecret());
    }

    /**
     * 撤销订单
     * @param tradeReverse 请求撤单实体类
     * @return HttpResponse
     */
    public HttpResponse reverse(TradeReverse tradeReverse) {
        Map<String, String> map = new HashMap<>();
        map.put("out_trade_no", tradeReverse.getOutTradeNo());

        // 获取请求参数
        Map<String, String> requestParams = getRequestParams(map);

        // 请求
        return HttpClient.post("/trade/reverse", requestParams, getInitConfig().getSecret());
    }

    /**
     * 获取请求参数
     * @param map 请求参数
     * @return HttpResponse
     */
    private Map<String, String> getRequestParams(Map<String, String> map) {
        // 公共请求参数
        Map<String, String> request = new HashMap<>();
        request.put("mch_id", getInitConfig().getMchId());
        request.put("version", getInitConfig().getVersion());

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        request.put("timestamp", dateFormat.format(new Date()));
        request.put("sign_type", "md5");
        request.put("charset", "utf-8");
        request.put("format", "json");

        // 请求参数
        request.put("biz_content", JSON.toJSONString(map));

        // 签名
        request.put("sign", MD5.sign(request, getInitConfig().getSecret()));
        return request;
    }
}
