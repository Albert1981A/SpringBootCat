package com.AlbertAbuav.SpringBootCat.clr;

import com.AlbertAbuav.SpringBootCat.repos.CatRepository;
import com.AlbertAbuav.SpringBootCat.utils.ArtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(2)
public class Bootstrap2 implements CommandLineRunner {

    private final CatRepository catRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println();
        System.out.println(ArtUtils.Bootstrap2);

        System.out.println("-------------------------------------");
        catRepository.findByNameAndWeight("MitziJ",4f).forEach(System.out::println);
        System.out.println();
        System.out.println("-------------------------------------");
        catRepository.findByNameAndWeight("MitziJ",1.5f).forEach(System.out::println);
        System.out.println("-------------------------------------");
        catRepository.findByNameOrWeight("MitziJ",4f).forEach(System.out::println);
        System.out.println("-------------------------------------");
        catRepository.findByWeightGreaterThan(1.6f).forEach(System.out::println);
        System.out.println("-------------------------------------");
        catRepository.findByWeightLessThan(4f).forEach(System.out::println);
        System.out.println("-------------------------------------");


    }

}
