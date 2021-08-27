package com.luizalabs.spongebob.infraestructure.database.customer.table;

import com.luizalabs.spongebob.domain.entity.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class CustomerTable implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public CustomerTable() {
  }

  public CustomerTable(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public UUID getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @PrePersist
  private void setCreatedAt() {
    this.createdAt = LocalDateTime.now();
  }

  @PreUpdate
  private void setUpdatedAt() {
    this.updatedAt = LocalDateTime.now();
  }

  public Customer toEntity() {
    return new Customer(this.getId(), this.getName(), this.getEmail());
  }
}