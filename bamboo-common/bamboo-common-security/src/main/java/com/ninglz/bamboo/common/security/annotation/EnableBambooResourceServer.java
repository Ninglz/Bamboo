/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.ninglz.bamboo.common.security.annotation;

import com.ninglz.bamboo.common.security.config.BambooResourceServerAutoConfiguration;
import com.ninglz.bamboo.common.security.support.BambooSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @author lengleng
 * @date 2018/11/10
 * <p>
 * 资源服务注解
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({ BambooResourceServerAutoConfiguration.class, BambooSecurityBeanDefinitionRegistrar.class })
public @interface EnableBambooResourceServer {

	/**
	 * 是否开启本地模式
	 * @return true
	 * 1. 绩效工资占比很高， 超过50%，
	 * 2. 绩效考核，实际考核标准
	 * 3. 公司福利，除了五险一金、餐补，交通补助等，  还有其他的吗 比如项目奖金或年底双薪等 其他
	 * 4. 这几天老板没在， 我需要跟他面谈在确认下入职时间。
	 */
	boolean isLocal() default true;

}
