package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
  @Lob
  @Column(columnDefinition = "TEXT")
  private String address;
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;

  public ClientDetails(Integer id, String name, String contact_number, String address, LocalDateTime created_at, LocalDateTime updated_at) {
    this.id = id;
    this.name = name;
    this.contact_number = contact_number;
    this.address = address;
    this.created_at = created_at;
    this.updated_at = updated_at;
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

  public String getContact_number() {
    return contact_number;
  }

  public void setContact_number(String contact_number) {
    this.contact_number = contact_number;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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
}
