package de.inefficient.algoradercontest.game.game.api;

import de.inefficient.algoradercontest.game.map.ACMap;
import de.inefficient.algoradercontest.game.base.ACPlayer;

import java.util.List;
import java.util.UUID;

/**
 * Created by samuel on 13.02.16.
 * @author samuel
 * @author hendrik
 * @version 0.2
 */
public abstract class ACGame {
    private String id;
    private String name;
    private ACGameType type;
    private ACGameOptions options;
    private ACMap map;

    protected ACGameState state;

    public ACGame(String name, ACGameType type, ACMap map, ACGameOptions options) {
        if (!map.getGameType().equals(type)) {
            throw new IllegalArgumentException("Invalid map!");
        }
        this.id = UUID.randomUUID().toString();
        this.state = ACGameState.OPEN;
        this.name = name;
        this.type = type;
        this.map = map;
        this.options = options;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ACGameType getType() {
        return type;
    }

    public ACGameState getState() {
        return state;
    }

    public ACGameOptions getOptions() {
        return options;
    }

    public abstract List<ACPlayer> getPlayers();
}