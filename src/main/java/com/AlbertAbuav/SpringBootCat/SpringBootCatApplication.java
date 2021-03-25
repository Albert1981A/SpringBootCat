package com.AlbertAbuav.SpringBootCat;

import com.AlbertAbuav.SpringBootCat.beens.Cat;
import com.AlbertAbuav.SpringBootCat.repos.CatRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication  // ==> @Configuration + @ComponentScan(basePackages = "com.AlbertAbuav.SpringBootCat") + @ConfigurationScan
@EnableScheduling  // ==> Will execute the "DailyTask"
public class SpringBootCatApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootCatApplication.class, args);
		System.out.println("Ioc Container was loaded!");
		System.out.println();

		// This is the DAO = new DBDAO
		CatRepository catRepository = ctx.getBean(CatRepository.class);

		Cat c1 = new Cat("MitziJ", 1.5f);
		Cat c2 = Cat.builder().name("PitziJ").weight(2.4f).build();
		Cat c3 = new Cat("LitziJ", 3.1f);

		System.out.println("The cats before entering the DB");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		System.out.println();

		/**
		 * Adding cats to the Table
		 */
//		catRepository.save(c1);
//		catRepository.save(c2);
//		catRepository.save(c3);
		catRepository.saveAll(Arrays.asList(c1, c2, c3));

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
