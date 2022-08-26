package com.agency04.devcademy;

import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.enums.AccommodationType;
import com.agency04.devcademy.mapper.AccommodationMapper;
import com.agency04.devcademy.mapper.UserMapper;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.LocationService;
import com.agency04.devcademy.service.ReservationHistoryService;
import com.agency04.devcademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

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

        LocationCreateDto location = new LocationCreateDto("Lumbarda", "subtitl", 20263);


        AccommodationCreateDto accommodationCreateDto= new AccommodationCreateDto("Imagination","Imagination1", "Imagination2", 3, 6,new Byte[]{1,2,3,4});
        accommodationCreateDto.setType(AccommodationType.APARTMENT);
        accommodationCreateDto.setPrice(5);

        location.setAccommodations(List.of(accommodationCreateDto));

        locationService.add(location);
        locationService.addAccommodation(1L, accommodationCreateDto);
    }
}
