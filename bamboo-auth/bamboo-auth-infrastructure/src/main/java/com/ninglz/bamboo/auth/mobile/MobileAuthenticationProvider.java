package com.ninglz.bamboo.auth.mobile;

import com.ninglz.bamboo.auth.api.IBambooUserDetailsService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @program: bamboo
 * @description: 指定的认证
 * @author: ninglz
 * @created: 2021/07/27 21:51
 */
@Slf4j
public class MobileAuthenticationProvider implements AuthenticationProvider {

    @Setter
    private IBambooUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MobileAuthenticationToken mobileAuthenticationToken = (MobileAuthenticationToken) authentication;

        String principal = mobileAuthenticationToken.getPrincipal().toString();
        UserDetails userDetails = userDetailsService.loadUserBySocial(principal);
        if (userDetails == null) {
            log.debug("Authentication failed: no credentials provided");

            throw new RuntimeException();
//            throw new BadCredentialsException(messages
//                    .getMessage("AbstractUserDetailsAuthenticationProvider.noopBindAccount", "Noop Bind Account"));
        }

        // 检查账号状态
        check(userDetails);

        MobileAuthenticationToken authenticationToken = new MobileAuthenticationToken(userDetails,
                userDetails.getAuthorities());
        authenticationToken.setDetails(mobileAuthenticationToken.getDetails());
        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 判断是否属于同一个类或者超类
        return MobileAuthenticationToken.class.isAssignableFrom(authentication);
    }


    public void check(UserDetails user) {
        if (!user.isAccountNonLocked()) {
            log.debug("User account is locked");

            throw new LockedException(
                  "AbstractUserDetailsAuthenticationProvider.locked");
        }

        if (!user.isEnabled()) {
            log.debug("User account is disabled");

            throw new DisabledException(
                    "AbstractUserDetailsAuthenticationProvider.disabled");
        }

        if (!user.isAccountNonExpired()) {
            log.debug("User account is expired");

            throw new AccountExpiredException("User account has expired");
        }
    }
}
