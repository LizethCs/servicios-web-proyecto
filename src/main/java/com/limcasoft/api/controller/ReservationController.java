package com.limcasoft.api.controller;

import com.limcasoft.api.model.Reservation;
import com.limcasoft.api.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    private boolean validateCredentials(@RequestHeader("Authorization") String authorization) {
        String[] credentials = authorization.split(" ");
        return credentials[0].equals("Basic") && credentials[1].equals("dXNlcjpwYXNzd29yZA==");
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations(@RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(reservationService.getAllReservations());
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(reservationService.getReservationById(id));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(reservationService.createReservation(reservation));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(reservationService.updateReservation(reservation));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            reservationService.deleteReservation(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
