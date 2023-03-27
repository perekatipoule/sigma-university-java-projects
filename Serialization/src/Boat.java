public class Boat {
    private int passengerNumber;
    private String material;

    public Boat(int passengerNumber, String material) {
        this.passengerNumber = passengerNumber;
        this.material = material;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "passengerNumber=" + passengerNumber +
                ", material='" + material + '\'' +
                '}';
    }
}
