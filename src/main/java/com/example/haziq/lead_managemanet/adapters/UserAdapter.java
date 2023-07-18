package com.example.haziq.lead_managemanet.adapters;

import com.example.haziq.lead_managemanet.enums.RoleName;
import com.example.haziq.lead_managemanet.models.Role;
import com.example.haziq.lead_managemanet.models.User;
import com.example.haziq.lead_managemanet.repositories.RoleRepository;
import com.example.haziq.lead_managemanet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

public class UserAdapter {
  private final UserRepository user_repository;
  private final RoleRepository role_repository;
  private final User user;
  private final String role_name;
  private PasswordEncoder passwordEncoder;

  public UserAdapter(UserRepository repository, RoleRepository role_repository, User user, String role_name, PasswordEncoder passwordEncoder) {
    this.user_repository = repository;
    this.role_repository = role_repository;
    this.user = user;
    this.role_name = role_name;
    this.passwordEncoder = passwordEncoder;
  }

  public User create_user_with_role() {
    RoleName enumValue = RoleName.valueOf(role_name);
    Optional<Role> role = role_repository.findByName(enumValue);
    user.setRole(role.get());
    user.setAuth_token(UUID.randomUUID().toString());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user_repository.save(user);
    return user;
  }
}
