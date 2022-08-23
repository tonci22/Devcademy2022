package com.agency04.devcademy.mapper;

import com.agency04.devcademy.domain.Role;
import com.agency04.devcademy.dto.response.RoleDtoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDtoResponse mapToDto(Role role);
}
