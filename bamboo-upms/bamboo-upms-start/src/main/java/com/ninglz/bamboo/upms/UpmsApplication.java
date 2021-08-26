package com.ninglz.bamboo.upms;

import com.ninglz.bamboo.commoon.knife.annotation.EnableBambooKnife;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"com.ninglz.bamboo","com.alibaba.cola"})
@EnableBambooKnife
@EnableDiscoveryClient
public class UpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpmsApplication.class, args);
    }
}
