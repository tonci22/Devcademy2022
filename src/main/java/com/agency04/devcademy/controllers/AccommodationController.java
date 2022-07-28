package com.agency04.devcademy.controllers;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.AccommodationCreateDto;
import com.agency04.devcademy.dto.AccommodationUpdateDto;
import com.agency04.devcademy.enums.AccommodationType;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(@Qualifier("accommodationServiceImpl") AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public Collection<Accommodation> getAccommodations() {
        return accommodationService.getAll();
    }

    @PostMapping
    public Accommodation createAccommodation(@RequestBody AccommodationCreateDto accommodationCreateDto) {

        return accommodationService.add(accommodationCreateDto);
    }

    @PutMapping("{id}")
    public Accommodation updateCreateAccommodation(@RequestBody AccommodationUpdateDto accommodationUpdateDto, @PathVariable("id") Long id) {

        Accommodation accommodation = accommodationService.getById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "No accommodation to update found!"));

        return accommodationService.updateAccommodation(accommodation, accommodationUpdateDto);

    }

    @DeleteMapping("{id}")
    public void deleteAccommodation(@PathVariable("id") Long id) {
        accommodationService.deleteById(id);
    }
}
