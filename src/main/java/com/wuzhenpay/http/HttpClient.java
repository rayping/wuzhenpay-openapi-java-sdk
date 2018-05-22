package com.wuzhenpay.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wuzhenpay.auth.MD5;
import com.wuzhenpay.common.WZPOException;
import com.wuzhenpay.config.InitConfig;
import com.wuzhenpay.util.JsonUtil;
import com.wuzhenpay.util.StringUtil;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by steve on 2018/5/21
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class HttpClient {
    /**
     * POST请求
     * @param api
     * @param params
     * @return
     */
    public static HttpResponse post(String api, Map<String, String> params, String secret) {
        InitConfig initConfig = new InitConfig();

        // System.out.println("请求的参数：" + JSON.toJSONString(params));
        // 获取请求地址
        String uri = initConfig.getApiHost() + api;

        HttpResponse httpResponse = new HttpResponse();
        try {
            OkHttpClient client = new OkHttpClient();

            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            for (String key: params.keySet()) {
                if (!StringUtil.isEmpty(params.get(key))) {
                    formBodyBuilder.add(key, params.get(key));
                }
            }

            FormBody body = formBodyBuilder.build();
            Request request = new Request.Builder()
                    .url(uri)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new WZPOException("Request error");
            }

            String responseBody = response.body().string();
            // System.out.println("Response data：" + responseBody);
            JSONObject json = JSONObject.parseObject(responseBody);

            if (!json.getInteger("code").equals(200)) {
                throw new WZPOException(json.get("message").toString());
            }

            // 获取数据
            String data = json.getString("data");
            if (!JsonUtil.isJsonObject(data)) {
                throw new WZPOException("Data error");
            }

            Map<String, String> maps = new HashMap<>();
            Map dataMap = JSONObject.parseObject(data, Map.class);
            for (Object key : dataMap.keySet()) {
                maps.put(key.toString(), dataMap.get(key).toString());
            }

            // 验签
            if (!MD5.verify(maps.get("sign"), maps, secret)) {
                throw new WZPOException("Data verify error");
            }

            httpResponse.setCode(json.getInteger("code"));
            httpResponse.setData(json.get("data"));
            httpResponse.setBizContent(JSON.parseObject(maps.get("biz_content")));
            httpResponse.setMessage(json.getString("message"));
            httpResponse.setSubCode(json.getString("sub_code"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return httpResponse;
    }
}
