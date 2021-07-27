package com.ninglz.bamboo.api;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @program: bamboo
 * @description: 扩展用户登录方式
 * @author: ninglz
 * @created: 2021/07/27 22:11
 */
public interface BambooUserDetailsService extends UserDetailsService {

    /**
     * 根据社交登录类型 登录
     * @param type 社交登录类型
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    UserDetails loadUserBySocial(String type) throws UsernameNotFoundException;
}
