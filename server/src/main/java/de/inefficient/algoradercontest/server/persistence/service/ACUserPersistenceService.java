package de.inefficient.algoradercontest.server.persistence.service;

import de.inefficient.algoradercontest.server.persistence.domain.ACUser;

import java.util.Optional;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
public interface ACUserPersistenceService {
    Optional<ACUser> saveUser(ACUser ACUser);

    void deleteUser(ACUser ACUser);

    Optional<ACUser> getUser(String id);

    Optional<ACUser> getUserByUsername(String username);
}