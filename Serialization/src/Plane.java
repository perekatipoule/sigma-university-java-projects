import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Plane extends Vehicle implements Serializable, Comparable<Plane>  {
    private String model;
    private int range;
    private transient Chassis chassis;
    private int speedCopy;
    private int producedYearCopy;
    private String engineTypeCopy;
    private int enginePowerCopy;

    public Plane(int speed, int producеdYear, Engine engine,
                 String model, int range, Chassis chassis) {
        super(speed, producеdYear, engine);
        this.model = model;
        this.range = range;
        this.chassis = chassis;
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
            os.defaultWriteObject();
            os.writeInt(chassis.getWheel().getLoad());
            os.writeInt(chassis.getWheel().getDiameter());
            os.writeInt(chassis.getWheelNumber());
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException{
            is.defaultReadObject();
            int load = is.readInt();
            int diameter = is.readInt();
            int wheelNumber = is.readInt();
            chassis = new Chassis(new Wheel(load, diameter), wheelNumber);
    }

    public void setSpeedCopy(int speedCopy) {
        this.speedCopy = speedCopy;
    }

    public void setProducedYearCopy(int producedYearCopy) {
        this.producedYearCopy = producedYearCopy;
    }

    public void setEngineTypeCopy(String engineTypeCopy) {
        this.engineTypeCopy = engineTypeCopy;
    }

    public void setEnginePowerCopy(int enginePowerCopy) {
        this.enginePowerCopy = enginePowerCopy;
    }

    public int getSpeedCopy() {
        return speedCopy;
    }

    public int getProducedYearCopy() {
        return producedYearCopy;
    }

    public String getEngineTypeCopy() {
        return engineTypeCopy;
    }

    public int getEnginePowerCopy() {
        return enginePowerCopy;
    }

    public int compareTo(Plane comparedPlane) {
        return this.getProducеdYear() - comparedPlane.getProducеdYear();
    }

    @Override
    public String toString() {
        return "Plane model='" + model + '\'' +
                ", range=" + range +
                "km, " + chassis + ", " +
                super.toString();
    }
}
