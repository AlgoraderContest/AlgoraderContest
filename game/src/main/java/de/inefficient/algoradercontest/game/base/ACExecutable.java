package de.inefficient.algoradercontest.game.base;

import de.inefficient.algoradercontest.game.algorader.ACAlgorader;
import de.inefficient.algoradercontest.game.game.api.ACGame;

/**
 * Created by hendrik on 15.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.2
 */
public interface ACExecutable {
    void execute(ACAlgorader algorader, ACGame game);
}
