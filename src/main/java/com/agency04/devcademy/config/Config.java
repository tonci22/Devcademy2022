package com.agency04.devcademy.config;

import com.agency04.devcademy.domain.Owner;
import com.agency04.devcademy.service.MobileHomeAccommodationService;
import com.agency04.devcademy.service.RoomAccommodationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:accommodation.owner.properties")
@PropertySource("classpath:ara.properties")
@ImportResource("classpath:config.xml")
@Configuration
public class Config {

    @Bean("roomAccommodationService")
    RoomAccommodationService accommodationService(){
        return new RoomAccommodationService();
    }

    @Bean("owner")
    Owner owner(@Value("${name}") String name, @Value("${facebook}") String facebook,@Value("${instagram}") String instagram){
        Owner owner = new Owner();
        owner.setName(name);
        owner.setFacebook(facebook);
        owner.setInstagram(instagram);
        return owner;
    }
}
