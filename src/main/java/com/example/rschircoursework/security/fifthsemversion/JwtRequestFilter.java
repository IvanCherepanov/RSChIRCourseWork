package com.example.rschircoursework.security.fifthsemversion;

import com.example.rschircoursework.security.fifthsemversion.dto.JwtConfig;
import io.jsonwebtoken.JwtException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final JwtConfig jwtConfig;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        //System.out.println("All Headers: " + request.get);
        System.out.println("authorizationHeader: " + authorizationHeader);
        if (authorizationHeader == null
                || !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");
        System.out.println("authorizationToken: " + token);
        try {
            System.out.println("to try block");
            String username = jwtTokenUtil.getUsernameFromToken(token);
            System.out.println(username);
            UserDetails user = userDetailsService.loadUserByUsername(username);
            System.out.println(user);
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            System.out.println(authentication.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (JwtException e) {
            throw new IllegalStateException(String.format("Token %s cannot be trust", token));
        }
        filterChain.doFilter(request, response);
    }
}
