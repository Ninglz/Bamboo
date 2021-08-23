/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */

package com.ninglz.bamboo.upms.sysLog;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ninglz.bamboo.upms.api.SysLogServiceI;
import com.ninglz.bamboo.upms.domain.log.SysLog;
import com.ninglz.bamboo.upms.domain.log.gateway.SysLogGateway;
import com.ninglz.bamboo.upms.dto.SysLogAddCmd;
import com.ninglz.bamboo.upms.dto.SysLogQry;
import com.ninglz.bamboo.upms.sysLog.executor.SysLogAddCmdExe;
import com.ninglz.bamboo.upms.sysLog.executor.SysLogUpdateCmdExe;
import com.ninglz.bamboo.upms.sysLog.executor.query.SysLogQryExe;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author lengleng
 * @since 2017-11-20
 */
@Service
public class SysLogServiceImpl implements SysLogServiceI {

	@Resource
	private SysLogAddCmdExe sysLogAddCmdExe;
	@Resource
	private SysLogUpdateCmdExe sysLogUpdateCmdExe;
	@Resource
	private SysLogQryExe sysLogQryExe;
	@Resource
	private SysLogGateway sysLogGateway;

	/**
	 * 批量插入前端错误日志
	 * @param preLogVoList 日志信息
	 * @return true/false
	 */
	@Override
	public Boolean saveBatchLogs(List<SysLogAddCmd> preLogVoList) {
		return sysLogAddCmdExe.executeBatch(preLogVoList);

	}

	@Override
	public Page getLogByPage(Page page, SysLogQry sysLog) {
		return sysLogQryExe.execute(page,sysLog);
	}

	/**
	 * 插入日志
	 * @param sysLogAddCmd 日志对象
	 * @return true/false
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean saveLog(SysLogAddCmd sysLogAddCmd) {
		return sysLogAddCmdExe.execute(sysLogAddCmd);

	}

}
