package com.wuzhenpay.config;

/**
 * Created by steve on 2018/5/21
 * Copyright (c) 2018 steve. All rights reserved.
 * Contact 7579476@qq.com
 */
public class InitConfig {
    /**
     * 版本号
     */
    private String version="2.0";

    /**
     * 生产环境
     * @var string
     */
    private String apiHost="openapi.wuzhenpay.com";

    /**
     * 测试环境
     * @var string
     */
    private String devApiHost = "127.0.0.1:8083";

    /**
     * 使用HTTPS
     */
    private boolean useHTTPS;

    /**
     * 使用开发者模式
     */
    private boolean useDev;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * key
     */
    private String secret;

    public String getVersion() {
        return version;
    }

    public String getApiHost() {
        return (useHTTPS ? "https" : "http") + "://" + (useDev ? devApiHost : apiHost);
    }

    public boolean isUseHTTPS() {
        return useHTTPS;
    }

    public void setUseHTTPS(boolean useHttps) {
        this.useHTTPS = useHTTPS;
    }

    public boolean isUseDev() {
        return useDev;
    }

    public void setUseDev(boolean useDev) {
        this.useDev = useDev;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
