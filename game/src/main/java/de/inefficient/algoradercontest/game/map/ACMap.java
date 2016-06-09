package de.inefficient.algoradercontest.game.map;

import de.inefficient.algoradercontest.game.base.ACRunnable;
import de.inefficient.algoradercontest.game.map.field.ACField;
import de.inefficient.algoradercontest.game.map.field.ACPlainField;

/**
 * Created by hendrik on 15.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public class ACMap implements ACRunnable {
    private ACField fields[][];
    private ACMapOptions options;

    public ACMap(int width, int height, ACMapOptions options) {
        this.options = options;
        fields = new ACField[width][height];
        for (int x = 0; x < fields.length; x++) {
            for (int y = 0; y < fields[x].length; y++) {
                fields[x][y] = new ACPlainField(x, y);
            }
        }
    }

    @Override
    public void run() {

    }

    public ACMapOptions getOptions() {
        return options;
    }
}
