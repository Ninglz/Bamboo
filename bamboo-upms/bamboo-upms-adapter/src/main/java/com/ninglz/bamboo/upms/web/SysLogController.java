package com.ninglz.bamboo.upms.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ninglz.bamboo.common.core.util.StatusResponse;
import com.ninglz.bamboo.common.security.annotation.Auth;
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

    private final SysLogService sysLogService;

    /**
     * 简单分页查询
     * @param page 分页对象
     * @param sysLog 系统日志
     * @return
     */
    @GetMapping("/page")
    public StatusResponse getLogPage(Page page, SysLogDTO sysLog) {
        return R.ok(sysLogService.getLogByPage(page, sysLog));
    }

    /**
     * 删除日志
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('sys_log_del')")
    public StatusResponseremoveById(@PathVariable Long id) {
        return R.ok(sysLogService.removeById(id));
    }

    /**
     * 插入日志
     * @param sysLog 日志实体
     * @return success/false
     */
    @Auth
    @PostMapping("/save")
    public StatusResponse save(@Valid @RequestBody SysLogDTO sysLog) {
        return R.ok(sysLogService.saveLog(sysLog));
    }

    /**
     * 批量插入前端异常日志
     * @param preLogVoList 日志实体
     * @return success/false
     */
    @PostMapping("/logs")
    public StatusResponse saveBatchLogs(@RequestBody List<PreLogVO> preLogVoList) {
        return R.ok(sysLogService.saveBatchLogs(preLogVoList));
    }

}
