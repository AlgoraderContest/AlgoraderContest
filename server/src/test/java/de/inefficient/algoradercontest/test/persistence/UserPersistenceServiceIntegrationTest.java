package de.inefficient.algoradercontest.test.persistence;

import de.inefficient.algoradercontest.server.persistence.domain.ACUser;
import de.inefficient.algoradercontest.server.persistence.service.ACUserPersistenceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static de.inefficient.algoradercontest.test.data.ACTestUserFactory.*;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by samuel on 17.05.16.
 */
public class UserPersistenceServiceIntegrationTest extends ACMongoIntegrationTest {
    @Autowired
    private ACUserPersistenceService userService;

    @Test
    public void shouldReturnUserById() throws Exception {
        assertThat(userService.getUser(TEST_ID), is(of(testUser())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorForNullId() throws Exception {
        userService.getUser(null);
    }

    @Test
    public void shouldReturnNullForEmptyId() throws Exception {
        assertThat(userService.getUser(""), is(empty()));
    }

    @Test
    public void shouldReturnUserByUsername() throws Exception {
        assertThat(userService.getUserByUsername(TEST_USERNAME), is(of(testUser())));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowErrorForNullUsername() throws Exception {
        userService.getUserByUsername(null);
    }

    @Test
    public void shouldReturnNullForEmptyUsername() throws Exception {
        assertThat(userService.getUserByUsername(""), is(empty()));
    }

    @Test
    public void shouldSaveNewUserAndAddId() throws Exception {
        ACUser create = testUserWithoutId();
        Optional<ACUser> created = userService.saveUser(create);
        assertTrue(created.isPresent());
        assertThat(created.get(), is(create));
        assertThat(findUser(created.get().getId()), is(created.get()));
    }

    @Test
    public void shouldSaveEditedUser() throws Exception {
        ACUser edit = findUser(TEST_ID);
        edit.setDisplayName("Spoozer Test User");
        Optional<ACUser> edited = userService.saveUser(edit);
        assertTrue(edited.isPresent());
        assertThat(edited.get(), is(edit));
        assertThat(findUser(TEST_ID), is(edited.get()));
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        ACUser delete = findUser(TEST_ID);
        userService.deleteUser(delete);
        assertNull(findUser(TEST_ID));
    }
}