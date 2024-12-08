package com.limcasoft.api.controller;

import com.limcasoft.api.model.Hotel;
import com.limcasoft.api.service.HotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    private boolean validateCredentials(@RequestHeader("Authorization") String authorization) {
        String[] credentials = authorization.split(" ");
        return credentials[0].equals("Basic") && credentials[1].equals("dXNlcjpwYXNzd29yZA==");
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels(@RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            List<Hotel> hotels = hotelService.getAllHotels();
            System.out.println("Hotels: " + hotels); // Punto de depuración
            return ResponseEntity.ok(hotels);
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(hotelService.getHotelById(id));
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(hotelService.createHotel(hotel));
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(hotelService.updateHotel(hotel));
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            hotelService.deleteHotel(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
