package com.ninglz.bamboo.userDetails;

import com.ninglz.bamboo.api.BambooUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @program: bamboo
 * @description: 实现类
 * @author: ninglz
 * @created: 2021/07/27 22:21
 */
@Service
public class BambooUserDetailsServiceImpl implements BambooUserDetailsService {
    @Override
    public UserDetails loadUserBySocial(String type) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
