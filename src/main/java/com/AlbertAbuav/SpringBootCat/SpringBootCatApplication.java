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



	}

}
