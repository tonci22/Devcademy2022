package com.agency04.devcademy.repositories;

import com.agency04.devcademy.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
