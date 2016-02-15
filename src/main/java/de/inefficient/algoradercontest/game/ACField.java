package de.inefficient.algoradercontest.game;

/**
 * Created by u16l89 on 15.02.2016.
 */
public abstract class ACField extends ACMapElement implements ACRunnable {
    public ACField(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void run() {
    }
}
