package com.agency04.devcademy.repositories;

import com.agency04.devcademy.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    List<Accommodation> findByCategorizationAndPersonCountGreaterThanEqual(Integer categorization, Integer personCount);
}
