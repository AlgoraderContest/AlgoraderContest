package de.inefficient.algoradercontest.server.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import de.inefficient.algoradercontest.server.persistence.repository.ACUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by samuel on 07.02.16.
 * @author samuel
 * @version 0.1
 */
@Configuration
@EnableMongoRepositories(
        basePackages = "de.inefficient.algoradercontest.server.persistence.repository",
        includeFilters = @ComponentScan.Filter(
                value = {
                        ACUserRepository.class
                },
                type = FilterType.ASSIGNABLE_TYPE
        )
)
public class ACMongoConfig {
    @Bean
    public MongoTemplate mongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, "algoradercontest_v0");
    }

    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }
}