package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "leads")
public class Lead {
  @Id
  @GeneratedValue
  private Integer id;
  @NotBlank(message = "Email is required")
  private String name;
  @NotBlank(message = "Test Type is required")
  private String test_type;
  @NotBlank(message = "Platform is required")
  private String platform_used;
}
