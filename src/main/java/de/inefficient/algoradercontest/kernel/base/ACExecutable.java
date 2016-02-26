package de.inefficient.algoradercontest.kernel.base;

import de.inefficient.algoradercontest.kernel.algorader.ACAlgorader;
import de.inefficient.algoradercontest.kernel.game.api.ACGame;

/**
 * Created by hendrik on 15.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.2
 */
public interface ACExecutable {
    void execute(ACAlgorader algorader, ACGame game);
}
