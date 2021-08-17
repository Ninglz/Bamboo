package com.ninglz.bamboo.upms.sysLog.executor;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ninglz.bamboo.common.core.constant.CommonConstants;
import com.ninglz.bamboo.common.data.tenant.TenantBroker;
import com.ninglz.bamboo.common.data.tenant.TenantContextHolder;
import com.ninglz.bamboo.upms.domain.log.SysLog;
import com.ninglz.bamboo.upms.dto.SysLogAddCmd;
import com.ninglz.bamboo.upms.sysLog.SysLogMapper;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ninglz
 */
public class SysLogAddCmdExe extends ServiceImpl<SysLogMapper, SysLog> {

    public Boolean execute(SysLogAddCmd sysLogAddCmd) {
        TenantBroker.applyAs(sysLogAddCmd::getTenantId, tenantId -> {
            TenantContextHolder.setTenantId(tenantId);
            SysLog log = new SysLog();
            BeanUtils.copyProperties(sysLogAddCmd, log, "createTime");
            return baseMapper.insert(log);
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
        return this.saveBatch(sysLogs);
    }
}
