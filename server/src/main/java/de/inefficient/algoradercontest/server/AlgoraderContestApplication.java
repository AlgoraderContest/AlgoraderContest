package de.inefficient.algoradercontest.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by samuel on 07.02.16.
 * @author samuel
 * @version 0.1
 */
@SpringBootApplication
@ComponentScan("de.inefficient.algoradercontest.server")
public class AlgoraderContestApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AlgoraderContestApplication.class, args);
        context.registerShutdownHook();
    }
}