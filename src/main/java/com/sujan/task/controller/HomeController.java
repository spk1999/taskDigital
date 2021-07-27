package com.sujan.task.controller;

import com.sujan.task.dto.JwtRequestDto;
import com.sujan.task.dto.JwtResponseDto;
import com.sujan.task.model.UserModel;
import com.sujan.task.service.UserServiceImpl;
import com.sujan.task.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {


    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private UserServiceImpl userService;

    @Autowired
    public HomeController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserServiceImpl userService) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userService = userService;

    }

    @PostMapping("/auth")
    public JwtResponseDto authenticate(@RequestBody JwtRequestDto requestDto) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Invaid username or password", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(requestDto.getUsername());

        final String token = jwtUtil.generateToken(userDetails);

        return new JwtResponseDto(token);
    }

}
