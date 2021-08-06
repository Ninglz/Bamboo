package com.ninglz.bamboo.upms.log;

import com.ninglz.bamboo.upms.domain.customer.Credit;
import com.ninglz.bamboo.upms.domain.log.gateway.SysLogGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class SysLogGatewayImpl implements SysLogGateway {

    @Autowired
    SysLogMapper logMapper;

}
