package ru.accident;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccidentApplication {
    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/car_accident");
        SpringApplication.run(AccidentApplication.class, args);
    }
}
