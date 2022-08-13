package com.agency04.devcademy.controllers;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.enums.AccommodationType;
import com.agency04.devcademy.repositories.AccommodationRepository;
import com.agency04.devcademy.repositories.LocationRepository;
import com.agency04.devcademy.service.AccommodationService;
import com.agency04.devcademy.service.AccommodationServiceImpl;
import com.agency04.devcademy.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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