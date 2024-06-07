package com.forum.infra.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.forum.infra.exceptions.TokenNotFoundException;
import com.forum.models.User;
import com.forum.repositories.UserRepository;
import com.forum.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter{

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            Optional<User> user = userRepository.findByUsername(tokenService.getSubject(getToken(request)));
            if(user.isPresent()){
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.get(), null, user.get().getAuthorities());
                System.out.println(user.get());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (TokenNotFoundException | JWTVerificationException exception){
        }
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request){
        String authorizationHeader = request.getHeader("Authorization");
        if(Objects.isNull(authorizationHeader)) throw new TokenNotFoundException();
        return authorizationHeader.replace("Bearer ", "");
    }
}
