package com.agency04.devcademy.repositories;

import com.agency04.devcademy.ApartmentReservationSystemApplication;
import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.service.AccommodationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccommodationRepositoryIT {
    @Autowired
    AccommodationRepository accommodationRepository;

    @Test
    void findByCategorizationAndPersonCountGreaterThanEqual() {
        List<Accommodation> accommodations = accommodationRepository.findByCategorizationAndPersonCountGreaterThanEqual(3, 5);

        assertEquals(1, accommodations.size());
    }
}