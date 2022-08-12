package com.agency04.devcademy.dto.mapper;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.dto.response.AccommodationDtoResponse;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccommodationMapper {

    public AccommodationDtoResponse mapToDto(Accommodation accommodation) {

        AccommodationDtoResponse accommodationCreateDtoRequest = new AccommodationDtoResponse();
        LocationMapper locationMapper = new LocationMapper();

        accommodationCreateDtoRequest.setId(accommodation.getId());
        accommodationCreateDtoRequest.setTitle(accommodation.getTitle());
        accommodationCreateDtoRequest.setSubtitle(accommodation.getSubtitle());
        accommodationCreateDtoRequest.setDescription(accommodation.getDescription());
        accommodationCreateDtoRequest.setCategorization(accommodation.getCategorization());
        accommodationCreateDtoRequest.setPersonCount(accommodation.getPersonCount());
        accommodationCreateDtoRequest.setImageUrl(accommodation.getImageUrl());
        accommodationCreateDtoRequest.setFreeCancelation(accommodation.isFreeCancelation());
        accommodationCreateDtoRequest.setPrice(accommodation.getPrice());
        accommodationCreateDtoRequest.setType(accommodation.getType());

        return accommodationCreateDtoRequest;
    }
    public AccommodationUpdateDto mapToDtoAccommodationUpdate(Accommodation accommodation) {

        AccommodationUpdateDto accommodationUpdateDto = new AccommodationUpdateDto();

        accommodationUpdateDto.setTitle(accommodation.getTitle());
        accommodationUpdateDto.setSubtitle(accommodation.getSubtitle());
        accommodationUpdateDto.setDescription(accommodation.getDescription());
        accommodationUpdateDto.setCategorization(accommodation.getCategorization());
        accommodationUpdateDto.setPersonCount(accommodation.getPersonCount());
        accommodationUpdateDto.setImageUrl(accommodation.getImageUrl());
        accommodationUpdateDto.setFreeCancelation(accommodation.isFreeCancelation());
        accommodationUpdateDto.setPrice(accommodation.getPrice());
        accommodationUpdateDto.setType(accommodation.getType());

        return accommodationUpdateDto;
    }

    public List<AccommodationDtoResponse> mapToDto(List<Accommodation> accommodations) {

        List<AccommodationDtoResponse> accommodationCreateDtoRequest = new ArrayList<>();

        for (Accommodation accommodation : accommodations) {
            accommodationCreateDtoRequest.add(mapToDto(accommodation));
        }

        return accommodationCreateDtoRequest;
    }

    public AccommodationCreateDto mapToDtoAccommodation(Accommodation accommodation) {

        AccommodationCreateDto accommodationCreateDto = new AccommodationCreateDto();

        accommodationCreateDto.setTitle(accommodation.getTitle());
        accommodationCreateDto.setSubtitle(accommodation.getSubtitle());
        accommodationCreateDto.setDescription(accommodation.getDescription());
        accommodationCreateDto.setCategorization(accommodation.getCategorization());
        accommodationCreateDto.setPersonCount(accommodation.getPersonCount());
        accommodationCreateDto.setImageUrl(accommodation.getImageUrl());
        accommodationCreateDto.setFreeCancelation(accommodation.isFreeCancelation());
        accommodationCreateDto.setPrice(accommodation.getPrice());
        accommodationCreateDto.setType(accommodation.getType());

        return accommodationCreateDto;
    }

    public Accommodation mapToDtoAccommodation(AccommodationCreateDto accommodationCreateDto) {

        Accommodation accommodation = new Accommodation();

        accommodation.setTitle(accommodationCreateDto.getTitle());
        accommodation.setSubtitle(accommodationCreateDto.getSubtitle());
        accommodation.setDescription(accommodationCreateDto.getDescription());
        accommodation.setCategorization(accommodationCreateDto.getCategorization());
        accommodation.setPersonCount(accommodationCreateDto.getPersonCount());
        accommodation.setImageUrl(accommodationCreateDto.getImageUrl());
        accommodation.setFreeCancelation(accommodationCreateDto.isFreeCancelation());
        accommodation.setPrice(accommodationCreateDto.getPrice());
        accommodation.setType(accommodationCreateDto.getType());

        return accommodation;
    }
    public List<Accommodation> mapToDtoAccommodationCreate(List<AccommodationCreateDto> accommodations) {

        List<Accommodation> accommodationCreateDtoRequest = new ArrayList<>();

        for (AccommodationCreateDto accommodation : accommodations) {
            accommodationCreateDtoRequest.add(mapToDtoAccommodation(accommodation));
        }

        return accommodationCreateDtoRequest;
    }

    public List<AccommodationDtoResponse> mapToDtoAccommodation(List<Accommodation> accommodations) {

        List<AccommodationDtoResponse> accommodationCreateDtoRequest = new ArrayList<>();

        for (Accommodation accommodation : accommodations) {
            accommodationCreateDtoRequest.add(mapToDto(accommodation));
        }

        return accommodationCreateDtoRequest;
    }
}
