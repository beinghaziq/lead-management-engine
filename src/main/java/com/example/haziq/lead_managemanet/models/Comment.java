package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public class Comment {
  @Id
  @GeneratedValue
  private Integer id;
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;
}
