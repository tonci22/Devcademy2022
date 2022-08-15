package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.User;
import com.agency04.devcademy.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    UserServiceImpl userService;
    ReservationService reservationService;
    @Mock
    UserRepository userRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        userService = new UserServiceImpl(userRepository, reservationService);
    }

    @Test
    void getAll() {
        User user = new User("test", "test1", "email_test");
        List<User> users = new ArrayList<>();
        users.add(user);

        when(userRepository.findAll()).thenReturn(users);

        assertEquals(1,userService.getAll().size());
    }
}