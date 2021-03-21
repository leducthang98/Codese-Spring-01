package com.example.codese_spring.helper.Jwt;

import com.example.codese_spring.constant.Constant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;

public class Jwt {
    public static String generateToken(String userId, String secretKey) {
        Date now = new Date();
        Date expiredTime = new Date(now.getTime() + Constant.JWT_EXPIRATION);

        String token = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(now)
                .setExpiration(expiredTime)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return token;
    }

    public static String verifyToken(String token, String secretKey) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
