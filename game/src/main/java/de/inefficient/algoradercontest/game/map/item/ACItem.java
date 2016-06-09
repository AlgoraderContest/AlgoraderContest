package de.inefficient.algoradercontest.game.map.item;

import de.inefficient.algoradercontest.game.map.ACMapElement;

/**
 * Created by hendrik on 15.02.2016.
 * @author hendrik
 * @version 0.1
 */
public abstract class ACItem extends ACMapElement {

    public void setCoordinates(int x, int y) {
        setX(x);
        setY(y);
    }
}
