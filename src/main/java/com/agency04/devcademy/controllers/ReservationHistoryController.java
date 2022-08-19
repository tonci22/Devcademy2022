package com.agency04.devcademy.controllers;

import com.agency04.devcademy.config.SwaggerConfig;
import com.agency04.devcademy.mapper.ReservationHistoryMapper;
import com.agency04.devcademy.dto.response.ReservationHistoryDtoResponse;
import com.agency04.devcademy.service.ReservationHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/reservationhistory")
@Api(tags = {SwaggerConfig.RESERVATIONHISTORYCONTROLLERTAG})
public class ReservationHistoryController {

    private final ReservationHistoryService reservationHistoryService;

    @Autowired
    private ReservationHistoryMapper reservationHistoryMapper;

    public ReservationHistoryController(ReservationHistoryService reservationHistoryService) {
        this.reservationHistoryService = reservationHistoryService;
    }

    @ApiOperation("Get all Reservations histories")
    @GetMapping
    public ResponseEntity<List<ReservationHistoryDtoResponse>> getReservationHistoryId(){
        return ResponseEntity.ok(reservationHistoryMapper.mapToDto(reservationHistoryService.getAll()));
    }

}
