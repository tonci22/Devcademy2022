package com.agency04.devcademy;

import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.dto.mapper.UserMapper;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.UserCreateDto;
import com.agency04.devcademy.enums.ReservationType;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.LocationService;
import com.agency04.devcademy.service.ReservationService;
import com.agency04.devcademy.service.UserService;
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

    private final ReservationService reservationService;

    @Autowired
    private UserMapper userMapper;

    public ApartmentReservationSystemApplication(@Qualifier("accommodationServiceImpl") AccommodationService accommodationRepository,
                                                 @Qualifier("locationServiceImpl") LocationService locationService,
                                                 @Qualifier("userServiceImpl") UserService userService,
                                                 @Qualifier("reservationServiceImpl") ReservationService reservationService) {

        this.accommodationService = accommodationRepository;
        this.locationService = locationService;
        this.userService = userService;
        this.reservationService = reservationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApartmentReservationSystemApplication.class, args);
    }

    @PostConstruct
    public void initData() {

        Random random = new Random();
        List<Location> locations = new ArrayList<>() {
            {
                add(new Location("Korcula", "subtitl", 20260));
                add(new Location("Korcula", "subtitl", 20261));
                add(new Location("Blato", "subtitl", 20253));
                add(new Location("Vela Luka", "subtitl", 20456));
                add(new Location("Lumbarda", "subtitl", 20263));
            }
        };
        locationService.addAll(locations);


        List<UserCreateDto> users = new ArrayList<>(){
            {
                add(new UserCreateDto("name", "last Name", "nesto.nesto@nes.com"));
                add(new UserCreateDto("name1", "last Name1", "nesto1.nesto@nes.com"));
                add(new UserCreateDto("name2", "last Name2", "nesto2.nesto@nes.com"));
            }
        };

        userService.addAll(users);

        Timestamp timestamp = new Timestamp(new Date().getTime() - random.nextInt(Integer.MAX_VALUE - 1));
        List<ReservationCreateDto> reservations = new ArrayList<>() {
            {
                add(new ReservationCreateDto(ReservationType.TEMP, timestamp, new Timestamp(new Date().getTime()), 23, true));
                add(new ReservationCreateDto(ReservationType.TEMP1, timestamp, new Timestamp(new Date().getTime()), 9, true));
                add(new ReservationCreateDto(ReservationType.TEMP2, timestamp, new Timestamp(new Date().getTime()), 4, false));
            }
        };

        reservationService.addAll(reservations);
       /* List<Accommodation> accommodations = new ArrayList<>() {
            {
                add(new Accommodation("titl", "subtit", "opis"));
                add(new Accommodation("titl1", "subtit1", "opis1"));
                add(new Accommodation("titl2", "subtit2", "opis2"));
            }
        };

        int i = 0;

        for (Accommodation accommodation : accommodations) {
            accommodation.setPrice(random.nextInt(999));
            accommodation.setType(AccommodationType.APARTMENT);
            accommodation.setFreeCancelation(false);
            accommodation.setCategorization(random.nextInt(4) + 1);
            accommodation.setImageUrl("www.slike.com");
            accommodation.setPersonCount(random.nextInt(11) + 1);
        }

        //reservationService.addAll(reservations);
        locationService.addAll(locations);
        accommodationService.addAll(accommodations);*/


    }
}
