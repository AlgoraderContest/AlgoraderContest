package de.inefficient.algoradercontest.game.base;

import de.inefficient.algoradercontest.game.algorader.ACAlgorader;

/**
 * Created by samuel on 14.02.16.
 * @author samuel
 * @author hendrik
 * @version 0.2
 */
public class ACPlayer {
    private ACAlgorader algorader;

    public ACPlayer(ACAlgorader algorader) {
        this.algorader = algorader;
    }

    public ACAlgorader getAlgorader() {
        return algorader;
    }
}