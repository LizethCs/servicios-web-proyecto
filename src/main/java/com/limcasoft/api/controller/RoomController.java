package com.limcasoft.api.controller;

import com.limcasoft.api.model.Room;
import com.limcasoft.api.service.RoomService;
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
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    private boolean validateCredentials(@RequestHeader("Authorization") String authorization) {
        String[] credentials = authorization.split(" ");
        return credentials[0].equals("Basic") && credentials[1].equals("dXNlcjpwYXNzd29yZA==");
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms(@RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(roomService.getAllRooms());
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(roomService.getRoomById(id));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(roomService.createRoom(room));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(roomService.updateRoom(room));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            roomService.deleteRoom(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
