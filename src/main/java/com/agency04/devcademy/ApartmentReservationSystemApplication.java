package com.agency04.devcademy;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ApartmentReservationSystemApplication {

    private final AccommodationService accommodationService;

    public ApartmentReservationSystemApplication(@Qualifier("accommodationServiceImpl") AccommodationService accommodationRepository) {
        this.accommodationService = accommodationRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApartmentReservationSystemApplication.class, args);
    }

    @PostConstruct
    public void initData() {
        List<Accommodation> accommodations = new ArrayList<>() {
            {
                add(new Accommodation("title", "subtitle", "opis", 3, 5,
                        "https://www.picture.com", true, 545));
                add(new Accommodation("title1", "subtitle1", "opis1", 2, 2,
                        "https://www.picture.com", true, 223));
                add(new Accommodation("title2", "subtitle2", "opis", 1, 10,
                        "https://www.picture.com", false, 860));
            }
        };

        accommodationService.addAll(accommodations);
    }
}
