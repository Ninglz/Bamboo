package com.ninglz.bamboo.upms.sysLog;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ninglz.bamboo.common.data.datascope.BambooBaseDO;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;


/**
 * @description: 系统日志表对象 Sys_log
 * @author ninglz
 */
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@ApiModel(value = "日志")
@TableName("sys_log")
public class SysLogDO extends BambooBaseDO<SysLogDO> {

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

}

