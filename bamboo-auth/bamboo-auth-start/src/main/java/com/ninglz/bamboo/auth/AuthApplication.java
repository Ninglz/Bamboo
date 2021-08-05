package com.ninglz.bamboo.auth;

import com.ninglz.bamboo.common.feign.annotation.EnableBambooFeignClients;
import com.ninglz.bamboo.commoon.knife.annotation.EnableBambooKnife;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@EnableBambooKnife
@SpringBootApplication(scanBasePackages = {"com.ninglz.bamboo","com.alibaba.cola"})
//@MapperScan("com.ninglz.bamboo.customer")
@EnableBambooFeignClients
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
