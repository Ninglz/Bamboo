package com.ninglz.bamboo.userDetails;

import com.ninglz.bamboo.api.BambooUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BambooUserDetailsServiceImpl implements BambooUserDetailsService {
    @Override
    public UserDetails loadUserBySocial(String type) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
