package de.inefficient.algoradercontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by samuel on 07.02.16.
 */
@SpringBootApplication
@ComponentScan("de.inefficient.algoradercontest")
public class AlgoraderContestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlgoraderContestApplication.class, args);
    }
}