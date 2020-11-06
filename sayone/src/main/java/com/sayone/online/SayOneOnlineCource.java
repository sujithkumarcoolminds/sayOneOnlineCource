package com.sayone.online;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SayOneOnlineCource {

    private static final Logger LOGGER= LogManager.getLogger(SayOneOnlineCource.class);

    public static void main(String[] args) {

        SpringApplication.run(SayOneOnlineCource.class, args);
        LOGGER.info("............Spring Boot DC APPLICATION Started Successfully............");

    }

}
