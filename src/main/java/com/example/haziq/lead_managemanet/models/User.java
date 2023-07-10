package com.example.haziq.lead_managemanet.models;

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
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "role_id", referencedColumnName = "id")
  private Role role;

//  Should be moved out of this(Repository or Service)
  @Autowired
  private PasswordEncoder passwordEncoder;

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
    this.password = passwordEncoder.encode(password);
  }

  public String  getPassword() {
    return this.password;
  }

}
