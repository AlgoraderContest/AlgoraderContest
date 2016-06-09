package de.inefficient.algoradercontest.game.game.impl;

import de.inefficient.algoradercontest.game.game.api.ACGameType;
import de.inefficient.algoradercontest.game.game.api.ACTeamGame;
import de.inefficient.algoradercontest.game.map.ACMap;

/**
 * Created by hendrik on 26.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public class ACCaptureTheFlagGame extends ACTeamGame {
    public ACCaptureTheFlagGame(String name, ACMap map, ACCaptureTheFlagGameOptions options) {
        super(name, ACGameType.CAPTURE_THE_FLAG, map, options);
    }
}
