package com.example.shopee;

import io.jsonwebtoken.*;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;

@SpringBootApplication
public class ShopeeApplication {

    static String SECRET = "codedidungso.me";
    static long TIME_EXPIRED = 604800000L; // 7 days

    public static void main(String[] args) {
        SpringApplication.run(ShopeeApplication.class, args);
    }

    public static String generateToken(int userId) {
        Date now = new Date(); // hien tai
        Date expiredTime = new Date(now.getTime() + TIME_EXPIRED); // 7 ngay sau
        String token = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(now)
                .setExpiration(expiredTime)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return token;
    }
    // revoke

    public static String verifyToken(String token) {
        Claims data = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                .parseClaimsJws(token).getBody();
        return data.getSubject();
    }


//
//    public static int verifyToken(String token, String secretKey) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
//                .parseClaimsJws(token).getBody();
//        return Integer.parseInt(claims.getSubject());
//    }
    // oauth oauth2,...
    // revoke token

}

