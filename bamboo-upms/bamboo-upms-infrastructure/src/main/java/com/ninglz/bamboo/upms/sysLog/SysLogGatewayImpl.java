package com.ninglz.bamboo.upms.sysLog;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ninglz.bamboo.upms.domain.log.SysLog;
import com.ninglz.bamboo.upms.domain.log.gateway.SysLogGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SysLogGatewayImpl extends ServiceImpl<SysLogMapper, SysLog>  implements SysLogGateway {

//    @Autowired
//    SysLogMapper logMapper;


}
