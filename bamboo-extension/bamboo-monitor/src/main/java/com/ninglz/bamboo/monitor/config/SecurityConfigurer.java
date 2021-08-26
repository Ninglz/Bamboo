package com.ninglz.bamboo.monitor.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * Spring Security安全配置
 * 开启Spring Boot Admin 的登录功能
 * @author ninglz
 */
@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	private final String adminContextPath;

	public SecurityConfigurer(AdminServerProperties adminServerProperties) {
		this.adminContextPath = adminServerProperties.getContextPath();
	}

	@SneakyThrows
	@Override
	protected void configure(HttpSecurity http) {
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter("redirectTo");
		successHandler.setDefaultTargetUrl(adminContextPath + "/");

		http
				// 忽略 options 校验
				.headers().frameOptions().disable()
				.and()
				.authorizeRequests()
				// 配置所有静态资源和登录页可以公开访问，以及忽略这些路径的csrf保护以便admin-client注册
				.antMatchers(adminContextPath + "/assets/**"
				,adminContextPath + "/login"
				, adminContextPath + "/actuator/**"
				, adminContextPath + "/instances/**"
				, adminContextPath + "/redis/info").permitAll()
				.anyRequest().authenticated()
				.and()
				// 配置登录和登出路径
				.formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler)
				.and()
				.logout().logoutUrl(adminContextPath + "/logout")
				.and()
				// 开启http basic支持，admin-client注册时需要使用
				.httpBasic()
				.and()
				.csrf().disable();
	}

}
