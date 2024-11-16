package com.limcasoft.api.controller;

import com.limcasoft.api.model.Hotel;
import com.limcasoft.api.service.HotelService;
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
@RequestMapping("/api/hotels")
public class HotelController {
  
  @Autowired
  private HotelService hotelService;
  
  @GetMapping
  public List<Hotel> getAllHotels() {
    return hotelService.getAllHotels();
  }
  
  @GetMapping("/{id}")
  public Hotel getHotelById(@PathVariable Long id) {
    return hotelService.getHotelById(id);
  }
  
  @PostMapping
  public Hotel createHotel(@RequestBody Hotel hotel) {
    return hotelService.createHotel(hotel);
  }
  
  @PutMapping("/{id}")
  public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
    return hotelService.updateHotel(hotel);
  }
  
  @DeleteMapping("/{id}")
  public void deleteHotel(@PathVariable Long id) {
    hotelService.deleteHotel(id);
  }
}
