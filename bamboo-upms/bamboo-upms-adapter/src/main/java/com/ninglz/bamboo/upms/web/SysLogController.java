package com.ninglz.bamboo.upms.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 日志管理模块控制器
 * @author ninglz
 */
@RestController
//@AllArgsConstructor
@RequestMapping("/log")
@Api(value = "log", tags = "日志管理模块")
public class SysLogController {
//
//    @Autowired
//    private  SysLogServiceI sysLogService;
//
//    /**
//     * 简单分页查询
//     * @param page 分页对象
//     * @param sysLog 系统日志
//     * @return
//     */
//    @GetMapping("/page")
//    public StatusResponse getLogPage(Page page, SysLogQry sysLog) {
//        return StatusResponse.success(sysLogService.getLogByPage(page, sysLog));
//    }
//
//    /**
//     * 删除日志
//     * @param id ID
//     * @return success/false
//     */
//    @DeleteMapping("/{id}")
////    @PreAuthorize("@pms.hasPermission('sys_log_del')")
//    public StatusResponse removeById(@PathVariable Long id) {
//        return StatusResponse.success(sysLogService.remove(id));
//    }
//
//    /**
//     * 插入日志
//     * @param sysLog 日志实体
//     * @return success/false
//     */
//    @Auth
//    @PostMapping("/save")
//    public StatusResponse save(@Valid @RequestBody SysLogAddCmd sysLog) {
//        return StatusResponse.success(sysLogService.saveLog(sysLog));
//    }
//
//    /**
//     * 批量插入前端异常日志
//     * @param logAddCmdList 日志实体
//     * @return success/false
//     */
//    @PostMapping("/logs")
//    public StatusResponse saveBatchLogs(@RequestBody List<SysLogAddCmd> logAddCmdList) {
//        return StatusResponse.success(sysLogService.saveBatchLogs(logAddCmdList));
//    }

}
