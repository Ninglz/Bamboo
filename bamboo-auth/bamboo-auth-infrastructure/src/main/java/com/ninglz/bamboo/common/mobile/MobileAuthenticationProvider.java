package com.ninglz.bamboo.common.mobile;

import com.ninglz.bamboo.api.BambooUserDetailsService;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @program: bamboo
 * @description: 指定的认证
 * @author: ninglz
 * @created: 2021/07/27 21:51
 */
public class MobileAuthenticationProvider implements AuthenticationProvider {

    @Setter
    private BambooUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
