package com.example.haziq.lead_managemanet.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name = "comments")
public class Comment {
  @Id
  @GeneratedValue
  private Integer id;
  @NotBlank(message = "content is required")
  private String content;
  @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Image> images;
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;
  @ManyToOne
  @JoinColumn(name = "commentable_id")
  private Commentable commentable;

  public Comment(Integer id, String content, List<Image> images, LocalDateTime created_at, LocalDateTime updated_at, Commentable commentable) {
    this.id = id;
    this.content = content;
    this.images = images;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.commentable = commentable;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
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

  public Commentable getCommentable() {
    return commentable;
  }

  public void setCommentable(Commentable commentable) {
    this.commentable = commentable;
  }
}
