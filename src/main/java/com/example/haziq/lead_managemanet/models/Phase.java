package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;

public class Phase {
  @Id
  @GeneratedValue
  private Integer id;
  @FutureOrPresent(message = "Start date must be in future")
  private LocalDate start_date;
  @Future(message = "Due date must be in future")
  private LocalDate due_date;
}
