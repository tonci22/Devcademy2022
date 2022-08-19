package com.agency04.devcademy.mapper;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.dto.response.AccommodationDtoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccommodationMapper {
    AccommodationDtoResponse mapToDto(Accommodation accommodation);
    List<AccommodationDtoResponse> mapToDto(List<Accommodation> accommodations);
    AccommodationCreateDto mapToDtoAccommodation(Accommodation accommodation);
    Accommodation mapToDtoAccommodation(AccommodationCreateDto accommodationCreateDto);
    Accommodation mapToDtoUpdate(Long id, AccommodationUpdateDto accommodationUpdateDto);
}
