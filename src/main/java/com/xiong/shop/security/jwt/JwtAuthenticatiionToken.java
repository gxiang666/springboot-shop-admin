package com.xiong.shop.security.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
public class JwtAuthenticatiionToken extends AbstractAuthenticationToken {

    private Object principal;

    private DecodedJWT token;

    /**
     * 认证前
     *
     * @param token
     */
    public JwtAuthenticatiionToken(DecodedJWT token) {
        super(null);
        this.principal = null;
        this.token = token;
        setAuthenticated(false);
    }

    /**
     * 认证后
     *
     * @param principal
     * @param authorities
     */
    public JwtAuthenticatiionToken(Object principal, DecodedJWT token, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.token = token;
        // must use super, as we override
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    public DecodedJWT getToken() {
        return token;
    }

}
