package de.inefficient.algoradercontest.test.persistence.config;

import com.mongodb.Mongo;
import de.inefficient.algoradercontest.server.config.ACMongoConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by samuel on 16.05.16.
 */
public class ACTestMongoConfig extends ACMongoConfig {
    @Bean
    public MongoTemplate mongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, "algoradercontest_automated_test");
    }
}