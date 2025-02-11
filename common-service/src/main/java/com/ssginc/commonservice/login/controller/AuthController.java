package com.ssginc.commonservice.login.controller;

import com.ssginc.commonservice.login.dto.LoginRequestDto;
import com.ssginc.commonservice.login.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(LoginRequestDto request){
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }
}
