package com.example.purplepeople;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/database.properties")
@SpringBootApplication
public class PurplepeopleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurplepeopleApplication.class, args);
    }

}
