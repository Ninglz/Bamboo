package com.ninglz.bamboo.common.log.annotation;

import java.lang.annotation.*;

/**
 * @program: bamboo
 * @description: 系统日志注解
 * @author: ninglz
 * @created: 2021/07/27 19:28
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 日志内容
     * @return
     */
    String value();
}
