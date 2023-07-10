package com.example.haziq.lead_managemanet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
//TO be written
//  @Autowired
//  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

//  To be updated
  public boolean isValidPassword(String username, String password) {
//    User user = userRepository.findByUsername(username);
    String user = "anc";
    if (user != null) {
      // Compare the stored encoded password with the user-provided password
//      return passwordEncoder.matches(password, user.getPassword());
    }

    return false;
  }
}

