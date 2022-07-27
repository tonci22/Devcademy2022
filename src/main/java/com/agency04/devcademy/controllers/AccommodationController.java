package com.agency04.devcademy.controllers;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.AccommodationCreateDto;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public Collection<Accommodation> getAccommodations(){
        return accommodationService.getAll();
    }

    @PostMapping
    public Accommodation createAccommodation(@RequestBody AccommodationCreateDto accommodationCreateDto){
        Accommodation accommodation = new Accommodation();
        accommodation.setTitle(accommodationCreateDto.getName());
        return accommodationService.add(accommodation);
    }

    @PutMapping
    public String updateAccommodation(){
        return "PUT";
    }

    @DeleteMapping
    public String deleteAccommodation(){
        return "DELETE";
    }
}
