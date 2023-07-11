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

  public Phase(LocalDate start_date, LocalDate due_date, LocalDateTime created_at, LocalDateTime updated_at, List<Comment> comments, User manager, List<User> assignees) {
    this.start_date = start_date;
    this.due_date = due_date;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.comments = comments;
    this.manager = manager;
    this.assignees = assignees;
  }

  public LocalDate getStart_date() {
    return start_date;
  }

  public void setStart_date(LocalDate start_date) {
    this.start_date = start_date;
  }

  public LocalDate getDue_date() {
    return due_date;
  }

  public void setDue_date(LocalDate due_date) {
    this.due_date = due_date;
  }

  public LocalDateTime getCreated_at() {
    return created_at;
  }

  public void setCreated_at(LocalDateTime created_at) {
    this.created_at = created_at;
  }

  public LocalDateTime getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(LocalDateTime updated_at) {
    this.updated_at = updated_at;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public User getManager() {
    return manager;
  }

  public void setManager(User manager) {
    this.manager = manager;
  }

  public List<User> getAssignees() {
    return assignees;
  }

  public void setAssignees(List<User> assignees) {
    this.assignees = assignees;
  }
}
