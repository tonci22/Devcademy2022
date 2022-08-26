package com.agency04.devcademy.controllers;

import com.agency04.devcademy.config.SwaggerConfig;
import com.agency04.devcademy.mapper.ReservationMapper;
import com.agency04.devcademy.mapper.UserMapper;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.dto.request.UserCreateDto;
import com.agency04.devcademy.dto.request.UserUpdateDto;
import com.agency04.devcademy.dto.response.ReservationDtoResponse;
import com.agency04.devcademy.dto.response.UserDtoResponse;
import com.agency04.devcademy.service.ReservationServiceImpl;
import com.agency04.devcademy.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@Api(tags = {SwaggerConfig.USERCONTROLLERTAG})
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

    @ApiOperation("Get all Users")
    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getUsers(){
        return ResponseEntity.ok(userMapper.mapToDto(userService.getAll()));
    }

    @ApiOperation("Create a new User")
    @PostMapping
    public ResponseEntity<UserDtoResponse> createUser(@RequestBody UserCreateDto userCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.mapToDto(userService.add(userCreateDto)));
    }

    @ApiOperation("Update a User by ID")
    @PutMapping("{id}")
    public ResponseEntity<UserDtoResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDto userUpdateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userMapper.mapToDto(userService.updateUser(id, userUpdateDto)));
    }

    @ApiOperation("Delete a User by ID")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("DELETED USER");
    }


    @ApiOperation("Get all Reservations")
    @GetMapping(value = "/reservations")
    public ResponseEntity<List<ReservationDtoResponse>> getReservations(){
        return ResponseEntity.ok(reservationMapper.mapDtoTo((reservationService.getAll())));
    }

    @ApiOperation("Create a Reservation from a User by Reservation ID and User ID")
    @PostMapping(value = "/{id}/reservations/{idAccommodation}")
    public ResponseEntity<UserDtoResponse> createReservation(@PathVariable("id") Long id, @PathVariable("idAccommodation") Long idAccommodation, @RequestBody ReservationCreateDto reservationCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.mapToDto(userService.addReservation(id, idAccommodation,reservationCreateDto)));
    }

    @ApiOperation("Update a Reservation in User by Reservation ID and User ID")
    @PutMapping("/{id}/reservations/{idReservation}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserDtoResponse> updateReservation(@PathVariable("id") Long id, @PathVariable("idReservation") Long idReservation, @RequestBody ReservationUpdateDto reservationUpdateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userMapper.mapToDto(userService.updateReservation(id,idReservation,reservationUpdateDto)));
    }

    @ApiOperation("Delete a Reservation by ID")
    @DeleteMapping("/{id}/reservations/{idReservation}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") Long id){
        reservationService.deleteById(id);
        return ResponseEntity.ok("DELETED RESERVATION");
    }
}
