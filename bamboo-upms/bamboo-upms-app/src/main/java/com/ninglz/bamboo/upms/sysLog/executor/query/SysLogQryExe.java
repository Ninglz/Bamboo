package com.ninglz.bamboo.upms.sysLog.executor.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ninglz.bamboo.upms.domain.sysLog.gateway.SysLogGateway;
import com.ninglz.bamboo.upms.dto.SysLogQry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 日志 查询执行器
 * </p>
 *
 * @author ninglz
 * @since 2021-11-20
 */
@Slf4j
@Component
public class SysLogQryExe {

	@Resource
	private SysLogGateway sysLogGateway;

    public Page execute(Page page, SysLogQry sysLog) {


//		return sysLogGateway.selectPage(page, sysLog);
		return null;
    }
}
