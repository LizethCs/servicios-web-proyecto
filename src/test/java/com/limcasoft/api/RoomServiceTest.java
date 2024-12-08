package com.limcasoft.api;

import com.limcasoft.api.model.Room;
import com.limcasoft.api.repository.RoomRepository;
import com.limcasoft.api.service.RoomService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    private Room room;

    @Before
    public void setUp() {
        room = new Room();
        room.setId(1L);
        room.setNumber(101);
        room.setType("Individual");
        room.setPrice(50000);
    }

    @Test
    public void testGetAllRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        when(roomRepository.findAll()).thenReturn(rooms);
        List<Room> result = roomService.getAllRooms();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testGetRoomById() {
        when(roomRepository.findById(1L)).thenReturn(java.util.Optional.of(room));
        Room result = roomService.getRoomById(1L);
        assertNotNull(result);
        assertEquals(room, result);
    }

    @Test
    public void testCreateRoom() {
        when(roomRepository.save(room)).thenReturn(room);
        Room result = roomService.createRoom(room);
        assertNotNull(result);
        assertEquals(room, result);
    }

    @Test
    public void testUpdateRoom() {
        when(roomRepository.findById(1L)).thenReturn(java.util.Optional.of(room));
        room.setNumber(102);
        Room result = roomService.updateRoom(room);
        assertNotNull(result);
        assertEquals(room, result);
    }

    @Test
    public void testDeleteRoom() {
        roomService.deleteRoom(1L);
        
    }
}
