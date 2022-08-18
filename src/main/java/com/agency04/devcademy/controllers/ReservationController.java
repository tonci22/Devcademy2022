package com.agency04.devcademy.controllers;

import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.dto.response.ReservationDtoResponse;
import com.agency04.devcademy.mapper.ReservationMapper;
import com.agency04.devcademy.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    private ReservationMapper reservationMapper;

    public ReservationController(@Qualifier("reservationServiceImpl") ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDtoResponse>> getReservations(){
        return ResponseEntity.ok(reservationMapper.mapDtoTo(reservationService.getAll()));
    }

    @PostMapping
    public ResponseEntity<ReservationDtoResponse> createReservation(@RequestBody ReservationCreateDto reservationCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationMapper.mapDtoTo(reservationService.add(reservationCreateDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDtoResponse> updateReservation(@PathVariable("id") Long id, @RequestBody ReservationUpdateDto reservationUpdateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservationMapper.mapDtoTo(reservationService.updateReservation(id, reservationUpdateDto)));
    }
}
