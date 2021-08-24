package com.ninglz.bamboo.upms.domain.log.gateway;

import com.ninglz.bamboo.upms.domain.log.SysLog;

import java.io.Serializable;
import java.util.List;

/**
 * @description: SysLog网关
 * @author ninglz
 */
public interface SysLogGateway {


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
