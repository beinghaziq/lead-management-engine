package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "client_details_id", referencedColumnName = "id")
  private ClientDetails clientDetails;
}
