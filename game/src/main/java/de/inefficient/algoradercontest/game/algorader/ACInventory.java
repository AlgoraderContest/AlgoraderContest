package de.inefficient.algoradercontest.game.algorader;

import de.inefficient.algoradercontest.game.map.item.ACObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hendrik on 26.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public class ACInventory {
    private List<ACObject> objects;
    private int size;

    public ACInventory(int size) {
        this.objects = new ArrayList<>();
        this.size = size;
    }
}
