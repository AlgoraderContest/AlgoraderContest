package de.inefficient.algoradercontest.server.core.handler;

import de.inefficient.algoradercontest.server.core.service.ACUserService;
import de.inefficient.algoradercontest.server.core.transformer.ACUserTransformer;
import de.inefficient.algoradercontest.server.core.validation.ACRegisterUserRequestValidator;
import de.inefficient.algoradercontest.server.persistence.domain.ACUser;
import de.inefficient.algoradercontest.server.persistence.service.ACUserPersistenceService;
import de.inefficient.algoradercontest.server.transport.response.ACUserRegisteredResponse;
import de.inefficient.algoradercontest.server.web.details.ACUserDetails;
import de.inefficient.algoradercontest.server.transport.request.ACRegisterUserRequest;
import de.inefficient.algoradercontest.server.transport.response.ACErrorResponse;
import de.inefficient.algoradercontest.server.transport.response.ACResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import java.util.Optional;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
@Component
public class ACUserHandler extends ACUserTransformer implements ACUserService {
    @Autowired
    private ACUserPersistenceService userService;

    @Autowired
    private ACRegisterUserRequestValidator validator;

    @Override
    public ACResponse registerUser(ACRegisterUserRequest request) {
        BindingResult result = new BeanPropertyBindingResult(request, request.getClass().getSimpleName());
        validator.validate(request, result);
        if (result.hasErrors()) {
            return new ACErrorResponse(result);
        }
        Optional<ACUser> user = userService.saveUser(toUser(request));
        Optional<ACUserDetails> userDetails = toUserDetails(user);
        return new ACUserRegisteredResponse(userDetails.get());
    }

    @Override
    public Optional<ACUserDetails> getUserDetailsByUsername(String username) {
        Optional<ACUser> user = userService.getUserByUsername(username);
        return toUserDetails(user);
    }

    @Override
    public Optional<ACUserDetails> getUserDetails(String id) {
        Optional<ACUser> user = userService.getUser(id);
        return toUserDetails(user);
    }
}