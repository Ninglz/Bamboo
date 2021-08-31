package com.ninglz.bamboo.upms.domain.sysLog.gateway;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ninglz.bamboo.upms.domain.sysLog.SysLog;

import java.io.Serializable;
import java.util.List;

/**
 * SysLog网关
 * @author ninglz
 */
public interface SysLogGateway{


    /**
     * 保存
     * @param sysLog 领域对象
     * @return boolean
     */
    boolean save(SysLog sysLog);

    /**
     * 批量报错
     * @param sysLogs 领域对象集合
     * @return boolean
     */
    boolean saveBatch(List<SysLog> sysLogs);

    /**
     * 删除
     * @param id 主键
     * @return boolean
     */
    boolean remove(Serializable id);

}
