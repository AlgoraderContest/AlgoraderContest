package de.inefficient.algoradercontest.web.controller;

import de.inefficient.algoradercontest.core.service.ACGameService;
import de.inefficient.algoradercontest.game.ACGame;
import de.inefficient.algoradercontest.game.ACGameRepository;
import de.inefficient.algoradercontest.transport.response.ACErrorResponse;
import de.inefficient.algoradercontest.transport.response.ACResponse;
import de.inefficient.algoradercontest.transport.response.ACGetGameListResponse;
import de.inefficient.algoradercontest.web.session.ACSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by samuel on 14.02.16.
 */
@RestController
public class ACGameController {
    @Autowired
    private ACGameService gameService;

    @MessageMapping("/getGameList")
    @SendToUser("/setGameList")
    public ACResponse getGameListResponse(ACSession session) {
        if (!session.isUserLoggedIn()) {
            return new ACErrorResponse("Login required");
        }
        return gameService.getGameListResponse();
    }
}