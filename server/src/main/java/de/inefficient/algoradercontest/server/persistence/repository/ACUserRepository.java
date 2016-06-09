package de.inefficient.algoradercontest.server.persistence.repository;

import de.inefficient.algoradercontest.server.persistence.domain.ACUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by samuel on 07.02.16.
 * @author samuel
 * @version 0.1
 */
public interface ACUserRepository extends CrudRepository<ACUser, String> {
    ACUser findByUsernameIgnoreCase(String username);
}