package de.inefficient.algoradercontest.game.map;

import de.inefficient.algoradercontest.game.map.field.ACField;
import de.inefficient.algoradercontest.game.game.api.ACGameType;

import java.util.List;

/**
 * Created by samuel on 03.03.16.
 */
public interface ACMapOptions {
    List<ACGameType> getSupportedGameTypes();

    default boolean isGameTypeSupported(ACGameType type) {
        return getSupportedGameTypes().contains(type);
    }

    List<Class<? extends ACField>> getSupportedFields();

    default boolean isFieldSupported(ACField field) {
        return getSupportedFields().contains(field.getClass());
    }

    // TODO items or objects and events
}
