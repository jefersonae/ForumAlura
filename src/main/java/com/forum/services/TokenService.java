package com.forum.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.forum.models.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256("123456");
        return JWT.create()
                .withIssuer("Forum Challenge")
                .withSubject(user.getUsername())
                .withExpiresAt(expirationInstant())
                .sign(algorithm);
    }

    public String getSubject(String token){
        Algorithm algorithm = Algorithm.HMAC256("123456");
        return JWT.require(algorithm)
                .withIssuer("Forum Challenge")
                .build()
                .verify(token)
                .getSubject();
    }

    private static Instant expirationInstant(){
        return LocalDateTime.now().plusHours(2L).toInstant(ZoneOffset.of("-03:00"));
    }
}
