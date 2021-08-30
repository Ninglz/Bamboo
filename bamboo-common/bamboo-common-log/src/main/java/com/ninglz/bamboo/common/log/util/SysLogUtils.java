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

package com.ninglz.bamboo.common.log.util;

import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.ninglz.bamboo.upms.dto.SysLogAddCmd;
import com.ninglz.bamboo.upms.dto.data.SysLogDTO;
import lombok.experimental.UtilityClass;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 系统日志工具类
 *
 * @author L.cm
 */
@UtilityClass
public class SysLogUtils {

	public SysLogAddCmd getSysLog() {
		HttpServletRequest request = ((ServletRequestAttributes) Objects
				.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
		return getSysLog(request,Objects.requireNonNull("s"));
	}

	public SysLogAddCmd getSysLog(HttpServletRequest request, String username) {
		return SysLogAddCmd.builder().createBy(username)
				.type(LogTypeEnum.NORMAL.getType())
				.remoteAddr(ServletUtil.getClientIP(request))
				.requestUri(URLUtil.getPath(request.getRequestURI()))
				.method(request.getMethod())
				.userAgent(request.getHeader("user-agent"))
				.params(HttpUtil.toParams(request.getParameterMap()))
//				.serviceId(getClientId())
				.build();
	}

	/**
	 * 获取客户端
	 * @return clientId
	 */
//	private String getClientId() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication instanceof OAuth2Authentication) {
//			OAuth2Authentication auth2Authentication = (OAuth2Authentication) authentication;
//			return auth2Authentication.getOAuth2Request().getClientId();
//		}
//		return null;
//	}

	/**
	 * 获取用户名称
	 * @return username
	 */
//	private String getUsername() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication == null) {
//			return null;
//		}
//		return authentication.getName();
//	}

}
