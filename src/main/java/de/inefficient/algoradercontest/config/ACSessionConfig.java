package de.inefficient.algoradercontest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.SessionRepository;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
@Configuration
public class ACSessionConfig {
    @Bean
    public SessionRepository sessionRepository() {
        return new MapSessionRepository();
    }
}