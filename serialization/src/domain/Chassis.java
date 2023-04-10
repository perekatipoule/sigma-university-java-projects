package domain;

public class Chassis {
    private Wheel wheel;
    private int wheelNumber;

    public Chassis(Wheel wheel, int wheelNumber) {
        this.wheel = wheel;
        this.wheelNumber = wheelNumber;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public int getWheelNumber() {
        return wheelNumber;
    }

    @Override
    public String toString() {
        return "domain.Chassis{" +
                wheel +
                ", wheelNumber=" + wheelNumber +
                "}";
    }
}
