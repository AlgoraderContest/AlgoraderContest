package de.inefficient.algoradercontest.persistence.repository;

import de.inefficient.algoradercontest.persistence.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by samuel on 07.02.16.
 * @author samuel
 * @version 0.1
 */
public interface UserRepository extends CrudRepository<User, String>{
}
