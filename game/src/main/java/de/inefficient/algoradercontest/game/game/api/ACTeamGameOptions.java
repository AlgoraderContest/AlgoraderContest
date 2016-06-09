package de.inefficient.algoradercontest.game.game.api;

/**
 * Created by hendrik on 26.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public interface ACTeamGameOptions extends ACGameOptions {
    @Override
    default int getMaxPlayers() {
        return getMaxTeams() * getMaxPlayersPerTeam();
    }

    int getMaxTeams();

    int getMaxPlayersPerTeam();
}
