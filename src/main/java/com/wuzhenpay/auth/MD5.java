package com.wuzhenpay.auth;

import com.wuzhenpay.util.StringUtil;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by steve on 2018/5/15
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class MD5 {
    /**
     * 签名
     * @param params 需要签名的参数
     * @param openKey 密钥
     * @return string
     */
    public static String sign(Map<String, String> params, String secret) {
        String str = "";

        List<String> keys = new ArrayList<>(params.keySet());
        keys.remove("sign");
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            if (!StringUtil.isEmpty(params.get(key))) {
                sb.append(key).append("=").append(params.get(key)).append("&");
            }
        }

        String linkString = sb.toString();

        // 拼接openKey
        linkString = linkString + "secret=" + secret;
        String md5 = encrypt(linkString);
        return md5;
    }

    /**
     * 验签
     * @param sign 需要验签的签名
     * @param params 需要签名的参数
     * @param secret 密钥
     * @return bool
     */
    public static boolean verify(String sign, Map<String, String> params, String secret) {
        return (sign.equals(sign(params, secret)));
    }

    /**
     * md5加密
     * @param info 需要加密的信息
     * @return string
     */
    public static String encrypt(String info) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(info.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : result) {
                int number = b & 0xff;
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(str);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}

