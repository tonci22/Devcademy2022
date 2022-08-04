package com.agency04.devcademy.dto.mapper;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.dto.response.AccommodationDtoResponse;
import com.agency04.devcademy.dto.response.LocationDtoResponse;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AccommodationMapper {

    @Autowired
    private LocationMapper locationMapper;

    public AccommodationDtoResponse mapToDto(Accommodation accommodation, Location location){

        AccommodationDtoResponse accommodationCreateDtoRequest = new AccommodationDtoResponse();
        LocationDtoResponse locationDtoResponse = locationMapper.mapToDto(location);

        accommodationCreateDtoRequest.setId(accommodation.getId());
        accommodationCreateDtoRequest.setTitle(accommodation.getTitle());
        accommodationCreateDtoRequest.setSubtitle(accommodation.getSubtitle());
        accommodationCreateDtoRequest.setCategorization(accommodation.getCategorization());
        accommodationCreateDtoRequest.setPersonCount(accommodation.getPersonCount());
        accommodationCreateDtoRequest.setImageUrl(accommodation.getImageUrl());
        accommodationCreateDtoRequest.setFreeCancelation(accommodation.isFreeCancelation());
        accommodationCreateDtoRequest.setPrice(accommodation.getPrice());
        accommodationCreateDtoRequest.setType(accommodation.getType());
        accommodationCreateDtoRequest.setLocation(locationDtoResponse);

        return accommodationCreateDtoRequest;
    }


   public Collection<AccommodationDtoResponse> mapToDto(Collection<Accommodation> accommodations, Collection<Location> location){

        List<AccommodationDtoResponse> accommodationCreateDtoRequest = new ArrayList<>();

       for (int i = 0; i < accommodations.size(); i++) {
           accommodationCreateDtoRequest.add(mapToDto(accommodations.stream().toList().get(i), location.stream().toList().get(i)));
       }
       return accommodationCreateDtoRequest;
   }

   public AccommodationCreateDto mapToDto(AccommodationCreateDto accommodationCreateDto){

       AccommodationCreateDto accommodation = new AccommodationCreateDto();

        accommodation.setId(accommodation.getId());
        accommodation.setTitle(accommodationCreateDto.getTitle());
        accommodation.setSubtitle(accommodationCreateDto.getSubtitle());
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
