package com.agency04.devcademy.dto.mapper;

import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.dto.response.LocationDtoResponse;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class LocationMapper {

    @Autowired
    private AccommodationMapper accommodationMapper;

    public LocationDtoResponse mapToDto(Location location) {

        if(location == null)
            return null;

        LocationDtoResponse locationDtoRequest = new LocationDtoResponse();

        locationDtoRequest.setId(location.getId());
        locationDtoRequest.setTitle(location.getTitle());
        locationDtoRequest.setSubtitle(location.getSubtitle());
        locationDtoRequest.setPostalCode(location.getPostalCode());
        locationDtoRequest.setAccommodations(accommodationMapper.mapToDtoAccommodation(location.getAccommodations()));

        return locationDtoRequest;
    }

    public Collection<LocationDtoResponse> mapToDto(Collection<Location> locations) {

        List<LocationDtoResponse> locationDtoRequests = new ArrayList<>();

        for (Location location : locations) {
            locationDtoRequests.add(mapToDto(location));
        }
        return locationDtoRequests;
    }

    public LocationDtoResponse mapToDto(LocationCreateDto locationCreateDto) {

        LocationDtoResponse locationDtoRequest = new LocationDtoResponse();

        locationDtoRequest.setTitle(locationCreateDto.getTitle());
        locationDtoRequest.setSubtitle(locationCreateDto.getSubtitle());
        locationDtoRequest.setPostalCode(locationCreateDto.getPostalCode());

        return locationDtoRequest;
    }
    public Location mapToDtoLocation(LocationCreateDto locationCreateDto) {

        Location location = new Location();

        location.setTitle(locationCreateDto.getTitle());
        location.setSubtitle(locationCreateDto.getSubtitle());
        location.setPostalCode(locationCreateDto.getPostalCode());

        return location;
    }

    public LocationCreateDto mapToDtoLocation(Location location) {

        LocationCreateDto locationCreateDto = new LocationCreateDto();

        locationCreateDto.setTitle(location.getTitle());
        locationCreateDto.setSubtitle(location.getSubtitle());
        locationCreateDto.setPostalCode(location.getPostalCode());

        return locationCreateDto;
    }
}
