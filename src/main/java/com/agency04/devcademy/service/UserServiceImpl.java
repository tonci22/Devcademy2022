package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Reservation;
import com.agency04.devcademy.domain.Role;
import com.agency04.devcademy.domain.User;
import com.agency04.devcademy.dto.request.ReservationCreateDto;
import com.agency04.devcademy.dto.request.ReservationUpdateDto;
import com.agency04.devcademy.dto.request.UserCreateDto;
import com.agency04.devcademy.dto.request.UserUpdateDto;
import com.agency04.devcademy.enums.RoleType;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.mapper.ReservationMapper;
import com.agency04.devcademy.mapper.UserMapper;
import com.agency04.devcademy.repositories.RoleRepository;
import com.agency04.devcademy.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ReservationService reservationService;
    private final RoleRepository roleRepository;
    private UserMapper userMapper;
    private ReservationMapper reservationMapper;

    @Override
    public User add(UserCreateDto userCreateDto) {

        Role role = roleRepository.findByName(RoleType.ROLE_USER.toString());
        User user = userMapper.mapToDto(userCreateDto);
        user.setRoles(List.of(role));
        userRepository.save(user);
        return user;
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
        User partial = userMapper.mapToDto(userUpdateDto);
        partial.setId(id);
        partial.setReservations(user.getReservations());
        return userRepository.save(partial);
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id not found"));
        userRepository.deleteById(id);
    }



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
        reservationService.getById(idReservation);

        reservationService.updateReservation(idReservation,reservationUpdateDto);

        return userRepository.save(user);
    }
}
