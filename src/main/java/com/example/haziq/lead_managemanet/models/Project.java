package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "projects")
public class Project {
  @Id
  @GeneratedValue
  private Integer id;
  @NotBlank(message = "Name is required")
  private String name;
}
