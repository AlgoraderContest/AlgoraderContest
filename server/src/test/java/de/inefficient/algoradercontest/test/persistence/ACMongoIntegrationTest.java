package de.inefficient.algoradercontest.test.persistence;

import de.inefficient.algoradercontest.server.persistence.domain.ACUser;
import de.inefficient.algoradercontest.server.persistence.handler.ACUserPersistenceHandler;
import de.inefficient.algoradercontest.test.persistence.config.ACTestMongoConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static de.inefficient.algoradercontest.test.data.ACTestUserFactory.testUser;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by samuel on 17.05.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ACTestMongoConfig.class, ACUserPersistenceHandler.class})
public class ACMongoIntegrationTest {
    @Autowired
    private MongoOperations mongo;

    @Before
    public void setUp() throws Exception {
        dropAll();
        testSetup();
    }

    @After
    public void tearDown() throws Exception {
        dropAll();
    }

    @Test
    public void emptyTestToPreventFail() {
        // Test to prevent fail of this class
    }

    private void testSetup() {
        mongo.insert(testUser());
        // TODO add all test domain objects
    }

    protected void dropAll() {
        mongo.dropCollection(ACUser.class);
    }

    protected ACUser findUser(String id) {
        return find(id, ACUser.class);
    }

    // TODO add methods to find domain objects in database

    private <T> T find(String id, Class<T> domainClass) {
        return mongo.findOne(new Query(where("_id").is(id)), domainClass);
    }
}