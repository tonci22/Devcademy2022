package com.agency04.devcademy.controllers;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.service.AccommodationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AccommodationControllerTest {
    @Spy
    AccommodationService accommodationService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMockMvc() throws Exception{

        Set<Accommodation> accommodations = new HashSet<>();

        while (accommodations.size() < 10){
            accommodations.add(accommodationRandomizer());
        }

        when(accommodationService.randomizeAccommodations()).thenReturn(accommodations);

        assertEquals(accommodations, accommodationService.randomizeAccommodations());
    }

    private Accommodation accommodationRandomizer(){
        Random random = new Random();
        Accommodation accommodation = new Accommodation("titl","subtitl", "desc");
        accommodation.setId(random.nextLong(10));

        return accommodation;
    }
}