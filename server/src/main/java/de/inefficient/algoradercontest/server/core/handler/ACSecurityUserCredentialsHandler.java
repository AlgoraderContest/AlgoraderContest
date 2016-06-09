package de.inefficient.algoradercontest.server.core.handler;

import de.inefficient.algoradercontest.server.config.management.ACSecurityUserCredentials;
import de.inefficient.algoradercontest.server.persistence.domain.ACUser;
import de.inefficient.algoradercontest.server.persistence.service.ACUserPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
@Component
public class ACSecurityUserCredentialsHandler implements UserDetailsService {
    @Autowired
    private ACUserPersistenceService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ACUser> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            return new ACSecurityUserCredentials(user.get().getId(), user.get().getUsername(), user.get().getPassword());
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}