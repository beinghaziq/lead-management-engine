package com.example.haziq.lead_managemanet.models;

import com.example.haziq.lead_managemanet.enums.RoleName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "roles")
public class Role {
  @Id
  @GeneratedValue
  private Integer id;
  @NotBlank(message = "Name is mandatory")
  @Enumerated(EnumType.STRING)
  private RoleName name;

  public Role(Integer id, RoleName name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RoleName getName() {
    return name;
  }

  public void setName(RoleName name) {
    this.name = name;
  }
}
