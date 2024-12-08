package com.limcasoft.api;


import com.limcasoft.api.model.Hotel;
import com.limcasoft.api.repository.HotelRepository;
import com.limcasoft.api.service.HotelService;
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
public class HotelServiceTest {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelService hotelService;

    private Hotel hotel;

    @Before
    public void setUp() {
        hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Hotel Example");
        hotel.setAddress("Calle Example 123");
    }

    @Test
    public void testGetAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotel);
        when(hotelRepository.findAll()).thenReturn(hotels);
        List<Hotel> result = hotelService.getAllHotels();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testGetHotelById() {
        when(hotelRepository.findById(1L)).thenReturn(java.util.Optional.of(hotel));
        Hotel result = hotelService.getHotelById(1L);
        assertNotNull(result);
        assertEquals(hotel, result);
    }

    @Test
    public void testCreateHotel() {
        when(hotelRepository.save(hotel)).thenReturn(hotel);
        Hotel result = hotelService.createHotel(hotel);
        assertNotNull(result);
        assertEquals(hotel, result);
    }

    @Test
    public void testUpdateHotel() {
        when(hotelRepository.findById(1L)).thenReturn(java.util.Optional.of(hotel));
        hotel.setName("Hotel Example Updated");
        Hotel result = hotelService.updateHotel(hotel);
        assertNotNull(result);
        assertEquals(hotel, result);
    }

    @Test
    public void testDeleteHotel() {
        hotelService.deleteHotel(1L);
        
    }
}
