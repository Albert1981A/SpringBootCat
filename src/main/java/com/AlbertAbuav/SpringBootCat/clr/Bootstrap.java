package com.AlbertAbuav.SpringBootCat.clr;

import com.AlbertAbuav.SpringBootCat.beens.Cat;
import com.AlbertAbuav.SpringBootCat.repos.CatRepository;
import com.AlbertAbuav.SpringBootCat.utils.ArtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor // ==> He initialize the "catRepository" because the attribute is final!
@Order(1)  // ==> Will define the order in which the "CLR's" will run
public class Bootstrap implements CommandLineRunner {

    //    @Autowired
//    private ApplicationContext ctx;

//    @Autowired
//    private CatRepository catRepository;

    private final CatRepository catRepository;

    @Override
    public void run(String... args) throws Exception {

//        This is the DAO = new DBDAO
//        CatRepository catRepository = ctx.getBean(CatRepository.class);

        System.out.println();
        System.out.println(ArtUtils.Bootstrap1);

        Cat c1 = new Cat("MitziJ", 1.5f);
        Cat c2 = Cat.builder().name("PitziJ").weight(2.4f).build();
        Cat c3 = new Cat("LitziJ", 3.1f);
        Cat c4 = Cat.builder().name("DitziJ").weight(3.8f).build();
        Cat c5 = Cat.builder().name("BitziJ").weight(3.6f).build();
        Cat c6 = Cat.builder().name("VitziJ").weight(3.6f).build();
        Cat c7 = Cat.builder().name("KitziJ").weight(3.6f).build();

        System.out.println("The cats before entering the DB");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);

        System.out.println();

        /**
         * Adding cats to the Table
         */
//		catRepository.save(c1);
//		catRepository.save(c2);
//		catRepository.save(c3);
        catRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));

        System.out.println("The cats after entering the DB");
        catRepository.findAll().forEach(System.out::println);
        System.out.println("-------------------------------------");

        /**
         * Updating a cat
         */
        System.out.println("Update cat id - 2");
        Cat toUpdate = catRepository.getOne(2);
        toUpdate.setWeight(4f);
        catRepository.saveAndFlush(toUpdate);

        catRepository.findAll().forEach(System.out::println);
        System.out.println("-------------------------------------");

        /**
         * Deleting a cat
         */
        System.out.println("Delete cat id - 3");
        catRepository.deleteById(3);

        catRepository.findAll().forEach(System.out::println);
        System.out.println("-------------------------------------");
    }

}
