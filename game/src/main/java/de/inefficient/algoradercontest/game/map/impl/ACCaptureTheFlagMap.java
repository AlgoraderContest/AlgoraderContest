package de.inefficient.algoradercontest.game.map.impl;

import de.inefficient.algoradercontest.game.game.api.ACGameType;
import de.inefficient.algoradercontest.game.map.ACMap;
import de.inefficient.algoradercontest.game.map.field.ACField;
import de.inefficient.algoradercontest.game.map.field.ACPlainField;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by samuel on 14.06.16.
 */
public class ACCaptureTheFlagMap extends ACMap {
    public ACCaptureTheFlagMap(int width, int height) {
        super(ACGameType.CAPTURE_THE_FLAG, width, height);
    }

    @Override
    protected List<Class<? extends ACField>> getSupportedFields() {
        return asList(ACPlainField.class);
    }
}
