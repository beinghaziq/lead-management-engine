package com.example.haziq.lead_managemanet.adapters;

import com.example.haziq.lead_managemanet.models.User;
import com.example.haziq.lead_managemanet.repositories.RoleRepository;
import com.example.haziq.lead_managemanet.repositories.UserRepository;

public class UserAdapter {
  private final UserRepository user_repository;
  private final RoleRepository role_repository;
  private final User user;
  private final String role_name;

  public UserAdapter(UserRepository repository, RoleRepository role_repository, User user, String role_name) {
    this.user_repository = repository;
    this.role_repository = role_repository;
    this.user = user;
    this.role_name = role_name;
  }

  public void create_user_with_role(){
    System.out.println("herte");
  }
}
