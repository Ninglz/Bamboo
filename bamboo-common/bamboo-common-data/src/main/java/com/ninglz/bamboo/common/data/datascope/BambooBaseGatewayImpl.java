package com.ninglz.bamboo.common.data.datascope;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 继承mybatis-plus的IService
 * @param <T>
 */
public class BambooBaseGatewayImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BambooBaseGateway<T> {
    @Override
    protected Class<T> currentMapperClass() {
        return super.currentMapperClass();
    }
}
