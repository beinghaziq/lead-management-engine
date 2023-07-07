package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "users")
public class User {
  @Id
  @GeneratedValue
  private Integer id;
  @Column(unique = true)
  @NotBlank(message = "Email is required")
  @Email(message = "Invalid email format")
  private String email;

  @NotBlank(message = "Name is required")
  private String full_name;

//  Will work on encryption later
  @NotBlank(message = "Password is required")
  private String password;
}
