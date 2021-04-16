package com.wangrui.mybatisplus.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    private static final String key = "userLogin";
    private static final Long failureTime = 3600000l;
    private static final Long failureTime_remeber = 36000000l;
    private static final String SECRET = "jwtsecret";
    private static final String ISS = "wangrui";

    /**
     * 设置认证token
     * @return
     */
    public static String createJwt(String userName, boolean isRemeberMe) {
        long expiration = isRemeberMe ? failureTime_remeber : failureTime;
        String token=Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,SECRET)
                .setIssuer(ISS)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration*1000))
                .compact();
        return token;
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static String getUserName(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}
