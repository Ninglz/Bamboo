package com.ninglz.bamboo.common.feign;

import feign.Feign;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author lengleng
 * @date 2020/2/8
 * <p>
 * feign 自动化配置
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureAfter(EnableFeignClients.class)
public class BambooFeignAutoConfiguration {

//	@Bean
//	@ConditionalOnMissingBean
//	@ConditionalOnAvailableEndpoint
//	public FeignClientEndpoint feignClientEndpoint(ApplicationContext context) {
//		return new FeignClientEndpoint(context);
//	}

}
