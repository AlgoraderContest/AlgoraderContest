package de.inefficient.algoradercontest.game.map.field;

import de.inefficient.algoradercontest.game.map.item.ACItem;

/**
 * Created by hendrik on 15.02.2016.
 * @author hendrik
 * @version 0.1
 */
public class ACPlainField extends ACField {
    private ACItem item;

    public ACPlainField(int x, int y) {
        super(x, y);
    }

    public void setItem(ACItem item) {
        item.setCoordinates(getX(), getY());
        this.item = item;
    }

    public ACItem getItem() {
        return item;
    }
}
