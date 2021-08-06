package com.ninglz.bamboo.upms.domain.log.gateway;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface SysLogGateway {

    /**
     * 批量插入前端错误日志
     * @param preLogVoList 日志信息
     * @return true/false
     */
    Boolean saveBatchLogs(List<PreLogVO> preLogVoList);

    /**
     * 分页查询日志
     * @param page
     * @param sysLog
     * @return
     */
    Page selectPage(Page page, SysLogDTO sysLog);

    /**
     * 插入日志
     * @param sysLog 日志对象
     * @return true/false
     */
    Boolean save(SysLogDTO sysLog);

}
