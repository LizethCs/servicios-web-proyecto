package com.limcasoft.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;


@Entity
@Table(name = "customers")
public class Customer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(unique = true)
  private String name;
  
  private String lastName;
  
  private String email;
  private String phone;
  private String address;
  private String documentType;
  private String document;
  
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<Reservation> reservations;
  
  // Getters y setters
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }

    public void setName(String name) {
        this.name = name;
    }
  
  public String getName() {
    return name;
  }
  
  public String getLastName() {
  return lastName;
}

public void setLastName(String lastName) {
  this.lastName = lastName;
}

public String getEmail() {
  return email;
}

public void setEmail(String email) {
  this.email = email;
}

public List<Reservation> getReservations() {
  return reservations;
}

public void setReservations(List<Reservation> reservations) {
  this.reservations = reservations;
}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}