package de.inefficient.algoradercontest.game;

/**
 * Created by u16l89 on 15.02.2016.
 */
public class ACPlainField extends ACField {
    private ACItem item;

    public ACPlainField(int x, int y) {
        super(x, y);
    }

    public void setItem(ACItem item) {
        item.setX(getX());
        item.setY(getY());
        this.item = item;
    }

    public ACItem getItem() {
        return item;
    }
}
