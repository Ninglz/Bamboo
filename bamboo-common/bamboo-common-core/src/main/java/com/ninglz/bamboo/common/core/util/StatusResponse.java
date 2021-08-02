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

package com.ninglz.bamboo.common.core.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 统一API响应结果封装
 * @author ninglz 2018-03-06
 */
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
public class StatusResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("c")
	@ApiModelProperty(value = "返回标记：成功标记=200")
	private int code;

	@JsonProperty("m")
	@ApiModelProperty(value = "返回信息")
	private String message;

	@JsonProperty("d")
	@ApiModelProperty(value = "数据")
	private Object data;


	private static final StatusResponse EMPTY_SUCCESS = of(ResultCode.SUCCESS);
	private static final StatusResponse ERR_UNDEFINED = of(ResultCode.UNDEFINED);

	public static StatusResponse of(
			int code,
			String message,
			Object data) {
		return new StatusResponse(code, message, data);
	}

	public static StatusResponse of(
			ResultCode code) {
		return new StatusResponse(code.getCode(), code.getMessage(), null);
	}

	public static StatusResponse of(
			ResultCode code,
			Object data) {
		return new StatusResponse(code.getCode(), code.getMessage(), data);
	}

	public static StatusResponse success() {
		return EMPTY_SUCCESS;
	}
	public static StatusResponse success(Object data) {
		return of(ResultCode.SUCCESS, data);
	}
	public static StatusResponse success(String message, Object data) {
		return of(ResultCode.SUCCESS.getCode(), message, data);
	}

	public static StatusResponse error(int code, String message) {
		return of(code, message, null);
	}

	public static StatusResponse error(ResultCode code) {
		return of(code);
	}

	public static StatusResponse undefined() {
		return ERR_UNDEFINED;
	}





}
