package ru.itis.dis301.market.central;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainCentral {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainCentral.class, args);
    }
}
