package com.ninglz.bamboo.gateway.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: bamboo
 * @description: 测试
 * @author: ninglz
 * @created: 2021/07/27 16:13
 */
@RestController
public class TestController {

    @GetMapping(value ="/test")
    public String hello(){
        return "hello world";
    }
}

