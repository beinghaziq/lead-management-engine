package com.example.haziq.lead_managemanet.controllers;

import com.example.haziq.lead_managemanet.adapters.UserAdapter;
import com.example.haziq.lead_managemanet.models.User;
import com.example.haziq.lead_managemanet.repositories.RoleRepository;
import com.example.haziq.lead_managemanet.repositories.UserRepository;
import com.example.haziq.lead_managemanet.services.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RegistrationsController {
  private UserRepository repository;
  private RoleRepository role_repository;
  private PasswordEncoder passwordEncoder;
  public RegistrationsController(UserRepository repository, RoleRepository role_repository, PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.role_repository = role_repository;
    this.passwordEncoder = passwordEncoder;
  }
  @PostMapping(path = "/users")
  public User create(@RequestBody User user, @RequestParam(required = false) String rollName, HttpServletResponse response) {
    UserAdapter adapter = new UserAdapter(repository, role_repository, user, rollName, passwordEncoder);
    User created_user = adapter.create_user_with_role();
    Cookie cookie = new Cookie("HTTP-X-AUTH-TOKEN", created_user.getAuth_token());
    cookie.setHttpOnly(true);
    response.addCookie(cookie);
    return created_user;
  }
}
