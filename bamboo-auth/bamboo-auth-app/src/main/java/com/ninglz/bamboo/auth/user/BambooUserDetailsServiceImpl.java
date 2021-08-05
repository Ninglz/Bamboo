package com.ninglz.bamboo.auth.user;

import com.ninglz.bamboo.auth.api.IBambooUserDetailsService;
import com.ninglz.bamboo.common.core.constant.CacheConstants;
import com.ninglz.bamboo.common.security.support.BambooSecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @program: bamboo
 * @description: UserDetails实现类
 * @author: ninglz
 * @created: 2021/07/27 22:21
 */
@Service
@RequiredArgsConstructor
public class BambooUserDetailsServiceImpl implements IBambooUserDetailsService {

    private final CacheManager cacheManager;

    @Override
    public UserDetails loadUserBySocial(String type) throws UsernameNotFoundException {

        return new BambooSecurityUser(1,1,1,"110",
                "","110","111",true,true,
                true,true,null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cache cache = cacheManager.getCache(CacheConstants.USER_DETAILS);
        if (cache != null && cache.get(username) != null) {
            return cache.get(username, BambooSecurityUser.class);
        }
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList("guest");
        return new BambooSecurityUser(1,1,1,"110",
                "","user","{noop}user",true,true,
                true,true,authorities);
    }
}
