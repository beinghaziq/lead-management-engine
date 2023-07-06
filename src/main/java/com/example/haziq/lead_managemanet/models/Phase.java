package com.example.haziq.lead_managemanet.models;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;

public class Phase {

  @FutureOrPresent(message = "Start date must be in future")
  private LocalDate start_date;
  @Future(message = "Due date must be in future")
  private LocalDate due_date;
}
