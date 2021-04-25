package com.example.shopee.controller;

import com.example.shopee.dto.LoginResponseDto;
import com.example.shopee.model.Account;
import com.example.shopee.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    //    public LoginResponseDto login(@RequestBody String email, @RequestBody String password){

    //    }

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/demo-redis-set")
    public String setRedis(@RequestParam String username) {
        System.out.println("username:" + username);
        redisTemplate.opsForValue().set("test_name", username);
        String usernameGet = (String) redisTemplate.opsForValue().get("test_name");
        return usernameGet;
    }

    @GetMapping("/demo-redis-set-object")
    public List<Session> setObjectRedis() {
        ArrayList<Session> sessions = new ArrayList<>();
        sessions.add(new Session("asd1", "asd", new Account()));
        sessions.add(new Session("asd2", "asd", new Account()));
        sessions.add(new Session("asd3", "asd", new Account()));
        sessions.add(new Session("asd4", "asd", new Account()));
        redisTemplate.opsForValue().set("sessions", sessions);
        List<Session> sessionsGetFromRedis = (List<Session>) redisTemplate.opsForValue().get("sessions");
        return sessionsGetFromRedis;
    }

}
