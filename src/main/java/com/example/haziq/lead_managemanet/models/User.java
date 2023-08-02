package com.example.haziq.lead_managemanet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

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
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;
  @ManyToOne
  private Role role;
  private String auth_token;

  @ManyToMany
  @JoinTable(
          name = "assignee_phases",
          joinColumns = @JoinColumn(name = "assignee_id"),
          inverseJoinColumns = @JoinColumn(name = "phase_id")
  )
  private List<Phase> phases;

  @ManyToMany
  @JoinTable(
          name = "assignee_projects",
          joinColumns = @JoinColumn(name = "assignee_id"),
          inverseJoinColumns = @JoinColumn(name = "project_id")
  )
  private List<Phase> projects;

  public void setPassword(String password) {
    this.password = password;
  }

  public String  getPassword() {
    return this.password;
  }

  public User() {}
  public User(Integer id, String email, String full_name, String auth_token,
              String password, LocalDateTime created_at, LocalDateTime updated_at, Role role, List<Phase> phases, List<Phase> projects) {
    this.id = id;
    this.email = email;
    this.full_name = full_name;
    this.password = password;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.role = role;
    this.phases = phases;
    this.projects = projects;
    this.auth_token = auth_token;
  }

  public String getAuth_token() {
    return auth_token;
  }

  public void setAuth_token(String auth_token) {
    this.auth_token = auth_token;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFull_name() {
    return full_name;
  }

  public void setFull_name(String full_name) {
    this.full_name = full_name;
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public List<Phase> getPhases() {
    return phases;
  }

  public void setPhases(List<Phase> phases) {
    this.phases = phases;
  }

  public List<Phase> getProjects() {
    return projects;
  }
  public String getRollName() {
    return getRole().getName().toString();
  }

  public void setProjects(List<Phase> projects) {
    this.projects = projects;
  }
}
