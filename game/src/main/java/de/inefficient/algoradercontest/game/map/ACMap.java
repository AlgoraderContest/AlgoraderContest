package de.inefficient.algoradercontest.game.map;

import de.inefficient.algoradercontest.game.base.ACRunnable;
import de.inefficient.algoradercontest.game.game.api.ACGameType;
import de.inefficient.algoradercontest.game.map.field.ACField;
import de.inefficient.algoradercontest.game.map.field.ACPlainField;

import java.util.List;

/**
 * Created by hendrik on 15.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public abstract class ACMap implements ACRunnable {
    private ACGameType gameType;
    private ACField fields[][];

    public ACMap(ACGameType gameType, int width, int height) {
        this.gameType = gameType;
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

    protected abstract List<Class<? extends ACField>> getSupportedFields();

    protected boolean isFieldSupported(ACField field) {
        return getSupportedFields().contains(field.getClass());
    }

    public ACGameType getGameType() {
        return gameType;
    }
}
