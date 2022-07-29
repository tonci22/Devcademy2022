package com.agency04.devcademy.controllers;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.AccommodationCreateDto;
import com.agency04.devcademy.dto.AccommodationUpdateDto;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(@Qualifier("accommodationServiceImpl") AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public ResponseEntity<Collection<Accommodation>> getAccommodations() {
        return ResponseEntity.ok(accommodationService.getAll());
    }

    @PostMapping
    public ResponseEntity<Accommodation> createAccommodation(@RequestBody AccommodationCreateDto accommodationCreateDto) {
        return ResponseEntity.ok(accommodationService.add(accommodationCreateDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@RequestBody AccommodationUpdateDto accommodationUpdateDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(accommodationService.updateAccommodation(id, accommodationUpdateDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccommodation(@PathVariable("id") Long id) {
        accommodationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
