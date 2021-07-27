package com.ninglz.bamboo.commoon.knife.annotation;

import com.ninglz.bamboo.commoon.knife.config.KnifeAutoConfiguration;
import com.ninglz.bamboo.commoon.knife.support.KnifeProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;

/**
 * @program: bamboo
 * @description:
 * @author: ninglz
 * @created: 2021/07/23 13:24
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableSwagger2
@EnableConfigurationProperties(KnifeProperties.class)
@Import({KnifeAutoConfiguration.class})
public @interface EnableBambooKnife {
}

