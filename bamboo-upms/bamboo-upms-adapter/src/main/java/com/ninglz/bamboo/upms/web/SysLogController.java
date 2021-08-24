package com.ninglz.bamboo.upms.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ninglz.bamboo.common.core.util.StatusResponse;
import com.ninglz.bamboo.common.security.annotation.Auth;
import com.ninglz.bamboo.upms.api.SysLogServiceI;
import com.ninglz.bamboo.upms.dto.SysLogAddCmd;
import com.ninglz.bamboo.upms.dto.SysLogQry;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/log")
@Api(value = "log", tags = "日志管理模块")
public class SysLogController {

    private final SysLogServiceI sysLogService;

    /**
     * 简单分页查询
     * @param page 分页对象
     * @param sysLog 系统日志
     * @return
     */
    @GetMapping("/page")
    public StatusResponse getLogPage(Page page, SysLogQry sysLog) {
        return StatusResponse.success(sysLogService.getLogByPage(page, sysLog));
    }

    /**
     * 删除日志
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('sys_log_del')")
    public StatusResponse removeById(@PathVariable Long id) {
        return StatusResponse.success(sysLogService.remove(id));
    }

    /**
     * 插入日志
     * @param sysLog 日志实体
     * @return success/false
     */
    @Auth
    @PostMapping("/save")
    public StatusResponse save(@Valid @RequestBody SysLogAddCmd sysLog) {
        return StatusResponse.success(sysLogService.saveLog(sysLog));
    }

    /**
     * 批量插入前端异常日志
     * @param logAddCmdList 日志实体
     * @return success/false
     */
    @PostMapping("/logs")
    public StatusResponse saveBatchLogs(@RequestBody List<SysLogAddCmd> logAddCmdList) {
        return StatusResponse.success(sysLogService.saveBatchLogs(logAddCmdList));
    }

}
