package org.example.View;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bike {
    public static void main(String[] args) {
        SpringApplication.run(Bike.class,args);
        System.out.println("Spring Boot Inicializado!");
    }
}
