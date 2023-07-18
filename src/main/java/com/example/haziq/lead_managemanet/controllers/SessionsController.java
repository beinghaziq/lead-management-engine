package com.example.haziq.lead_managemanet.controllers;

import com.example.haziq.lead_managemanet.models.User;
import com.example.haziq.lead_managemanet.repositories.UserRepository;
import com.example.haziq.lead_managemanet.services.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class SessionsController {
  private UserRepository repository;
  private PasswordEncoder passwordEncoder;

  public SessionsController(UserRepository repository, PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
  }
  @PostMapping(path = "/login")
  public User create(@RequestBody User user, HttpServletResponse response) {
    Optional<User> loggedUser = Optional.ofNullable(repository.findByEmail(user.getEmail()));
    AuthenticationService service = new AuthenticationService(passwordEncoder);
    if (loggedUser.isPresent()) {

    loggedUser.get().setAuth_token(UUID.randomUUID().toString());
    repository.save(loggedUser.get());
    boolean is_valid = service.isValidPassword(user.getPassword(), loggedUser.get().getPassword());
    System.out.println(is_valid);
//    if (is_valid == true) {
      Cookie cookie = new Cookie("HTTP-X-AUTH-TOKEN", loggedUser.get().getAuth_token());
      cookie.setHttpOnly(true);
      response.addCookie(cookie);
      System.out.println("Here");
      return loggedUser.get();
//    }
//    Will handle exceptions in next PR
//    return loggedUser;

    }
    return loggedUser.get();
  }

  @DeleteMapping("/api/logout")
  public ResponseEntity destroy(@RequestParam String email, HttpServletResponse response) {
    Optional<User> loggedUser = Optional.ofNullable(repository.findByEmail(email));
    loggedUser.get().setAuth_token(null);
    repository.save(loggedUser.get());
    Cookie cookie = new Cookie("HTTP-X-AUTH-TOKEN", null);
    cookie.setMaxAge(0);
    cookie.setSecure(true);
    cookie.setHttpOnly(true);
    cookie.setPath("/");
    response.addCookie(cookie);
    return ResponseEntity.status(HttpStatus.OK).body("User logged out successfully");
  }
}
