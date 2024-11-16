/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.limcasoft.api.controller;

import com.limcasoft.api.model.Reservation;
import com.limcasoft.api.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
  
  @Autowired
  private ReservationService reservationService;
  
  @GetMapping
  public List<Reservation> getAllReservations() {
    return reservationService.getAllReservations();
  }
  
  @GetMapping("/{id}")
  public Reservation getReservationById(@PathVariable Long id) {
    return reservationService.getReservationById(id);
  }
  
  @PostMapping
  public Reservation createReservation(@RequestBody Reservation reservation) {
    return reservationService.createReservation(reservation);
  }
  
  @PutMapping("/{id}")
  public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
    return reservationService.updateReservation(reservation);
  }
  
  @DeleteMapping("/{id}")
  public void deleteReservation(@PathVariable Long id) {
    reservationService.deleteReservation(id);
  }
}
