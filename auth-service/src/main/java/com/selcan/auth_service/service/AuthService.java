package com.selcan.auth_service.service;

import com.selcan.auth_service.dtos.AuthResponse;
import com.selcan.auth_service.dtos.LoginDto;
import com.selcan.auth_service.dtos.RegisterDto;

public interface AuthService {
    AuthResponse register(RegisterDto request);
    AuthResponse login(LoginDto request);
    void logout(String token);
}
