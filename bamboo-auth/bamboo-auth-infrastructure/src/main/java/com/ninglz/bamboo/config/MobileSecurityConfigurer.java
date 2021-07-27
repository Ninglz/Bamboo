package com.ninglz.bamboo.config;

import com.ninglz.bamboo.api.BambooUserDetailsService;
import com.ninglz.bamboo.filter.MobileAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @program: bamboo
 * @description: 认证配置
 * @author: ninglz
 * @created: 2021/07/27 21:51
 */
public class MobileSecurityConfigurer extends SecurityConfigurerAdapter {
    @Autowired
    private BambooUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler mobileLoginSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        MobileAuthenticationFilter mobileAuthenticationFilter = new MobileAuthenticationFilter();

        //设置AuthenticationManager
        mobileAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));

        //设置成功失败处理器
        mobileAuthenticationFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
//        smsCodeAuthenticationFilter.setAuthenticationFailureHandler(myAuthenticationSuccessHandler);

        //设置provider
        mobileAuthenticationFilter smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider();
        smsCodeAuthenticationProvider.setMyUserDetailsService(myUserDetailsService);

        http.authenticationProvider(mobileAuthenticationFilter)
                .addFilterAfter(mobileAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
