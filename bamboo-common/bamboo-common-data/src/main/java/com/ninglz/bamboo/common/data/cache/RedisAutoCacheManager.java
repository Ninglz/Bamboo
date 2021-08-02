package com.ninglz.bamboo.common.data.cache;

import cn.hutool.core.util.StrUtil;
import com.ninglz.bamboo.common.core.constant.CacheConstants;
import com.ninglz.bamboo.common.data.tenant.TenantContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.convert.DurationStyle;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.lang.Nullable;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;

/**
 * spring cache设置指定Key过期时间
 * @author ninglz
 * https://blog.csdn.net/huangdi1309/article/details/103784115
 */
@Slf4j
public class RedisAutoCacheManager extends RedisCacheManager {

    /**
     *     期时间分隔符
     */
    private static final String SEPARATOR = "#";
    /**
     *  如 cache#200s 拆成2个数组后判断len < 2
     */
    private static final int CACHE_LENGTH = 2;

    RedisAutoCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration,
                          Map<String, RedisCacheConfiguration> initialCacheConfigurations, boolean allowInFlightCacheCreation) {
        super(cacheWriter, defaultCacheConfiguration, initialCacheConfigurations, allowInFlightCacheCreation);
    }

    @Override
    protected RedisCache createRedisCache(String name, @Nullable  RedisCacheConfiguration cacheConfig) {
        if (StrUtil.isBlank(name) || name.contains(SEPARATOR)) {
            return super.createRedisCache(name, cacheConfig);
        }
        String[] cacheArray = name.split(SEPARATOR);
        if (cacheArray.length < CACHE_LENGTH) {
            return super.createRedisCache(name, cacheConfig);
        }

        if (cacheConfig != null) {
            // 转换时间，支持时间单位例如：300ms，第二个参数是默认单位
            Duration duration = DurationStyle.detectAndParse(cacheArray[1], ChronoUnit.SECONDS);
            // 设置过期时间
            cacheConfig = cacheConfig.entryTtl(duration);
        }
        return super.createRedisCache(cacheArray[0], cacheConfig);
    }

    @Override
    public Cache getCache(String name) {
        // 全局缓存 使用默认缓存
        if (name.startsWith(CacheConstants.GLOBAL)) {
            return super.getCache(name);
        }
        // 非全局则使用租户模式  tenantId:cacheName
        return super.getCache(TenantContextHolder.getTenantId() + StrUtil.COLON + name);

    }
}
