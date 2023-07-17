package com.example.haziq.lead_managemanet.controllers;

import com.example.haziq.lead_managemanet.enums.RoleName;
import com.example.haziq.lead_managemanet.models.Role;
import com.example.haziq.lead_managemanet.repositories.RoleRepository;
import com.example.haziq.lead_managemanet.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.example.haziq.lead_managemanet.enums.RoleName.SuperAdmin;

@RestController
public class ConsoleController {
    private RoleRepository repository;
    private PasswordEncoder passwordEncoder;

  public ConsoleController(RoleRepository repository, PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
  }
    @GetMapping(path = "/console")
    public Role get() {
      Optional<Role> role = repository.findByName(SuperAdmin);
      RoleName enumValue = RoleName.valueOf("SuperAdmin");
      System.out.println(enumValue);
      return role.get();
    }
}
