package com.ninglz.bamboo.gateway.config;

import com.anji.captcha.service.CaptchaCacheService;

/**
 * @program: bamboo
 * @description: 分布式多实例部署的应用,须引入外部缓存redis，使用SPI机制
 * @author: ninglz
 * @created: 2021/07/27 15:36
 */
public class CaptchaCacheServiceProvider implements CaptchaCacheService {

    private static final String REDIS = "redis";

    @Override
    public void set(String k, String v, long expireTime) {

    }

    @Override
    public boolean exists(String k) {
        return false;
    }

    @Override
    public void delete(String k) {

    }

    @Override
    public String get(String k) {
        return null;
    }

    @Override
    public String type() {
        return REDIS;
    }
}

