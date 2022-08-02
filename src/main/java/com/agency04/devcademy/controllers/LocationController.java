package com.agency04.devcademy.controllers;

import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.dto.LocationCreateDto;
import com.agency04.devcademy.dto.LocationUpdateDto;
import com.agency04.devcademy.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    private final LocationServiceImpl locationService;

    public LocationController(@Qualifier("locationServiceImpl") LocationServiceImpl locationService) {
        this.locationService = locationService;
    }


    @GetMapping
    public ResponseEntity<Collection<Location>> getLocation(){
        return ResponseEntity.ok(locationService.getAll());
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody LocationCreateDto locationCreateDto){
        return ResponseEntity.ok(locationService.add(locationCreateDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<Location> updateLocation(@RequestBody LocationUpdateDto locationUpdateDto, @PathVariable("id") Long id){
        return ResponseEntity.ok(locationService.updateLocation(id, locationUpdateDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable("id") Long id){
        locationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
