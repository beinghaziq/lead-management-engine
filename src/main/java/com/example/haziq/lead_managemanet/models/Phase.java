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

@Entity(name = "phases")
public class Phase extends Commentable {
  @FutureOrPresent(message = "Start date must be in future")
  private LocalDate start_date;
  @Future(message = "Due date must be in future")
  private LocalDate due_date;
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;
  @OneToMany(mappedBy = "commentable", cascade = CascadeType.ALL)
  private List<Comment> comments = new ArrayList<>();

  @OneToOne(optional = true)
  @JoinColumn(name = "manager_id", referencedColumnName = "id")
  private User manager;

  @ManyToMany(mappedBy = "phases")
  private List<User> assignees;
}
