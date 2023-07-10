package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Phase extends Commentable {
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
  @OneToMany(mappedBy = "relatedEntity", cascade = CascadeType.ALL)
  private List<Comment> comments = new ArrayList<>();
}
