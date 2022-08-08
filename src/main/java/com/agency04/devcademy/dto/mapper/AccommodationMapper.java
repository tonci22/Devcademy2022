package com.agency04.devcademy.dto.mapper;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.response.AccommodationDtoResponse;
import com.agency04.devcademy.dto.response.LocationDtoResponse;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.response.ReservationDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccommodationMapper {

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    public AccommodationDtoResponse mapToDto(Accommodation accommodation) {

        AccommodationDtoResponse accommodationCreateDtoRequest = new AccommodationDtoResponse();
        LocationDtoResponse locationDtoResponse = locationMapper.mapToDto(accommodation.getLocation());
        List<ReservationDtoResponse> reservationResponse =  reservationMapper.mapToDtoAccommodation(accommodation.getReservations());

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
        accommodationCreateDtoRequest.setLocation(locationDtoResponse);
        accommodationCreateDtoRequest.setReservation(reservationResponse);

        return accommodationCreateDtoRequest;
    }


    public List<AccommodationDtoResponse> mapToDto(List<Accommodation> accommodations) {

        List<AccommodationDtoResponse> accommodationCreateDtoRequest = new ArrayList<>();

        for (Accommodation accommodation : accommodations) {
            accommodationCreateDtoRequest.add(mapToDto(accommodation));
        }

        return accommodationCreateDtoRequest;
    }

    public AccommodationCreateDto mapToDto(AccommodationCreateDto accommodationCreateDto) {

        AccommodationCreateDto accommodation = new AccommodationCreateDto();

        accommodation.setId(accommodation.getId());
        accommodation.setTitle(accommodationCreateDto.getTitle());
        accommodation.setSubtitle(accommodationCreateDto.getSubtitle());
        accommodation.setDescription(accommodation.getDescription());
        accommodation.setCategorization(accommodationCreateDto.getCategorization());
        accommodation.setPersonCount(accommodationCreateDto.getPersonCount());
        accommodation.setImageUrl(accommodationCreateDto.getImageUrl());
        accommodation.setFreeCancelation(accommodationCreateDto.isFreeCancelation());
        accommodation.setPrice(accommodationCreateDto.getPrice());
        accommodation.setType(accommodationCreateDto.getType());
        accommodation.setLocation(accommodationCreateDto.getLocation());

        return accommodation;
    }
}
