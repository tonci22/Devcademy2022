package com.agency04.devcademy.repositories;

import com.agency04.devcademy.api.accomodation.Accommodation;
import org.springframework.data.repository.CrudRepository;

public interface AccommodationRepository extends CrudRepository<Accommodation, Long> {
}