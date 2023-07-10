package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class Comment {
  @Id
  @GeneratedValue
  private Integer id;

  @NotBlank(message = "content is required")
  private String content;
  @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Image> images;
}
