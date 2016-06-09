package de.inefficient.algoradercontest.server.core.handler;

import de.inefficient.algoradercontest.server.core.service.ACGameService;
import de.inefficient.algoradercontest.server.core.transformer.ACGameTransformer;
import de.inefficient.algoradercontest.server.core.ACGameRepository;
import de.inefficient.algoradercontest.server.web.details.ACGameDetails;
import de.inefficient.algoradercontest.server.transport.response.ACGetGameListResponse;
import de.inefficient.algoradercontest.server.transport.response.ACResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samuel on 14.02.16.
 */
@Component
public class ACGameHandler extends ACGameTransformer implements ACGameService {
    @Autowired
    private ACGameRepository gameRepository;

    @Override
    public ACResponse getGameListResponse() {
        List<ACGameDetails> gameDetailsList = new ArrayList<>();
        gameRepository.getGames().forEach(game -> gameDetailsList.add(toGameDetails(game)));
        return new ACGetGameListResponse(gameDetailsList);
    }
}
