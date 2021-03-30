package com.AlbertAbuav.SpringBootCat.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class DailyTask {

    @Scheduled(fixedRate = 1000*3 /*1000*60*60*24*/)
    public void doTheThingEveryDay() {
        System.out.println("Moshe");
    }
}
