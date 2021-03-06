package com.doulin.common.token;

import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @className SysUserTokenUtil
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/24 16:42
 * @Version 1.0
 */
public class SysUserTokenUtil {
    private static final String secret = "secret";
    public static final String tokenHeard = "account_token";
    public static final String accountNo = "account_no";
    private static final Long expTime = 60 * 20 * 1000L;

    /**
     * 创建一个token
     * @param name
     * @param id
     * @param ip
     * @return
     */
    public static String getToken(String name,String id,String ip) {
        JwtBuilder builder = Jwts.builder();
        builder.signWith(SignatureAlgorithm.HS256,secret);
        builder.setId(id).setSubject(name).setAudience(ip);
        builder.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expTime));
        String token = builder.compact();
        return token;
    }

    public static Claims getTokenBody(String token) {
        JwtParser parser = Jwts.parser();
        Claims body = parser.setSigningKey(secret).parseClaimsJws(token).getBody();
        return body;
    }

    public static String getName(String token) throws Exception {
        try {
            Claims body = getTokenBody(token);
            String id = body.getId();
            return id;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
