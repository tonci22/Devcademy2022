package com.agency04.devcademy.controllers;

import com.agency04.devcademy.config.SwaggerConfig;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.dto.response.ReservationDtoResponse;
import com.agency04.devcademy.mapper.ReservationMapper;
import com.agency04.devcademy.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@Api(tags = {SwaggerConfig.RESERVATIONCONTROLLERTAG})
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    private ReservationMapper reservationMapper;

    public ReservationController(@Qualifier("reservationServiceImpl") ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @ApiOperation("Get all Reservations")
    @GetMapping
    public ResponseEntity<List<ReservationDtoResponse>> getReservations(){
        return ResponseEntity.ok(reservationMapper.mapDtoTo(reservationService.getAll()));
    }

    @ApiOperation("Create a new Reservation")
    @PostMapping()
    public ResponseEntity<ReservationDtoResponse> createReservation(@RequestBody ReservationCreateDto reservationCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationMapper.mapDtoTo(reservationService.add(reservationCreateDto)));
    }

    @ApiOperation("Update a Reservation by ID")
    @PutMapping("/confirm/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ReservationDtoResponse> updateReservation(@PathVariable("id") Long id, @RequestBody ReservationUpdateDto reservationUpdateDto, Authentication authentication){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservationMapper.mapDtoTo(reservationService.updateReservation(id, reservationUpdateDto)));
    }

}
