package de.inefficient.algoradercontest.game;

/**
 * Created by u16l89 on 15.02.2016.
 */
public class ACMap implements ACRunnable {
    private  ACField fields[][];

    public ACMap(int width, int height) {
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
}
