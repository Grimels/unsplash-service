package com.grimels.image.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.grimels.image.config"})
public class ImageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageServiceApplication.class, args);
    }

}
