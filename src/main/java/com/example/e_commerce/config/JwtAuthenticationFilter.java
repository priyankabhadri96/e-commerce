package com.example.e_commerce.config;

import com.example.e_commerce.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
   private JwtService jwtService;
   public JwtAuthenticationFilter(JwtService jwtService){
       this.jwtService = jwtService;
   }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String auth_token = request.getHeader("Authorization");

        if (request.getRequestURI().equals("/user")) {
            filterChain.doFilter(request, response);
            return;
        }
        if (auth_token == null || !auth_token.contains("Bearer")) {
            filterChain.doFilter(request,response);
            return ;
        }
        String token = auth_token.substring(7);
        if(jwtService.isTokenValid(token)){
            String username = jwtService.getUsername(token);
            String role = jwtService.getRole(token);

            SimpleGrantedAuthority auth_list = new SimpleGrantedAuthority("ROLE_"+role);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,null,List.of(auth_list));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);
    }
}
