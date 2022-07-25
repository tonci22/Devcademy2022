package com.agency04.devcademy.bootstrap;

import com.agency04.devcademy.api.accomodation.Accommodation;
import com.agency04.devcademy.repositories.AccommodationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.*;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AccommodationRepository accommodationRepository;

    public BootStrapData(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Accommodation> accommodation = new ArrayList<>() {
            {
                add(new Accommodation("title", "subtitle", "opis", 3, 5,
                        new URL("https://q-xx.bstatic.com/xdata/images/hotel/840x460/95024620.jpg?k=df17293ee20498e7a4bd952c3df0d527eb111fc6ca10a78c5601229eb60752be&o="),
                        true, 545));
                add(new Accommodation("title1", "subtitle1", "opis1", 2, 2,
                        new URL("https://q-xx.bstatic.com/xdata/images/hotel/840x460/95024620.jpg?k=df17293ee20498e7a4bd952c3df0d527eb111fc6ca10a78c5601229eb60752be&o="),
                        true, 223));
                add(new Accommodation("title2", "subtitle2", "opis", 1, 10,
                        new URL("https://q-xx.bstatic.com/xdata/images/hotel/840x460/95024620.jpg?k=df17293ee20498e7a4bd952c3df0d527eb111fc6ca10a78c5601229eb60752be&o="),
                        false, 860));
            }
        };
        for (Accommodation acc : accommodation) {
            accommodationRepository.save(acc);
            System.out.println(acc);
        }


            System.out.println("Number of entries: " + accommodationRepository.count());

    }
}
