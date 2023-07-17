package com.example.haziq.lead_managemanet.models;

import com.example.haziq.lead_managemanet.enums.RoleName;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "roles")
public class  Role {
  @Id
  @GeneratedValue
  private Integer id;
  @Enumerated(EnumType.STRING)
  private RoleName name;
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;

  @OneToMany(mappedBy = "role")
  private List<User> users;


  public Role() {
  }

  public Role(Integer id, RoleName name, LocalDateTime created_at, LocalDateTime updated_at) {
    this.id = id;
    this.name = name;
    this.created_at = created_at;
    this.updated_at = updated_at;
  }

  public Role(Integer id, RoleName name) {
    this.id = id;
    this.name = name;
  }

  public LocalDateTime getCreated_at() {
    return created_at;
  }

  public void setCreated_at(LocalDateTime created_at) {
    this.created_at = created_at;
  }

  public LocalDateTime getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(LocalDateTime updated_at) {
    this.updated_at = updated_at;
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
