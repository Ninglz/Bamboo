package com.ninglz.bamboo.upms;

import com.ninglz.bamboo.common.feign.annotation.EnableBambooFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"com.ninglz.bamboo","com.alibaba.cola"})
//@EnableBambooKnife
@EnableDiscoveryClient
//@EnableFeignClients
@EnableBambooFeignClients
public class UpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpmsApplication.class, args);
    }
}
