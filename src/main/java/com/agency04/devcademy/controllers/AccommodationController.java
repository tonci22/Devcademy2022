package com.agency04.devcademy.controllers;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.mapper.AccommodationMapper;
import com.agency04.devcademy.dto.response.AccommodationDtoResponse;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    private final AccommodationService accommodationService;
    private final LocationService locationService;

    @Autowired
    private AccommodationMapper accommodationMapper;

    public AccommodationController(@Qualifier("accommodationServiceImpl") AccommodationService accommodationService,@Qualifier("locationServiceImpl") LocationService locationService) {
        this.accommodationService = accommodationService;
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<AccommodationDtoResponse>> getAccommodations() {
        return ResponseEntity.ok(accommodationMapper.mapToDto(accommodationService.getAll()));
    }

    @GetMapping("/recommendation")
    public ResponseEntity<List<AccommodationDtoResponse>> getShuffledAccommodations() {
        if (accommodationService.getAll().size() < 10) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(accommodationMapper.mapToDto(accommodationService.randomizeAccommodations().stream().toList()));
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<Byte[]> getAccommodationImage(@PathVariable("id") Long id){
        return ResponseEntity.ok(accommodationService.getById(id).getImage());
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<Byte[]> createAccommodationImage(@PathVariable Long id, @RequestParam("image") MultipartFile file){
       return ResponseEntity.ok(accommodationService.saveImageFile(id, file));
    }

    @PostMapping
    public ResponseEntity<AccommodationDtoResponse> createAccommodation(@RequestBody AccommodationCreateDto accommodationCreateDto) {
        return ResponseEntity.status(201).body(accommodationMapper.mapToDto(accommodationService.add(accommodationCreateDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<AccommodationDtoResponse> updateAccommodation(@RequestBody AccommodationUpdateDto accommodationUpdateDto, @PathVariable("id") Long id) {
        return ResponseEntity.status(201).body(accommodationMapper.mapToDto(accommodationService.updateAccommodation(id, accommodationUpdateDto)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccommodation(@PathVariable("id") Long id) {
        accommodationService.deleteById(id);
        return ResponseEntity.ok("DELETED ACCOMMODATION");
    }
}
