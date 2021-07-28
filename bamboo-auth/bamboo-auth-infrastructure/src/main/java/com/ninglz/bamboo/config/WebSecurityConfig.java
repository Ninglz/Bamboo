package com.ninglz.bamboo.config;

import com.ninglz.bamboo.common.handler.FormAuthenticationFailureHandler;
import com.ninglz.bamboo.common.handler.SsoLogoutSuccessHandler;
import com.ninglz.bamboo.common.mobile.MobileSecurityConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @program: bamboo
 * @description: 认证配置
 * @author: ninglz
 * @created: 2021/07/27 21:21
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 放行静态资源
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/favicon.ico", "/css/**", "/error");
    }

    /**
     * 允许匿名访问所有接口 主要是 oauth 接口
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/**").permitAll();
        http.formLogin()
                .loginPage("/token/login")
                .loginProcessingUrl("/token/form")
//                .successHandler(tenantSavedRequestAwareAuthenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler())
                .deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .antMatchers("/token/**", "/actuator/**", "/mobile/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // 取消csrf
                .csrf().disable()
                .apply(mobileSecurityConfigurer());
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new FormAuthenticationFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new SsoLogoutSuccessHandler();
    }

    @Bean
    public MobileSecurityConfigurer mobileSecurityConfigurer() {
        return new MobileSecurityConfigurer();
    }
}
