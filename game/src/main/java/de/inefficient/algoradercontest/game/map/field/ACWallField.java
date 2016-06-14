package de.inefficient.algoradercontest.game.map.field;

import de.inefficient.algoradercontest.game.algorader.ACAlgorader;

/**
 * Created by JHW on 14.06.2016.
 */
public class ACWallField extends ACField {

    public ACWallField(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean enter(ACAlgorader algorader) {
        // TODO implement damage algorader
        // hendrik 14.06.2016
        return false;
    }
}
