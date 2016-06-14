package de.inefficient.algoradercontest.server.core;

import de.inefficient.algoradercontest.game.game.api.ACGame;
import de.inefficient.algoradercontest.game.game.api.ACGameState;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Created by samuel on 13.02.16.
 *
 * @author samuel
 * @version 0.1
 */
@Component
public class ACGameRepository {
    private Map<String, ACGame> games;

    public ACGameRepository() {
        games = new HashMap<>();
    }

    public void addGame(ACGame game) {
        games.put(game.getId(), game);
    }

    public List<ACGame> getGames() {
        return new ArrayList<>(games.values());
    }

    public List<ACGame> getOpenGames() {
        return getGames().stream().filter(game -> game.getState() == ACGameState.OPEN).collect(toList());
    }
}