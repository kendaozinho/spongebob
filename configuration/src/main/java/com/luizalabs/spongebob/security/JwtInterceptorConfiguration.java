package com.luizalabs.spongebob.security;

import com.luizalabs.spongebob.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JwtInterceptorConfiguration extends OncePerRequestFilter {
    private final String jwtSecretKey;

    public JwtInterceptorConfiguration(String jwtSecretKey) {
        this.jwtSecretKey = jwtSecretKey;
    }

    @Override
    public void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws IOException, ServletException {
        String authorization = request.getHeader("Authorization");
        authorization = (authorization == null ? "" : authorization.replace("Bearer ", ""));

        if (JwtUtil.isValidJwt(this.jwtSecretKey, authorization)) {
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(authorization, null, Collections.emptyList())
            );
        }

        filterChain.doFilter(request, response);
    }
}