package com.agency04.devcademy.mapper;

import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import com.agency04.devcademy.dto.response.LocationDtoResponse;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDtoResponse mapToDto(Location location);
    Collection<LocationDtoResponse> mapToDto(Collection<Location> locations);
    LocationDtoResponse mapToDto(LocationCreateDto locationCreateDto);
    Location mapToDtoLocation(LocationCreateDto locationCreateDto);
    LocationCreateDto mapToDtoLocation(Location location);
    Location mapToDtoCreate(LocationCreateDto location);
    Location mapToDto(LocationDtoResponse locationDtoResponse);
}
