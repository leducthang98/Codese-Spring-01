package com.example.shopee.controller;

import com.example.shopee.model.Account;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    private Account userDetail;

    @ModelAttribute("BeforeRequest")
    public void getUserById(HttpServletRequest request) {
        System.out.println("id: 1, name: Thang");
        // B1: lay id
        // B2: lay userinfo o trong cache ra
            // 2.1: trong cache co user do
                // tra ve console
            // 2.2: trong cache khong co user do
                // lay trong db ra
                // luu vao cache
                // tra ve console
    }

    public Account getUserDetail() {
        return this.userDetail;
    }
}

