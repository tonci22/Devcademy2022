package com.agency04.devcademy.repositories;

import com.agency04.devcademy.domain.ReservationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationHistoryRepository extends JpaRepository<ReservationHistory, Long> {
}
