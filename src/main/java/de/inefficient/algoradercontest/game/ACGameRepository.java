package de.inefficient.algoradercontest.game;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by samuel on 13.02.16.
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
}