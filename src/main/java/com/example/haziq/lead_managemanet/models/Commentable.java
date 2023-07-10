package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Commentable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;
}
