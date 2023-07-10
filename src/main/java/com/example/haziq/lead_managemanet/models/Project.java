package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "projects")
public class Project extends Commentable {
  @NotBlank(message = "Name is required")
  private String name;
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "client_details_id", referencedColumnName = "id")
  private ClientDetails clientDetails;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "lead_id", referencedColumnName = "id")
  private Lead lead;

  @OneToMany(mappedBy = "commentable", cascade = CascadeType.ALL)
  private List<Comment> comments = new ArrayList<>();

  @OneToOne(optional = true)
  @JoinColumn(name = "manager_id", referencedColumnName = "id")
  private User manager;

  @ManyToMany(mappedBy = "projects")
  private List<User> assignees;
}
