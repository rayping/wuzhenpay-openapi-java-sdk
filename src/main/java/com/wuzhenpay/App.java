package com.wuzhenpay;

import com.wuzhenpay.common.WZPOException;
import com.wuzhenpay.config.InitConfig;
import com.wuzhenpay.http.HttpResponse;
import com.wuzhenpay.trade.Application;
import com.wuzhenpay.trade.model.TradePay;

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

            // 请求参数
            TradePay tradePay = new TradePay();
            tradePay.setTotalFee("0.03");
            tradePay.setSubject("收单测试");
            tradePay.setOutTradeNo("201805210007");
            tradePay.setPayType("pay.wechat.qrcode");

            // 开始请求
            HttpResponse httpResponse = client.pay(tradePay);
            System.out.println("返回的业务数据：" + httpResponse.getBizContent());
        } catch (WZPOException e) {
            System.out.println("请求错误：" + e.getMessage());
        }
    }
}
