package com.ninglz.bamboo.upms.web;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.RSA;
import com.ninglz.bamboo.common.core.constant.SecurityConstants;
import com.ninglz.bamboo.common.core.util.StatusResponse;
import com.ninglz.bamboo.common.data.service.IRedisService;
import com.ninglz.bamboo.common.log.annotation.SysLog;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;

/**
 * @author ninglz
 */
@RestController
@RequiredArgsConstructor
public class UpmsController {

    private final IRedisService redisService;

    @SysLog("获取公钥")
    @GetMapping(value = "/publicKey")
    public StatusResponse getPublicKey(){
        if(Boolean.TRUE.equals(redisService.hasKey(SecurityConstants.RSA_PUBLIC_KEY))){
            return StatusResponse.success(redisService.get(SecurityConstants.RSA_PUBLIC_KEY));
        }
        RSA rsa = new RSA();
        String privateKey = rsa.getPrivateKeyBase64();
        String publicKey = rsa.getPublicKeyBase64();
        redisService.put(SecurityConstants.RSA_PRIVATE_KEY,privateKey);
        redisService.put(SecurityConstants.RSA_PUBLIC_KEY,publicKey);
        return StatusResponse.success(publicKey);
    }


}
