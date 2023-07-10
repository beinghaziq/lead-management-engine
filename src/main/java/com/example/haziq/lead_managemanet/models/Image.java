package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.*;

@Entity
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  @Column(length = Integer.MAX_VALUE)
  private byte[] data;

//  We can have polymorphism here as well
  @ManyToOne
  @JoinColumn(name = "comment_id")
  private Comment comment;
}
