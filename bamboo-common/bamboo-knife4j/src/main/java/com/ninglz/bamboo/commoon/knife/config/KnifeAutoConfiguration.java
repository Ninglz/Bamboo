package com.ninglz.bamboo.commoon.knife.config;

import com.ninglz.bamboo.commoon.knife.support.KnifeProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @program: bamboo
 * @description: knife自动配置，knife 基于swagger2 增强，
 * 配置knife 实际就是配置 swagger2
 * @author: ninglz
 * @created: 2021/07/23 15:02
 */
@Configuration
@ConditionalOnProperty(name = "knife.active", matchIfMissing = true)
public class KnifeAutoConfiguration {

    //api接口包扫描路径
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.ninglz";

    public static final String VERSION = "1.0.0";

    private final KnifeProperties knifeProperties;


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("单词计数服务")
                // 设置文档的描述
                .description("单词计数服务 API 接口文档")
                // 设置文档的版本信息-> 1.0.0 Version information
                .version(VERSION)
                // 设置文档的License信息->1.3 License information
                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }
}

