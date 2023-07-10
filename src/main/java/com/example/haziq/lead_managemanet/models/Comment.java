package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name = "comments")
public class Comment {
  @Id
  @GeneratedValue
  private Integer id;
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;
  @ManyToOne
  @JoinColumn(name = "commentable_id")
  private Commentable commentable;
}
