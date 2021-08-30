package com.ninglz.bamboo.upms.dto;

import com.alibaba.cola.dto.Command;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @program: bamboo
 * @description: 新增日志对象
 * @author: ninglz
 * @created: 2021/08/17 22:20
 */
@Data
@ApiModel(value = "新增日志对象")
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysLogAddCmd extends Command {

	/**
	 * 编号
	 */
	private Long id;

	/**
	 * 日志类型
	 */
	@NotBlank(message = "日志类型不能为空")
	private String type;

	/**
	 * 日志标题
	 */
	@NotBlank(message = "日志标题不能为空")
	private String title;

	/**
	 * 创建者
	 */
	private String createBy;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 操作IP地址
	 */
	private String remoteAddr;

	/**
	 * 用户代理
	 */
	private String userAgent;

	/**
	 * 请求URI
	 */
	private String requestUri;

	/**
	 * 操作方式
	 */
	private String method;

	/**
	 * 操作提交的数据
	 */
	private String params;

	/**
	 * 执行时间
	 */
	private Long time;

	/**
	 * 异常信息
	 */
	private String exception;

	/**
	 * 服务ID
	 */
	private String serviceId;

	/**
	 * 创建时间区间 [开始时间，结束时间]
	 */
	private LocalDateTime[] createTime;

	/**
	 * 租户编号
	 */
	private Integer tenantId;

}
