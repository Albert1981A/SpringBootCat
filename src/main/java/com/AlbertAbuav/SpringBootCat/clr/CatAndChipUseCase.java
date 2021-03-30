package com.AlbertAbuav.SpringBootCat.clr;

import com.AlbertAbuav.SpringBootCat.beens.Cat;
import com.AlbertAbuav.SpringBootCat.beens.Chip;
import com.AlbertAbuav.SpringBootCat.repos.CatRepository;
import com.AlbertAbuav.SpringBootCat.repos.ChipRepository;
import com.AlbertAbuav.SpringBootCat.utils.ArtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(3)
public class CatAndChipUseCase implements CommandLineRunner {

    private final CatRepository catRepository;
    private final ChipRepository chipRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println();
        System.out.println(ArtUtils.CatAndChipUseCase);

        Chip chip1 = new Chip();
        chipRepository.save(chip1);

        Cat c1 = Cat.builder()
                .name("Buffy")
                .weight(4.1f)
                .chip(chip1)
                .build();

        catRepository.save(c1);

    }
}
