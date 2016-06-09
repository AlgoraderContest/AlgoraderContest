package de.inefficient.algoradercontest.game.game.api;

/**
 * Created by samuel on 13.02.16.
 * @author samuel
 * @version 0.1
 */
public enum ACGameType {
    CAPTURE_THE_FLAG("Capture The Flag", "Capture The Flag Beschreibung");

    private String name;
    private String description;

    ACGameType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}