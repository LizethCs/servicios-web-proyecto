package com.limcasoft.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "reservations")
public class Reservation {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private Date checkInDate;
  
  private Date checkOutDate;
  
  @ManyToOne
  @JoinColumn(name = "room_id")
//  @JsonIgnore
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
  
  public Date getCheckInDate() {
    return checkInDate;
  }
  
  public void setCheckInDate(Date checkInDate) {
    this.checkInDate = checkInDate;
  }
  
  public Date getCheckOutDate() {
    return checkOutDate;
  }
  
  public void setCheckOutDate(Date checkOutDate) {
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