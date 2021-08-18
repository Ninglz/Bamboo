package com.ninglz.bamboo.upms.sysLog;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ninglz.bamboo.upms.domain.log.gateway.SysLogGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysLogGatewayImpl implements SysLogGateway {

    @Autowired
    SysLogMapper logMapper;


    @Override
    public Boolean saveBatchLogs(List<PreLogVO> preLogVoList) {
        return null;
    }

    @Override
    public Page selectPage(Page page, SysLogDTO sysLog) {
        return null;
    }

    @Override
    public Boolean save(SysLogDTO sysLog) {
        return null;
    }
}
