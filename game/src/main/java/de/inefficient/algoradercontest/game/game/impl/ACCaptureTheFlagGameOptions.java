package de.inefficient.algoradercontest.game.game.impl;

import de.inefficient.algoradercontest.game.game.api.ACTeamGameOptions;

/**
 * Created by hendrik on 26.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public class ACCaptureTheFlagGameOptions implements ACTeamGameOptions {
    private int maxTeams;
    private int maxPlayersPerTeam;

    public ACCaptureTheFlagGameOptions(int maxTeams, int maxPlayersPerTeam) {
        this.maxTeams = maxTeams;
        this.maxPlayersPerTeam = maxPlayersPerTeam;
    }

    @Override
    public int getMaxTeams() {
        return maxTeams;
    }

    @Override
    public int getMaxPlayersPerTeam() {
        return maxPlayersPerTeam;
    }
}
