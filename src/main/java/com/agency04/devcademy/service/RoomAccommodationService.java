package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public class RoomAccommodationService implements AccommodationService{
    @Override
    public Accommodation getById(Long id) {
        return null;
    }

    @Override
    public List<Accommodation> findByCategorizationAndPersonCountGreaterThanEqual(Integer categorization, Integer personCount) {
        return null;
    }

    @Override
    public Accommodation add(AccommodationCreateDto accommodation) {
        return null;
    }

    @Override
    public List<Accommodation> addAll(List<Accommodation> accommodations) {
        return null;
    }

    @Override
    public Set<Accommodation> randomizeAccommodations() {
        return null;
    }

    @Override
    public List<Accommodation> getAll() {
        return null;
    }

    @Override
    public Accommodation updateAccommodation(Long id, AccommodationUpdateDto accommodation) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Byte[] saveImageFile(Long id, MultipartFile multipartFile) {
        return new Byte[0];
    }
}
