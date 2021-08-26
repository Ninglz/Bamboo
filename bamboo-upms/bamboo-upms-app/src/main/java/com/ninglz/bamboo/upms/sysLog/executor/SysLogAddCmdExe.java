package com.ninglz.bamboo.upms.sysLog.executor;

import com.ninglz.bamboo.common.core.constant.CommonConstants;
import com.ninglz.bamboo.common.data.tenant.TenantBroker;
import com.ninglz.bamboo.common.data.tenant.TenantContextHolder;
import com.ninglz.bamboo.upms.domain.sysLog.SysLog;
import com.ninglz.bamboo.upms.domain.sysLog.gateway.SysLogGateway;
import com.ninglz.bamboo.upms.dto.SysLogAddCmd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ninglz
 */
@Slf4j
@Component
public class SysLogAddCmdExe  {

    @Resource
    private SysLogGateway sysLogGateway;

    public Boolean execute(SysLogAddCmd sysLogAddCmd) {
        TenantBroker.applyAs(sysLogAddCmd::getTenantId, tenantId -> {
            TenantContextHolder.setTenantId(tenantId);
            SysLog log = new SysLog();
            BeanUtils.copyProperties(sysLogAddCmd, log, "createTime");
            return sysLogGateway.save(log);
        });
        return Boolean.TRUE;
    }

    public Boolean executeBatch(List<SysLogAddCmd> logAddCmdList) {
        List<SysLog> sysLogs = logAddCmdList.stream().map(addCmd -> {
            SysLog log = new SysLog();
            BeanUtils.copyProperties(addCmd, log, "createTime");
            log.setType(CommonConstants.STATUS_LOCK);
            log.setCreateTime(LocalDateTime.now());
            return log;
        }).collect(Collectors.toList());
        return sysLogGateway.saveBatch(sysLogs);
    }
}
