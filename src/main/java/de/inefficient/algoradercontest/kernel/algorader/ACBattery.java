package de.inefficient.algoradercontest.kernel.algorader;

/**
 * Created by hendrik on 26.02.2016.
 * @author hendrik
 * @author samuel
 * @version 0.1
 */
public class ACBattery {
    private int energy;
    private int capacity;
    private ACPower power;

    public ACBattery(int capacity) {
        this.capacity = capacity;
        chargeCompletely();
    }

    public void chargeCompletely() {
        charge(capacity);
    }

    public void charge(int energy) {
        throwExceptionIfEnergyNotPositive(energy);
        this.energy += energy;
        if (this.capacity < this.energy) {
            this.energy = capacity;
        }
        resumeEnergy();
    }

    public void discharge(int energy) {
        throwExceptionIfEnergyNotPositive(energy);
        this.energy -= energy;
        if (this.energy < 0) {
            this.energy = 0;
            suspendEnergy();
        }
    }

    public void suspendEnergy() {
        power = ACPower.OFF;
    }

    public void resumeEnergy() {
        if (energy > 0) {
            power = ACPower.ON;
        }
    }

    public ACPower getPower() {
        return power;
    }

    public int getEnergy() {
        return energy;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    private void throwExceptionIfEnergyNotPositive(int energy) {
        if (energy <= 0) {
            throw new IllegalArgumentException("Energy must be higher than 0");
        }
    }
}
