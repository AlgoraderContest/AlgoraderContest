package de.inefficient.algoradercontest.game.algorader;

import de.inefficient.algoradercontest.game.algorader.command.ACCommand;
import de.inefficient.algoradercontest.game.game.api.ACGame;
import de.inefficient.algoradercontest.game.base.ACExecutable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hendrik on 26.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public class ACProgram implements ACExecutable {
    private List<ACCommand> commands;
    private int length;
    private int pointer;

    public ACProgram(int length) {
        this.length = length;
        commands = new ArrayList<>();
    }

    public void reset() {
        commands.clear();
        pointer = 0;
    }

    public boolean addCommand(ACCommand command) {
        if (length >= commands.size()) {
            return false;
        }
        commands.add(command);
        return true;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void execute(ACAlgorader algorader, ACGame game) {
        commands.get(pointer).execute(algorader, game);
        incrementPointer();
    }

    private void incrementPointer() {
        pointer = (pointer + 1) % commands.size();
    }
}
