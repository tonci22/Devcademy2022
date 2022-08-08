package com.agency04.devcademy.repositories;

import com.agency04.devcademy.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
