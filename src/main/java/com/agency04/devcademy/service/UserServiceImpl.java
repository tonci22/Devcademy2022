package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.domain.User;
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
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    public UserServiceImpl(UserRepository userRepository, ReservationService reservationService) {
        this.userRepository = userRepository;
        this.reservationService = reservationService;
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
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id not found"));
        return userRepository.save(userMapper.mapToDto(id,userUpdateDto));
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id not found"));
        userRepository.deleteById(id);
    }


    //reservation

    @Override
    public User addReservation(Long id, ReservationCreateDto reservationCreateDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id not found"));
        Reservation reservation = reservationService.add(reservationCreateDto);
        user.getReservations().add(reservation);
        return userRepository.save(user);
    }

    @Override
    public User addReservation(Long id, List<ReservationCreateDto> reservationCreateDtos) {
        return null;
    }

    @Override
    public User updateReservation(Long idLocation, Long idReservation, ReservationUpdateDto reservationUpdateDto) {
        User user = userRepository.findById(idLocation).orElseThrow(() -> new ResourceNotFoundException("Location id not found"));
        reservationService.getById(idReservation);

        reservationService.updateReservation(idReservation,reservationUpdateDto);

        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long idUser, Long idReservation) {

    }
}
