package de.inefficient.algoradercontest.game.map.field;

import de.inefficient.algoradercontest.game.algorader.ACAlgorader;
import de.inefficient.algoradercontest.game.base.ACRunnable;
import de.inefficient.algoradercontest.game.map.ACMapElement;

/**
 * Created by hendrik on 15.02.2016.
 * @author hendrik
 * @version 0.1
 */
public abstract class ACField extends ACMapElement implements ACRunnable {
    public ACField(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void run() {
    }

    public boolean enter(ACAlgorader algorader) {
        return true;
    }
}
