package com.cinema.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SystemApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SystemApplication.class, args);
    }
}