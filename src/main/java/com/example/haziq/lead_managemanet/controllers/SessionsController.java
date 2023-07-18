package com.example.haziq.lead_managemanet.controllers;

import com.example.haziq.lead_managemanet.models.User;
import com.example.haziq.lead_managemanet.repositories.RoleRepository;
import com.example.haziq.lead_managemanet.repositories.UserRepository;
import com.example.haziq.lead_managemanet.responses.MessageResponse;
import com.example.haziq.lead_managemanet.services.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

public class SessionsController {
  private UserRepository repository;
  private PasswordEncoder passwordEncoder;

  public SessionsController(UserRepository repository, PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
  }
  @PostMapping(path = "/login")
  public User create(@RequestBody User user, HttpServletResponse response) {
    User loggedUser = repository.findByEmail(user.getEmail());
    AuthenticationService service = new AuthenticationService(passwordEncoder);
    loggedUser.setAuth_token(UUID.randomUUID().toString());
    repository.save(loggedUser);
    boolean is_valid = service.isValidPassword(user.getPassword(), loggedUser.getPassword());

    Cookie cookie = new Cookie("HTTP-X-AUTH-TOKEN", loggedUser.getAuth_token());
    cookie.setHttpOnly(true);
    response.addCookie(cookie);
    return user;
  }

  @DeleteMapping(path = "/logout")
  public ResponseEntity<MessageResponse> destroy(@RequestParam String email, HttpServletResponse response) {
    User loggedUser = repository.findByEmail(email);
    AuthenticationService service = new AuthenticationService(passwordEncoder);
    loggedUser.setAuth_token(UUID.randomUUID().toString());
    repository.save(loggedUser);
    boolean is_valid = service.isValidPassword(user.getPassword(), loggedUser.getPassword());

    Cookie cookie = new Cookie("HTTP-X-AUTH-TOKEN", null);
    cookie.setMaxAge(0);
    cookie.setSecure(true);
    cookie.setHttpOnly(true);
    cookie.setPath("/");

//add cookie to response
    response.addCookie(cookie);
    MessageResponse message = new MessageResponse("User logged out successfully");
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }
}
