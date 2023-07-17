package com.example.haziq.lead_managemanet.controllers;

import com.example.haziq.lead_managemanet.models.User;
import com.example.haziq.lead_managemanet.repositories.RoleRepository;
import com.example.haziq.lead_managemanet.services.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SessionsController {
  private UserRepository repository;
  private PasswordEncoder passwordEncoder;

  public SessionsController(UserRepository repository, PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
  }
  @PostMapping(path = "/login")
  public User create(@RequestBody User user, HttpServletResponse response) {
    User user repository.findByEmail(user.getEmail());
    AuthenticationService service = new AuthenticationService(passwordEncoder);
    user_repo
    service.isValidPassword("123123123", );

//    UserAdapter adapter = new UserAdapter(repository, role_repository, user, rollName);
//    Cookie cookie = new Cookie("username", "Jovan");
//    UserAdapter adapter = new UserAdapter(repository, role_repository, user, rollName, passwordEncoder);
//    User created_user = adapter.create_user_with_role();
//    Cookie cookie = new Cookie("HTTP-X-AUTH-TOKEN", created_user.getAuth_token());
//    cookie.setHttpOnly(true);
//    //add cookie to response
//    response.addCookie(cookie);
//    User created_user = adapter.create_user_with_role();
    return user;
  }
}
