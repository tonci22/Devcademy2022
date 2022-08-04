package com.agency04.devcademy.controllers;

import com.agency04.devcademy.dto.mapper.LocationMapper;
import com.agency04.devcademy.dto.response.LocationDtoResponse;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.request.LocationUpdateDto;
import com.agency04.devcademy.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    private final LocationServiceImpl locationService;

    @Autowired
    private LocationMapper locationMapper;

    public LocationController(@Qualifier("locationServiceImpl") LocationServiceImpl locationService) {
        this.locationService = locationService;
    }


    @GetMapping
    public ResponseEntity<Collection<LocationDtoResponse>> getLocation(){
        return ResponseEntity.ok(locationMapper.mapToDto(locationService.getAll()));
    }

    @PostMapping
    public ResponseEntity<LocationDtoResponse> createLocation(@RequestBody LocationCreateDto locationCreateDto){
        return ResponseEntity.ok(locationMapper.mapToDto(locationService.add(locationCreateDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<LocationDtoResponse> updateLocation(@RequestBody LocationUpdateDto locationUpdateDto, @PathVariable("id") Long id){
        return ResponseEntity.ok(locationMapper.mapToDto(locationService.updateLocation(id, locationUpdateDto)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("id") Long id){
        locationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
