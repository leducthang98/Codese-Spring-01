package com.example.shopee.helper.jwt_decoder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;

public class JwtUtil {

    @Value("${app.setting.jwt-secret}")
    static String SECRET;

    static long TIME_EXPIRED = 604800000L;

    public static String generateToken(int userId) {
        Date now = new Date();
        Date expiredTime = new Date(now.getTime() + TIME_EXPIRED);
        String token = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(now)
                .setExpiration(expiredTime)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return token;
    }

    public static String verifyToken(String token) {
        Claims data = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                .parseClaimsJws(token).getBody();
        return data.getSubject();
    }
}
