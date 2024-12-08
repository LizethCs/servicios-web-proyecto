package com.limcasoft.api;


import com.limcasoft.api.model.Reservation;
import com.limcasoft.api.repository.ReservationRepository;
import com.limcasoft.api.service.ReservationService;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    private Reservation reservation;

    @Before
    public void setUp() {
        reservation = new Reservation();
        reservation.setId(1L);
        reservation.setCheckInDate("2022-01-01");
        reservation.setCheckOutDate("2022-01-10");
    }

    @Test
    public void testGetAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation);
        when(reservationRepository.findAll()).thenReturn(reservations);
        List<Reservation> result = reservationService.getAllReservations();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testGetReservationById() {
        when(reservationRepository.findById(1L)).thenReturn(java.util.Optional.of(reservation));
        Reservation result = reservationService.getReservationById(1L);
        assertNotNull(result);
        assertEquals(reservation, result);
    }

    @Test
    public void testCreateReservation() {
        when(reservationRepository.save(reservation)).thenReturn(reservation);
        Reservation result = reservationService.createReservation(reservation);
        assertNotNull(result);
        assertEquals(reservation, result);
    }

    @Test
    public void testUpdateReservation() {
        when(reservationRepository.findById(1L)).thenReturn(java.util.Optional.of(reservation));
        reservation.setCheckInDate("2022-02-01");
        Reservation result = reservationService.updateReservation(reservation);
        assertNotNull(result);
        assertEquals(reservation, result);
    }

    @Test
    public void testDeleteReservation() {
        reservationService.deleteReservation(1L);
        
    }
}
