package de.inefficient.algoradercontest.core.service;

import de.inefficient.algoradercontest.transport.request.ACRegisterUserRequest;
import de.inefficient.algoradercontest.transport.response.ACResponse;
import de.inefficient.algoradercontest.web.details.ACUserDetails;

import java.util.Optional;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
public interface ACUserService {
    Optional<ACUserDetails> getUserDetails(String id);

    Optional<ACUserDetails> getUserDetailsByUsername(String username);

    ACResponse registerUser(ACRegisterUserRequest registerUserRequest);
}
