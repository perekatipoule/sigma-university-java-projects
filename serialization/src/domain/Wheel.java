package domain;

public class Wheel {
    private int load;
    private int diameter;

    public Wheel(int load, int diameter) {
        this.load = load;
        this.diameter = diameter;
    }

    public int getLoad() {
        return load;
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return "domain.Wheel{" +
                "load=" + load +
                "t, diameter=" + diameter + "cm" +
                '}';
    }
}
