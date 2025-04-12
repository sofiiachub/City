package com.city.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return authService.login(request.getLogin(), request.getPassword());
    }

    @PostMapping("/login/refresh")
    public TokenResponse refresh(@RequestBody TokenResponse request) {
        return authService.refresh(request.getRefreshToken());
    }
}
