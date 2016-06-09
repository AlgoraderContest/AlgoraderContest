package de.inefficient.algoradercontest.game.util;

import java.util.Random;

import static java.lang.Integer.toHexString;

/**
 * Created by hendrik on 26.02.2016.
 */
public class ACColor {
    public static ACColor generateRandom() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new ACColor(toHexString(red) + toHexString(green) + toHexString(blue));
    }

    private String color;

    /**
     * @param color in HTML format
     */
    public ACColor(String color) {
        // TODO validate
        this.color = color;
    }

    public String getColorString() {
        return color;
    }
}
