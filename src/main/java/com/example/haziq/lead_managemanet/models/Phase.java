package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Phase {
  @Id
  @GeneratedValue
  private Integer id;
  @FutureOrPresent(message = "Start date must be in future")
  private LocalDate start_date;
  @Future(message = "Due date must be in future")
  private LocalDate due_date;
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;
}
