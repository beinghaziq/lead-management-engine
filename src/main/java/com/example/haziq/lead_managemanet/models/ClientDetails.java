package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.w3c.dom.Text;

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
}
