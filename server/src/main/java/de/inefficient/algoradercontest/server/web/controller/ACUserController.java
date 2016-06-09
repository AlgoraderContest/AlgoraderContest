package de.inefficient.algoradercontest.server.web.controller;

import de.inefficient.algoradercontest.server.transport.response.ACGetUserResponse;
import de.inefficient.algoradercontest.server.web.session.ACSession;
import de.inefficient.algoradercontest.server.transport.response.ACErrorResponse;
import de.inefficient.algoradercontest.server.transport.response.ACResponse;
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