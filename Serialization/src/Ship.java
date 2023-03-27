import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Ship extends Vehicle implements Externalizable, Comparable<Ship> {
    private int displacement;
    private int length;
    private Boat boat;

    public Ship(){}

    public Ship(int speed, int producеdYear, Engine engine, int displacement, int length, Boat boat) {
        super(speed, producеdYear, engine);
        this.displacement = displacement;
        this.length = length;
        this.boat = boat;
    }

    @Override
    public void writeExternal(ObjectOutput out) {
        try {
            out.writeInt(displacement);
            out.writeInt(length);
            out.writeInt(boat.getPassengerNumber());
            out.writeObject(boat.getMaterial());
            out.writeInt(this.getSpeed());
            out.writeInt(this.getProducеdYear());
            out.writeObject(this.getEngine().getType());
            out.writeInt(this.getEngine().getPower());
        } catch (Exception e) {
            System.out.println("Ship writing failure");
        }
    }

    @Override
    public void readExternal(ObjectInput in) {
        try {
            displacement = in.readInt();
            length = in.readInt();
            boat = new Boat(in.readInt(), (String)in.readObject());
            this.setSpeed(in.readInt());
            this.setProducеdYear(in.readInt());
            this.setEngine(new Engine((String)in.readObject(), in.readInt()));
        } catch (Exception e) {
            System.out.println("Ship reading failure");
        }
    }

    public int compareTo(Ship comparedShip) {
        return this.getProducеdYear() - comparedShip.getProducеdYear();
    }

    @Override
    public String toString() {
        return "Ship: " +
                "displacement=" + displacement +
                "(tons), length=" + length +
                "m, " + boat + ", " +  super.toString();
    }
}
