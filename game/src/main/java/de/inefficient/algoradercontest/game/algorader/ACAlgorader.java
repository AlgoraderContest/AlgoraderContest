package de.inefficient.algoradercontest.game.algorader;

import de.inefficient.algoradercontest.game.game.api.ACGame;
import de.inefficient.algoradercontest.game.map.ACMapElement;

/**
 * Created by hendrik on 26.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public class ACAlgorader extends ACMapElement {
    public static final int DEFAULT_PROGRAM_LENGTH = 3;
    public static final int DEFAULT_INVENTORY_SIZE = 7;
    public static final int DEFAULT_BATTERY_CAPACITY = 5;

    private ACProgram program;
    private ACInventory inventory;
    private ACBattery battery;

    public ACAlgorader() {
        program = new ACProgram(DEFAULT_PROGRAM_LENGTH);
        inventory = new ACInventory(DEFAULT_INVENTORY_SIZE);
        battery = new ACBattery(DEFAULT_BATTERY_CAPACITY);
    }

    public void execute(ACGame game) {
        if (battery.getPower() == ACPower.ON) {
            program.execute(this, game);
        }
    }
}
