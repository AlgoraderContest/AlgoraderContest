package de.inefficient.algoradercontest.persistence.handler;

import de.inefficient.algoradercontest.persistence.domain.ACUser;
import de.inefficient.algoradercontest.persistence.repository.ACUserRepository;
import de.inefficient.algoradercontest.persistence.service.ACUserPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.ofNullable;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
@Component
public class ACUserPersistenceHandler implements ACUserPersistenceService {
    @Autowired
    private ACUserRepository userRepository;

    @Override
    public Optional<ACUser> saveUser(ACUser ACUser) {
        if (ACUser.getId() == null) {
            ACUser.setId(UUID.randomUUID().toString());
        }
        ACUser savedACUser = userRepository.save(ACUser);
        return ofNullable(savedACUser);
    }

    @Override
    public void deleteUser(ACUser ACUser) {
        userRepository.delete(ACUser);
    }

    @Override
    public Optional<ACUser> getUser(String id) {
        return ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<ACUser> getUserByUsername(String username) {
        return ofNullable(userRepository.findByUsernameIgnoreCase(username));
    }
}