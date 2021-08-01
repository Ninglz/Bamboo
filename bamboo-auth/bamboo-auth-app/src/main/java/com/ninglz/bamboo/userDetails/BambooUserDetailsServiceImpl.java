package com.ninglz.bamboo.userDetails;

import com.ninglz.bamboo.api.BambooUserDetailsService;
import com.ninglz.bamboo.common.core.constant.CacheConstants;
import com.ninglz.bamboo.domain.user.BambooSecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @program: bamboo
 * @description: UserDetails实现类
 * @author: ninglz
 * @created: 2021/07/27 22:21
 */
@Service
@RequiredArgsConstructor
public class BambooUserDetailsServiceImpl implements BambooUserDetailsService {

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
        return new BambooSecurityUser(1,1,1,"110",
                "","110","111",true,true,
                true,true,null);
    }
}
