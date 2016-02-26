package de.inefficient.algoradercontest.kernel.game.api;

import de.inefficient.algoradercontest.kernel.util.ACColor;
import de.inefficient.algoradercontest.kernel.base.ACPlayer;
import de.inefficient.algoradercontest.kernel.base.ACTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hendrik on 26.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public abstract class ACTeamGame extends ACGame {
    private List<ACTeam> teams;

    public ACTeamGame(String name, ACGameType type, ACTeamGameOptions options) {
        super(name, type, options);
        teams = new ArrayList<>();
        for (int i = 0; i < options.getMaxTeams(); i++) {
            ACTeam team = new ACTeam("Team " + (i + 1), ACColor.generateRandom(), options.getMaxPlayersPerTeam());
            teams.add(team);
        }
    }

    @Override
    public List<ACPlayer> getPlayers() {
        List<ACPlayer> players = new ArrayList<>();
        teams.forEach(team -> players.addAll(team.getPlayers()));
        return players;
    }

    public List<ACTeam> getTeams() {
        return teams;
    }
}
