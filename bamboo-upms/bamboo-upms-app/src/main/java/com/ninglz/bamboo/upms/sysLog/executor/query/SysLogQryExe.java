package com.ninglz.bamboo.upms.sysLog.executor.query;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ninglz.bamboo.upms.domain.log.SysLog;
import com.ninglz.bamboo.upms.dto.SysLogQry;
import com.ninglz.bamboo.upms.sysLog.SysLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
public class SysLogQryExe extends ServiceImpl<SysLogMapper, SysLog> {

    public Page execute(Page page, SysLogQry sysLog) {
        LambdaQueryWrapper<SysLog> wrapper = Wrappers.lambdaQuery();
		if (StrUtil.isNotBlank(sysLog.getType())) {
			wrapper.eq(SysLog::getType, sysLog.getType());
		}

		if (ArrayUtil.isNotEmpty(sysLog.getCreateTime())) {
			wrapper.ge(SysLog::getCreateTime, sysLog.getCreateTime()[0]).le(SysLog::getCreateTime,
					sysLog.getCreateTime()[1]);
		}

		return baseMapper.selectPage(page, wrapper);
    }
}
