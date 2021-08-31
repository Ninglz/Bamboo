package com.ninglz.bamboo.upms.sysLog.executor.query;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ninglz.bamboo.upms.domain.sysLog.gateway.SysLogGateway;
import com.ninglz.bamboo.upms.dto.SysLogQry;
import com.ninglz.bamboo.upms.sysLog.SysLogDO;
import com.ninglz.bamboo.upms.sysLog.SysLogMapper;
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

	@Resource
	SysLogMapper logMapper;

    public Page execute(Page page, SysLogQry sysLog) {
		LambdaQueryWrapper<SysLogDO> wrapper = Wrappers.lambdaQuery();
		if (StrUtil.isNotBlank(sysLog.getType())) {
			wrapper.eq(SysLogDO::getType, sysLog.getType());
		}

		if (ArrayUtil.isNotEmpty(sysLog.getCreateTime())) {
			wrapper.ge(SysLogDO::getCreateTime, sysLog.getCreateTime()[0]).le(SysLogDO::getCreateTime,
					sysLog.getCreateTime()[1]);
		}
		return logMapper.selectPage(page, wrapper);
    }
}
