package de.inefficient.algoradercontest.web.controller;

import de.inefficient.algoradercontest.transport.response.ACErrorResponse;
import de.inefficient.algoradercontest.transport.response.ACGetUserResponse;
import de.inefficient.algoradercontest.transport.response.ACResponse;
import de.inefficient.algoradercontest.web.session.ACSession;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by samuel on 14.02.16.
 */
@RestController
public class ACUserController {
    @MessageMapping("/getUser")
    @SendToUser("/setUser")
    public ACResponse getUserResponse(ACSession session) {
        if (session.isUserLoggedIn()) {
            return new ACGetUserResponse(session.getUserDetails());
        }
        return new ACErrorResponse("Login required");
    }
}