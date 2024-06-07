package com.forum.controllers;

import com.forum.dtos.RequestLoginDTO;
import com.forum.dtos.ResponseTokenDTO;
import com.forum.models.User;
import com.forum.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public ResponseEntity<ResponseTokenDTO> login(@RequestBody RequestLoginDTO requestLoginDTO) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestLoginDTO.username(), requestLoginDTO.password());
        Authentication authentication = authenticationManager.authenticate(token);
        return ResponseEntity.ok().body(new ResponseTokenDTO(tokenService.generateToken((User) authentication.getPrincipal())));
    }
    
}
