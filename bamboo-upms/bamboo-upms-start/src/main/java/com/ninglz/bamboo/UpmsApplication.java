package com.ninglz.bamboo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"com.ninglz.bamboo","com.alibaba.cola"})
@MapperScan("com.ninglz.bamboo.customer")
public class UpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpmsApplication.class, args);
    }
}
