package com.agency04.devcademy.dto.mapper;

import com.agency04.devcademy.domain.Location;
import com.agency04.devcademy.dto.response.LocationDtoResponse;
import com.agency04.devcademy.dto.request.LocationCreateDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class LocationMapper {


    public LocationDtoResponse mapToDto(Location location) {

        LocationDtoResponse locationDtoRequest = new LocationDtoResponse();

        locationDtoRequest.setId(location.getId());
        locationDtoRequest.setName(location.getName());
        locationDtoRequest.setPostalCode(location.getPostalCode());

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

        locationDtoRequest.setId(locationDtoRequest.getId());
        locationDtoRequest.setName(locationCreateDto.getName());
        locationDtoRequest.setPostalCode(locationCreateDto.getPostalCode());

        return locationDtoRequest;
    }
}
