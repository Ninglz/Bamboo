package com.ninglz.bamboo.upms.sysLog;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ninglz.bamboo.upms.domain.log.gateway.SysLogGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysLogGatewayImpl implements SysLogGateway {

    @Autowired
    SysLogMapper logMapper;


}
