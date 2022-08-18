package com.agency04.devcademy.config;

import com.agency04.devcademy.service.RoomAccommodationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application-ara.properties")
@ImportResource("classpath:config.xml")
@Configuration
public class Config {

    @Value("${accommodation.owner}")
    private String accommodationOwner;

    @Value("${accommodation.owner.name}")
    private String accommodationOwnerName;

    @Value("${accommodation.owner.facebook}")
    private String accommodationOwnerFacebook;

    @Value("${accommodation.owner.instagram}")
    private String accommodationOwnerInstagram;

    @Bean("roomAccommodationService")
    RoomAccommodationService accommodationService() {
        return new RoomAccommodationService();
    }

}
