package de.inefficient.algoradercontest.kernel.game.impl;

import de.inefficient.algoradercontest.kernel.game.api.ACGameType;
import de.inefficient.algoradercontest.kernel.game.api.ACTeamGame;

/**
 * Created by hendrik on 26.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public class ACCaptureTheFlagGame extends ACTeamGame {
    public ACCaptureTheFlagGame(String name, ACCaptureTheFlagGameOptions options) {
        super(name, ACGameType.CAPTURE_THE_FLAG, options);
    }
}
