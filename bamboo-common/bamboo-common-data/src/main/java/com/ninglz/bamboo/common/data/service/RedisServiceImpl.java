package com.ninglz.bamboo.common.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Program: bamboo
 * @Description: redis基本操作实现
 * @Author: lz.ning
 * @Email: ninglz@yeah.net
 * @Date: 2018-04-18 11:44
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private ValueOperations<String, Object> valueOperations;

    private void initOperations() {
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void put(String key, Object value) {
        initOperations();
        valueOperations.set(key, value);
    }

    @Override
    public void put(String key, Object value, Long time) {
        initOperations();
        valueOperations.set(key, value, time, TimeUnit.MINUTES);

    }

    @Override
    public Boolean putIfAbsent(String key, Object value) {
        initOperations();
        return valueOperations.setIfAbsent(key, value);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Boolean hasKey(String key) {
        return null;
    }

    @Override
    public Object get(String key) {
        initOperations();
        return valueOperations.get(key);

    }

    @Override
    public Long size(String key) {
        initOperations();
        return valueOperations.size(key);
    }

}
