package domain;

import domain.Engine;

public class Vehicle {
    private int speed;
    private int producеdYear;
    private Engine engine;

    public Vehicle() {}

    public Vehicle(int speed, int producеdYear, Engine engine) {
        this.speed = speed;
        this.producеdYear = producеdYear;
        this.engine = engine;
    }

    public int getSpeed() {
        return speed;
    }

    public int getProducеdYear() {
        return producеdYear;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setProducеdYear(int producеdYear) {
        this.producеdYear = producеdYear;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "speed=" + speed +
                "km/h, producеdYear=" + producеdYear +
                ", " + engine;
    }
}
