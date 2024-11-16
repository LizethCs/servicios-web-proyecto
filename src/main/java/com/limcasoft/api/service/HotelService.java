/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.limcasoft.api.service;

import com.limcasoft.api.model.Hotel;
import com.limcasoft.api.repository.HotelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HotelService {
  
  @Autowired
  private HotelRepository hotelRepository;
  
  public List<Hotel> getAllHotels() {
    return hotelRepository.findAll();
  }
  
  public Hotel getHotelById(Long id) {
    return hotelRepository.findById(id).orElseThrow();
  }
  
  public Hotel createHotel(Hotel hotel) {
    return hotelRepository.save(hotel);
  }
  
  public Hotel updateHotel(Hotel hotel) {
    return hotelRepository.save(hotel);
  }
  
  public void deleteHotel(Long id) {
    hotelRepository.deleteById(id);
  }
}