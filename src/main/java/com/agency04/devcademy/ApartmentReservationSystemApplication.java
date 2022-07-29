package com.agency04.devcademy;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.enums.AccommodationType;
import com.agency04.devcademy.service.AccommodationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
                add(new Accommodation("titl","subtit", "opis"));
                add(new Accommodation("titl1","subtit1", "opis1"));
                add(new Accommodation("titl2","subtit2", "opis2"));
            }
        };

        for (Accommodation accommodation: accommodations) {
            accommodation.setPrice(new Random().nextInt(999));
            accommodation.setType(AccommodationType.APARTMENT);
            accommodation.setFreeCancelation(false);
            accommodation.setCategorization(new Random().nextInt(4) + 1);
            accommodation.setImageUrl("www.slike.com");
            accommodation.setPersonCount(new Random().nextInt(11) + 1);
        }

        accommodationService.addAll(accommodations);
    }
}
