package com.AlbertAbuav.SpringBootCat.clr;

import com.AlbertAbuav.SpringBootCat.beens.Cat;
import com.AlbertAbuav.SpringBootCat.beens.Chip;
import com.AlbertAbuav.SpringBootCat.beens.Toy;
import com.AlbertAbuav.SpringBootCat.repos.CatRepository;
import com.AlbertAbuav.SpringBootCat.repos.ChipRepository;
import com.AlbertAbuav.SpringBootCat.repos.ToyRepository;
import com.AlbertAbuav.SpringBootCat.utils.ArtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
@Order(4)
public class CatAndToyUseCase implements CommandLineRunner {

    private final CatRepository catRepository;
    private final ChipRepository chipRepository;
    private final ToyRepository toyRepository;

    public void run(String... args) throws Exception {

        System.out.println();
        System.out.println(ArtUtils.CatAndToyUseCase);

        Toy t1 = new Toy("Ball");
        Toy t2 = new Toy("Muse");

        toyRepository.save(t1);
        toyRepository.save(t2);

        Chip chip1 = new Chip();

        Cat c1 = Cat.builder()
                .name("Bella")
                .weight(4.6f)
                .chip(chip1)
                .toys(new ArrayList<>())
                .build();

        c1.addToy(t1);
        c1.addToy(t2);

        catRepository.save(c1);

    }
}
