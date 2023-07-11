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

  public Image(Long id, byte[] data, Comment comment) {
    this.id = id;
    this.data = data;
    this.comment = comment;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }
}
