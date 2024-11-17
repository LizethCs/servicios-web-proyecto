package com.limcasoft.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "reservations")
public class Reservation {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", message = "La fecha no es válida.")
  private String checkInDate;
  @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", message = "La fecha no es válida.")
  private String checkOutDate;
  
  @ManyToOne
  @JoinColumn(name = "room_id")
  private Room room;
  
  @ManyToOne
  @JoinColumn(name = "customer_id")
  
  private Customer customer;
  
  // Getters y setters
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getCheckInDate() {
    return checkInDate;
  }
  
  public void setCheckInDate(String checkInDate) {
    this.checkInDate = checkInDate;
  }
  
  public String getCheckOutDate() {
    return checkOutDate;
  }
  
  public void setCheckOutDate(String checkOutDate) {
    this.checkOutDate = checkOutDate;
  }
  
  public Room getRoom() {
    return room;
  }
  
  public void setRoom(Room room) {
    this.room = room;
  }
  
  public Customer getCustomer() {
    return customer;
  }
  
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}