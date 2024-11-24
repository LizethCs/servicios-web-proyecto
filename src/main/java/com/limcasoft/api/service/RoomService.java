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
        Room existingRoom = roomRepository.findById(room.getId()).orElseThrow();
        existingRoom.setNumber(room.getNumber());
        existingRoom.setType(room.getType());
        existingRoom.setPrice(room.getPrice());
        existingRoom.setHotel(room.getHotel());
        return roomRepository.save(existingRoom);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
