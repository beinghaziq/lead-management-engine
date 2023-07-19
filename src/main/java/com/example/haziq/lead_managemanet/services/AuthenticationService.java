package com.example.haziq.lead_managemanet.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  private PasswordEncoder passwordEncoder;
  public AuthenticationService(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }
  public boolean isValidPassword(String password, String user_password) {
      return passwordEncoder.matches(password, user_password);
  }
}

