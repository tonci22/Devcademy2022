package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Accommodation;
import com.agency04.devcademy.dto.request.AccommodationCreateDto;
import com.agency04.devcademy.dto.request.AccommodationUpdateDto;
import com.agency04.devcademy.exception.BadRequestException;
import com.agency04.devcademy.exception.ResourceNotFoundException;
import com.agency04.devcademy.mapper.AccommodationMapper;
import com.agency04.devcademy.repositories.AccommodationRepository;
import com.agency04.devcademy.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Primary
@Service("accommodationServiceImpl")
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final LocationRepository locationRepository;

    @Autowired
    private AccommodationMapper accommodationMapper;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, LocationRepository locationRepository) {
        this.accommodationRepository = accommodationRepository;
        this.locationRepository = locationRepository;
    }


    @Override
    public Accommodation getById(Long id) {
        return accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accommodation not found"));
    }

    @Override
    public List<Accommodation> findByCategorizationAndPersonCountGreaterThanEqual(Integer categorization, Integer personCount) {
        return accommodationRepository.findByCategorizationAndPersonCountGreaterThanEqual(categorization, personCount);
    }

    @Override
    public Accommodation add(AccommodationCreateDto accommodationCreateDto) {

        Accommodation accommodation = accommodationMapper.mapToDtoAccommodation(accommodationCreateDto);
        accommodationRepository.save(accommodation);

        return accommodation;
    }

    @Override
    public List<Accommodation> addAll(List<Accommodation> accommodations) {
        return accommodationRepository.saveAll(accommodations);
    }

    @Override
    public Set<Accommodation> randomizeAccommodations() {
        if(accommodationRepository.findAll().size() < 10) {
            throw new BadRequestException("Number of Accommodations is less than 10");
        }

        Set<Accommodation> accommodations = new HashSet<>();
        Random random = new Random();
        while (accommodations.size() < 10) {
            accommodations.add(accommodationRepository.findAll().get(random.nextInt(accommodationRepository.findAll().size())));
        }
        return accommodations;
    }

    @Override
    public List<Accommodation> getAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Accommodation updateAccommodation(Long id, AccommodationUpdateDto accommodationUpdateDto) {
        accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accommodation ID not found"));

        Accommodation accommodation = accommodationMapper.mapToDtoUpdate(id, accommodationUpdateDto);

        accommodationRepository.save(accommodation);

        return accommodation;
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accommodation ID not found"));
        accommodationRepository.deleteById(id);
    }

    @Override
    public Byte[] saveImageFile(Long id, MultipartFile multipartFile) {
        try {
            Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accommodation ID not found"));

            Byte[] imageByte = new Byte[multipartFile.getBytes().length];

            for (int i = 0; i < multipartFile.getSize(); i++) {
                imageByte[i] = multipartFile.getBytes()[i];
            }

            accommodation.setImage(imageByte);

            accommodationRepository.save(accommodation);

            return accommodation.getImage();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
