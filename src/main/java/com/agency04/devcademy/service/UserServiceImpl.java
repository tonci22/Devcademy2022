package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.domain.User;
import com.agency04.devcademy.dto.mapper.AccommodationMapper;
import com.agency04.devcademy.dto.mapper.ReservationMapper;
import com.agency04.devcademy.dto.mapper.UserMapper;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.dto.request.UserCreateDto;
import com.agency04.devcademy.dto.request.UserUpdateDto;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ReservationService reservationService;

    private final AccommodationService accommodationService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private AccommodationMapper accommodationMapper;

    public UserServiceImpl(UserRepository userRepository, ReservationService reservationService, AccommodationService accommodationService) {
        this.userRepository = userRepository;
        this.reservationService = reservationService;
        this.accommodationService = accommodationService;
    }

    @Override
    public User add(UserCreateDto userCreateDto) {
        return userRepository.save(userMapper.mapToDto(userCreateDto));
    }

    @Override
    public List<User> addAll(List<UserCreateDto> userCreateDtos) {
        List<User> users = new ArrayList<>();
        for (UserCreateDto userCreateDto : userCreateDtos){
            users.add(userMapper.mapToDto(userCreateDto));
        }
        return userRepository.saveAll(users);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id not found"));
        User partial = userMapper.mapToDto(id,userUpdateDto);
        partial.setReservations(user.getReservations());
        return userRepository.save(partial);
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id not found"));
        userRepository.deleteById(id);
    }


    //reservation

    //todo - mora dodavati postojece accommodation-e, a ne kreirati nove
    @Override
    public User addReservation(Long id, Long idAccommodation, ReservationCreateDto reservationCreateDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id not found"));
        Reservation reservation = reservationMapper.mapDtoTo(reservationCreateDto);
        user.getReservations().add(reservation);
        return userRepository.save(user);
    }

    @Override
    public User updateReservation(Long idLocation, Long idReservation, ReservationUpdateDto reservationUpdateDto) {
        User user = userRepository.findById(idLocation).orElseThrow(() -> new ResourceNotFoundException("Location id not found"));
        reservationService.getById(idReservation);  //id validation check

        reservationService.updateReservation(idReservation,reservationUpdateDto);

        return userRepository.save(user);
    }
}
