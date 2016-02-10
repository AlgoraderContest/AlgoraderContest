package de.inefficient.algoradercontest.core.transformer;

import de.inefficient.algoradercontest.persistence.domain.ACUser;
import de.inefficient.algoradercontest.transport.request.ACRegisterUserRequest;
import de.inefficient.algoradercontest.web.details.ACUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
public class ACUserTransformer {
    @Autowired
    protected PasswordEncoder passwordEncoder;

    protected ACUser toUser(ACRegisterUserRequest request) {
        ACUser user = new ACUser();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        return user;
    }

    protected void updateUser(ACUser user, ACUserDetails userDetails) {
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setDisplayName(userDetails.getDisplayName());
    }

    protected Optional<ACUserDetails> toUserDetails(Optional<ACUser> user) {
        if (!user.isPresent()) {
            return empty();
        }
        ACUserDetails details = new ACUserDetails();
        details.setId(user.get().getId());
        details.setUsername(user.get().getUsername());
        details.setEmail(user.get().getEmail());
        details.setUsername(user.get().getUsername());
        details.setDisplayName(user.get().getDisplayName());
        return of(details);
    }
}