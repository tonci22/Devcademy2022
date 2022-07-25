package com.agency04.devcademy.bootstrap;

import com.agency04.devcademy.api.accomodation.Accommodation;
import com.agency04.devcademy.repositories.AccommodationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AccommodationRepository accommodationRepository;

    public BootStrapData(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Accommodation accommodation = new Accommodation("title","subtitle", "opis", 3,5,
                new URL("https://q-xx.bstatic.com/xdata/images/hotel/840x460/95024620.jpg?k=df17293ee20498e7a4bd952c3df0d527eb111fc6ca10a78c5601229eb60752be&o="),
                true,150);

        accommodationRepository.save(accommodation);
    }
}
