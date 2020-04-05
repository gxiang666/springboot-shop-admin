package com.xiong.shop.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
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
        Algorithm algorithm = Algorithm.HMAC256(tokenKey);
        Date date = new Date(System.currentTimeMillis() + 3600 * 1000);
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
     * @return
     */
    public String verifyToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256(tokenKey);
        Date date = new Date(System.currentTimeMillis() + 3600 * 1000);
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(date)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }
}
