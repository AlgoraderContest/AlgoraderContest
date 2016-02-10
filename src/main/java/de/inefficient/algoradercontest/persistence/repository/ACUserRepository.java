package de.inefficient.algoradercontest.persistence.repository;

import de.inefficient.algoradercontest.persistence.domain.ACUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by samuel on 07.02.16.
 * @author samuel
 * @version 0.1
 */
public interface ACUserRepository extends CrudRepository<ACUser, String> {
    ACUser findByUsernameIgnoreCase(String username);
}