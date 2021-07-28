package com.ninglz.bamboo.common.mobile;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: bamboo
 * @description: 认证处理过程
 * @author: ninglz
 * @created: 2021/07/27 21:51
 */
public class MobileAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    public MobileAuthenticationFilter() {
        super(new AntPathRequestMatcher("/mobile/token/*", "POST"));
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        return null;
    }
}
