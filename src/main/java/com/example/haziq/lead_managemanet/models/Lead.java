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
  @NotBlank(message = "name is required")
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

  @ManyToOne
  @JoinColumn(name = "creator_id", referencedColumnName = "id")
  private User creator;

  public Lead(String name, String test_type, String platform_used, ClientDetails clientDetails, User creator) {
    this.name = name;
    this.test_type = test_type;
    this.platform_used = platform_used;
    this.clientDetails = clientDetails;
    this.creator = creator;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTest_type() {
    return test_type;
  }

  public void setTest_type(String test_type) {
    this.test_type = test_type;
  }

  public String getPlatform_used() {
    return platform_used;
  }

  public void setPlatform_used(String platform_used) {
    this.platform_used = platform_used;
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

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }
}
