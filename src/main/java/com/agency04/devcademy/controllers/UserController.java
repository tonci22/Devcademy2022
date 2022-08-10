package com.agency04.devcademy.controllers;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.dto.mapper.ReservationMapper;
import com.agency04.devcademy.dto.mapper.UserMapper;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.dto.request.UserCreateDto;
import com.agency04.devcademy.dto.request.UserUpdateDto;
import com.agency04.devcademy.dto.response.ReservationDtoResponse;
import com.agency04.devcademy.dto.response.UserDtoResponse;
import com.agency04.devcademy.service.ReservationServiceImpl;
import com.agency04.devcademy.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserServiceImpl userService;

    private final ReservationServiceImpl reservationService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ReservationMapper reservationMapper;

    public UserController(@Qualifier("userServiceImpl") UserServiceImpl userService,@Qualifier("reservationServiceImpl") ReservationServiceImpl reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getUsers(){
        return ResponseEntity.ok(userMapper.mapToDto(userService.getAll()));
    }

    @PostMapping
    public ResponseEntity<UserDtoResponse> createUser(@RequestBody UserCreateDto userCreateDto){
        return ResponseEntity.ok(userMapper.mapToDto(userService.add(userCreateDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDtoResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDto userUpdateDto){
        return ResponseEntity.ok(userMapper.mapToDto(userService.updateUser(id, userUpdateDto)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("DELETED USER");
    }

    //reservation


    @GetMapping(value = "/reservations")
    public ResponseEntity<List<ReservationDtoResponse>> getReservations(){
        return ResponseEntity.ok(reservationMapper.mapDtoTo((reservationService.getAll())));
    }

    @PostMapping(value = "/{id}/reservations")
    public ResponseEntity<UserDtoResponse> createReservation(@PathVariable("id") Long id, @RequestBody ReservationCreateDto reservationCreateDto){
        return ResponseEntity.ok(userMapper.mapToDto(userService.addReservation(id, reservationCreateDto)));
    }

    @PutMapping("/{id}/reservations/{idReservation}")
    public ResponseEntity<UserDtoResponse> updateReservation(@PathVariable("id") Long id, @PathVariable("idReservation") Long idReservation, @RequestBody ReservationUpdateDto reservationUpdateDto){
        return ResponseEntity.ok(userMapper.mapToDto(userService.updateReservation(id,idReservation,reservationUpdateDto)));
    }

    @DeleteMapping("/{id}/reservations/{idReservation}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") Long id){
        reservationService.deleteById(id);
        return ResponseEntity.ok("DELETED RESERVATION");
    }
}
