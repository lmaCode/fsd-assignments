package com.lipengwei.fsd.controller;

import com.lipengwei.fsd.dto.TUser;
import com.lipengwei.fsd.dto.User;
import com.lipengwei.fsd.dto.UserInfoDto;
import com.lipengwei.fsd.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody TUser registerUser) {
        authService.register(registerUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/checkToken")
    public ResponseEntity<UserInfoDto> checkToken(String token) {
        UserInfoDto userInfoDto = authService.checkToken(token);
        return ResponseEntity.ok(userInfoDto);
    }
}
