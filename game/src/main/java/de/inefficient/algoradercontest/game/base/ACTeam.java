package de.inefficient.algoradercontest.game.base;

import de.inefficient.algoradercontest.game.util.ACColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hendrik on 26.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public class ACTeam {
    private String name;
    private ACColor color;
    private int capacity;
    private List<ACPlayer> players;

    public ACTeam(String name, ACColor color, int capacity) {
        this.name = name;
        this.color = color;
        this.capacity = capacity;
        this.players = new ArrayList<>();
    }

    public boolean addPlayer(ACPlayer player) {
        if (players.size() >= capacity) {
            return false;
        }
        players.add(player);
        return true;
    }

    public void removePlayer(ACPlayer player) {
        players.remove(player);
    }

    public String getName() {
        return name;
    }

    public ACColor getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<ACPlayer> getPlayers() {
        return new ArrayList<>(players);
    }
}
