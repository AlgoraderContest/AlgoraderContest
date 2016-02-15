package de.inefficient.algoradercontest.game;

import java.util.List;
import java.util.UUID;
import java.util.zip.ZipFile;

/**
 * Created by samuel on 13.02.16.
 * @author samuel
 * @version 0.1
 */
public abstract class ACGame {
    // TODO add map and state
    private String id;
    private String name;
    private ACGameType type;
    private ACGameOptions options;

    public ACGame(String name, ACGameType type, ACGameOptions options) {
        this.id = UUID.randomUUID().toString();
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

    public ACGameOptions getOptions() {
        return options;
    }

    public abstract List<ACPlayer> getPlayers();
}