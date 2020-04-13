package com.xiong.shop.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
@Component
public class JwtUtil {

    @Value("${jwt.tokenKey}")
    private String tokenKey;

    /**
     * 生成token
     *
     * @param username
     * @return
     */
    public String generaterToken(String username) {
        // 设置秘钥和算法
        Algorithm algorithm = Algorithm.HMAC256(tokenKey);
        // 设置超时时间
        Date date = new Date(System.currentTimeMillis() + 3600 * 1000);
        // 创建token
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(date)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }

    /**
     * 验证token
     *
     * @param username
     * @param jwt
     * @throws JWTVerificationException
     */
    public void verifyToken(String username, DecodedJWT jwt) throws JWTVerificationException {
        // 设置秘钥和算法
        Algorithm algorithm = Algorithm.HMAC256(tokenKey);
        // JWT验证token类
        JWTVerifier verifier = JWT.require(algorithm)
                .withSubject(username)
                .build();
        // 验证token
        verifier.verify(jwt.getToken());
    }
}
