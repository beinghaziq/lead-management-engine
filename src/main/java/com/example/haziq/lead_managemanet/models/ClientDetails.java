package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Entity(name = "client_details")
public class ClientDetails {
  @Id
  @GeneratedValue
  private Integer id;
  @NotBlank(message = "Name is required")
  private String name;
  @NotBlank(message = "Number is required")
  private String contact_number;
  @NotBlank(message = "Address is required")
  private Text address;
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;
}
