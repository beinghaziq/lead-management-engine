package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name = "projects")
public class Project {
  @Id
  @GeneratedValue
  private Integer id;
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
}
