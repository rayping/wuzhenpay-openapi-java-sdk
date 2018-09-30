package com.wuzhenpay;

import com.wuzhenpay.common.WZPOException;
import com.wuzhenpay.config.InitConfig;
import com.wuzhenpay.http.HttpResponse;
import com.wuzhenpay.trade.Application;
import com.wuzhenpay.trade.model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            // 初始化配置
            InitConfig initConfig = new InitConfig();
            initConfig.setMchId("1003000001");
            initConfig.setSecret("4d8614d60f86319432e2a9b27ef363ff");
            initConfig.setUseHTTPS(true);
            initConfig.setUseDev(false);

            // 初始化
            Application client = new Application(initConfig);

            // 请求支付参数
            TradePay tradePay = new TradePay();
            tradePay.setTotalFee("0.02");
            tradePay.setSubject("收单测试");
            tradePay.setOutTradeNo("201809300005");
            tradePay.setPayType("pay.alipay.code");
            tradePay.setAuthCode("284402457520020947");
            tradePay.setBuyerId("2088402339754365");
            tradePay.setOpenid("o2ry2jl9FZbKMk6YEgkIaZhL01tU");
//            tradePay.setSubAppid("wx8763f524cc07907e");

            // 开始请求
            HttpResponse httpResponse = client.pay(tradePay);

            // 请求查询
//            TradeQuery tradeQuery = new TradeQuery();
//            tradeQuery.setOutTradeNo("2018008220001");
//            HttpResponse httpResponse = client.query(tradeQuery);

            // 请求退款
//            TradeRefund tradeRefund = new TradeRefund();
//            tradeRefund.setOutTradeNo("2018008220001");
//            tradeRefund.setOutRefundNo("T20180001");
//            tradeRefund.setRefundFee("1.2");
//            tradeRefund.setReason("退款原因");
//            HttpResponse httpResponse = client.refund(tradeRefund);


            // 请求关单
//            TradeClose tradeClose = new TradeClose();
//            tradeClose.setOutTradeNo("2018008220001");
//            HttpResponse httpResponse = client.close(tradeClose);

            // 请求撤销订单，主要用于pay.xxx.code条码支付不明确的情况
//            TradeReverse tradeReverse = new TradeReverse();
//            tradeReverse.setOutTradeNo("2018008220001");
//            HttpResponse httpResponse = client.reverse(tradeReverse);

            System.out.println("返回的业务数据：" + httpResponse.getBizContent());
        } catch (WZPOException e) {
            System.out.println("请求错误：" + e.getMessage());
        }
    }
}
