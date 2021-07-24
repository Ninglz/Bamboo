package com.ninglz.bamboo.gateway;

import com.ninglz.bamboo.commoon.knife.annotation.EnableBambooKnife;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: bamboo
 * @description: 网关
 * @author: ninglz
 * @created: 2021/07/24 11:51
 */
@EnableDiscoveryClient
@SpringBootApplication()
@EnableBambooKnife
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
