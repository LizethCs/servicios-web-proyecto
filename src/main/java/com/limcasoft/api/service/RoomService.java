/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.limcasoft.api.service;

import com.limcasoft.api.model.Room;
import com.limcasoft.api.repository.RoomRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomService {
  
  @Autowired
  private RoomRepository roomRepository;
  
  public List<Room> getAllRooms() {
    return roomRepository.findAll();
  }
  
  public Room getRoomById(Long id) {
    return roomRepository.findById(id).orElseThrow();
  }
  
  public Room createRoom(Room room) {
    return roomRepository.save(room);
  }
  
  public Room updateRoom(Room room) {
    return roomRepository.save(room);
  }
  
  public void deleteRoom(Long id) {
    roomRepository.deleteById(id);
  }
}