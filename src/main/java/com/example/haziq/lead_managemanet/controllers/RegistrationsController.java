package com.example.haziq.lead_managemanet.controllers;

import com.example.haziq.lead_managemanet.adapters.UserAdapter;
import com.example.haziq.lead_managemanet.models.User;
import com.example.haziq.lead_managemanet.repositories.RoleRepository;
import com.example.haziq.lead_managemanet.repositories.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationsController {
  private UserRepository repository;
  private RoleRepository role_repository;
  public RegistrationsController(UserRepository repository, RoleRepository role_repository) {
    this.repository = repository;
    this.role_repository = role_repository;
  }
  @PostMapping(path = "/users")
  public User create(@RequestBody User user, @RequestParam(required = false) String rollName, HttpServletResponse response) {
    UserAdapter adapter = new UserAdapter(repository, role_repository, user, rollName);
    Cookie cookie = new Cookie("username", "Jovan");
    cookie.setHttpOnly(true);
    //add cookie to response
    response.addCookie(cookie);
    User created_user = adapter.create_user_with_role();
    return created_user;
  }
}
