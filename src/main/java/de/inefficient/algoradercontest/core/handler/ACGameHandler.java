package de.inefficient.algoradercontest.core.handler;

import de.inefficient.algoradercontest.core.service.ACGameService;
import de.inefficient.algoradercontest.core.transformer.ACGameTransformer;
import de.inefficient.algoradercontest.kernel.game.ACGameRepository;
import de.inefficient.algoradercontest.transport.response.ACGetGameListResponse;
import de.inefficient.algoradercontest.transport.response.ACResponse;
import de.inefficient.algoradercontest.web.details.ACGameDetails;
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
