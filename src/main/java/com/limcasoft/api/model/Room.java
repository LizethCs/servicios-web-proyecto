package com.limcasoft.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;


@Entity
@Table(name = "rooms")
public class Room {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private Integer number;
  
  private String type;
  
  private Integer price;
  
  @ManyToOne
  @JoinColumn(name = "hotel_id")
  @JsonIgnore
  private Hotel hotel;
  
  @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<Reservation> reservations;
  
  // Getters y setters
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Integer getNumber() {
    return number;
  }
  
  public void setNumber(Integer number) {
    this.number = number;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public Integer getPrice() {
    return price;
  }
  
  public void setPrice(Integer price) {
    this.price = price;
  }
  
  public Hotel getHotel() {
    return hotel;
  }
  
  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }
  
  public List<Reservation> getReservations() {
    return reservations;
  }
  
  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }
}