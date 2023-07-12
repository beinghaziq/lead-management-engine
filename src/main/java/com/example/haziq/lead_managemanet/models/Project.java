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

  public Project(String name, LocalDateTime created_at, LocalDateTime updated_at, ClientDetails clientDetails, Lead lead, List<Comment> comments, User manager, List<User> assignees) {
    this.name = name;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.clientDetails = clientDetails;
    this.lead = lead;
    this.comments = comments;
    this.manager = manager;
    this.assignees = assignees;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public ClientDetails getClientDetails() {
    return clientDetails;
  }

  public void setClientDetails(ClientDetails clientDetails) {
    this.clientDetails = clientDetails;
  }

  public Lead getLead() {
    return lead;
  }

  public void setLead(Lead lead) {
    this.lead = lead;
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
