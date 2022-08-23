package com.agency04.devcademy.mapper;

import com.agency04.devcademy.domain.User;
import com.agency04.devcademy.dto.request.UserCreateDto;
import com.agency04.devcademy.dto.request.UserUpdateDto;
import com.agency04.devcademy.dto.response.UserDtoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToDto(UserCreateDto userCreateDto);
    User mapToDto(Long id, UserUpdateDto userUpdateDto);
    UserDtoResponse mapToDto(User user);
    UserCreateDto mapToDtoUser(User user);
    List<UserDtoResponse> mapToDto(List<User> users);
    User mapToDto(UserUpdateDto userUpdateDto);
}
