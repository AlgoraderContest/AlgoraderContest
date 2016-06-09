package de.inefficient.algoradercontest.test.data;

import de.inefficient.algoradercontest.server.persistence.domain.ACUser;
import de.inefficient.algoradercontest.server.web.details.ACUserDetails;

/**
 * Created by samuel on 17.05.16.
 */
public class ACTestUserFactory {
    public static final String TEST_ID = "bf2a2b0a-adca-4458-bf62-9464548736ce";
    public static final String TEST_USERNAME = "TestUser";
    public static final String TEST_PASSWORD = "Test1234";
    public static final String TEST_ENCODED_PASSWORD = "ENCODED_PASSWORD";
    public static final String TEST_EMAIL = "test@algoradercontest.de";

    public static ACUser testUserWithoutId() {
        ACUser user = new ACUser();
        user.setUsername(TEST_USERNAME);
        user.setPassword(TEST_ENCODED_PASSWORD);
        user.setEmail(TEST_EMAIL);
        return user;
    }

    public static ACUser testUser() {
        ACUser user = testUserWithoutId();
        user.setId(TEST_ID);
        return user;
    }

    public static ACUserDetails testUserDetails() {
        ACUserDetails userDetails = new ACUserDetails();
        userDetails.setId(TEST_ID);
        userDetails.setUsername(TEST_USERNAME);
        userDetails.setEmail(TEST_EMAIL);
        return userDetails;
    }
}