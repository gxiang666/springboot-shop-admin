# java-jwt

## 生成token
```
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
```
## 获取token
```
private String getToken(HttpServletRequest request) {
    String authorization = request.getHeader("Authorization");
    return StringUtils.removeStart(authorization, "Bearer ");
}
```
## 验证token
```
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
```

