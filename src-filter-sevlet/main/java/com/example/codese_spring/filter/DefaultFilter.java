package com.example.codese_spring.filter;


import com.example.codese_spring.constant.Constant;
import com.example.codese_spring.dto.InvalidTokenDto;
import com.example.codese_spring.helper.Jwt.Jwt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
@Order(1)
public class DefaultFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Default filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");

        // exception handler không có tác dụng trong filter
        try {
            String userId = Jwt.verifyToken(token, Constant.SECRET_KEY);
            request.setAttribute("user_id", userId);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            response.setStatus(401);
            response.setContentType("application/json");
            InvalidTokenDto invalidTokenDto = new InvalidTokenDto("Invalid token");
            OutputStream out = response.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out,invalidTokenDto);
            out.flush();
        }
    }

    @Override
    public void destroy() {
        System.out.println("Default filter destroy");
    }
}

// A => Controller