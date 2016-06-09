package de.inefficient.algoradercontest.server.transport.request;

import static java.util.Arrays.stream;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
public abstract class ACRequest {
    public boolean isEmpty() {
        return stream(getClass().getDeclaredFields()).allMatch(field -> {
            field.setAccessible(true);
            try {
                return field.get(this) == null;
            } catch (IllegalAccessException e) {
                return false;
            }
        });
    }
}