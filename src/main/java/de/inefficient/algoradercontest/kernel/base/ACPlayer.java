package de.inefficient.algoradercontest.kernel.base;

import de.inefficient.algoradercontest.kernel.algorader.ACAlgorader;
import de.inefficient.algoradercontest.web.details.ACUserDetails;

/**
 * Created by samuel on 14.02.16.
 * @author samuel
 * @author hendrik
 * @version 0.2
 */
public class ACPlayer {
    private ACAlgorader algorader;
    private ACUserDetails user;

    public ACPlayer(ACAlgorader algorader, ACUserDetails user) {
        this.algorader = algorader;
        this.user = user;
    }

    public ACAlgorader getAlgorader() {
        return algorader;
    }

    public ACUserDetails getUser() {
        return user;
    }
}