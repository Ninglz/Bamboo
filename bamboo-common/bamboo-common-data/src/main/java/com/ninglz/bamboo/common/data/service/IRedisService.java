package com.ninglz.bamboo.common.data.service;

/**
 * @Program: bamboo
 * @Description: redis基本操作
 * @Author: lz.ning
 * @Email: ninglz@yeah.net
 * @Date: 2018-04-18 11:24
 */
public interface IRedisService {

    /**
     * 更新redis数据
     * @param key
     * @param value
     */
	void put(String key, Object value);

    /**
     * 更新redis数据
     * @param key
     * @param value
     * @param time 过期时间
     */
    void put(String key, Object value, Long time);

    /**
     * 判断数据是否存在
     * @param key
     * @param value
     * @return
     */
    Boolean putIfAbsent(String key, Object value);

    /**
     * 移除reids数据
     * @param key
     */
    void remove(String key);

    /**
     * 判断redis数据
     * @param key
     */
    Boolean hasKey(String key);

    /**
     * 获取reids数据
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 判断长度
     * @param key
     * @return
     */
    Long size(String key);
}
