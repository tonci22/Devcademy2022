package com.agency04.devcademy;

import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.dto.mapper.AccommodationMapper;
import com.agency04.devcademy.dto.mapper.UserMapper;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.ReservationHistoryCreateDto;
import com.agency04.devcademy.dto.request.UserCreateDto;
import com.agency04.devcademy.enums.AccommodationType;
import com.agency04.devcademy.enums.ReservationType;
import com.agency04.devcademy.repositories.AccommodationRepository;
import com.agency04.devcademy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.*;

//todo - refactor all map methods from Accommodation and Location into separate mapper classes


@SpringBootApplication
public class ApartmentReservationSystemApplication {

    private final AccommodationService accommodationService;
    private final LocationService locationService;
    private final UserService userService;
    private final ReservationHistoryService reservationHistoryService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccommodationMapper accommodationMapper;

    public ApartmentReservationSystemApplication(@Qualifier("accommodationServiceImpl") AccommodationService accommodationService,
                                                 @Qualifier("locationServiceImpl") LocationService locationService,
                                                 @Qualifier("userServiceImpl") UserService userService,
                                                 @Qualifier("reservationHistoryServiceImpl") ReservationHistoryService reservationHistoryService) {

        this.accommodationService = accommodationService;
        this.locationService = locationService;
        this.userService = userService;
        this.reservationHistoryService = reservationHistoryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApartmentReservationSystemApplication.class, args);
    }

    @PostConstruct
    public void initData() {

        Location location = new Location("Lumbarda", "subtitl", 20263);
        locationService.add(location);

        AccommodationCreateDto accommodationCreateDto= new AccommodationCreateDto("Imagination","Imagination1", "Imagination2", 3, 6,"www.Imagination.com");
        accommodationCreateDto.setType(AccommodationType.APARTMENT);
        accommodationCreateDto.setPrice(5);

        location.getAccommodations().add(accommodationMapper.mapToDtoAccommodation(accommodationCreateDto));
        locationService.add(location);


        Reservation reservation = new Reservation(ReservationType.PERMANENT,new Timestamp(new Date().getTime() - 23423444),new Timestamp(new Date().getTime()),5,true);

        UserCreateDto userCreateDto = new UserCreateDto("name", "last Name", "nesto.nesto@nes.com");
        userCreateDto.getReservations().add(reservation);
        userService.add(userCreateDto);

        ReservationHistoryCreateDto reservationHistory = new ReservationHistoryCreateDto(new Timestamp(new Date().getTime()),ReservationType.CANCELED, ReservationType.PERMANENT, 1L);
        reservationHistoryService.add(reservationHistory);

        System.out.println("Accommodations with 3 stars and minimum 5 beds: " + accommodationService.findByCategorizationAndPersonCountGreaterThanEqual(3,5));
    }
}
