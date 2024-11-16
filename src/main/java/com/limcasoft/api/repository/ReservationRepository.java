package com.limcasoft.api.repository;

import com.limcasoft.api.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {}
