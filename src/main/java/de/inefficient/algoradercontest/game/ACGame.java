package de.inefficient.algoradercontest.game;

import java.util.List;
import java.util.UUID;
import java.util.zip.ZipFile;

/**
 * Created by samuel on 13.02.16.
 * @author samuel
 * @author hendrik
 * @version 0.1
 */
public abstract class ACGame {
    // TODO add map
    private String id;
    private String name;
    private ACGameType type;
    private ACGameState state;
    private ACMap map;
    private ACGameOptions options;

    public ACGame(String name, ACGameType type, ACGameOptions options) {
        this.id = UUID.randomUUID().toString();
        this.state = ACGameState.OPEN;
        this.name = name;
        this.type = type;
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