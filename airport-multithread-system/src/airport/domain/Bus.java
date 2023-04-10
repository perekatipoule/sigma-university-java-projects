package airport.domain;

import java.util.ArrayList;
import java.util.List;

public class Bus implements Runnable {
    private String driveTo; // 4 cities – “Kalush”, “Kosiv”, “Galych”, “Kolomiya”
    List<Family> families;
    private int capacity, busNumber, passengerCount; // 6 or 7 or 8
    boolean alreadyGo;


    public Bus(int capacity, String driveTo, int busNumber) {
        this.capacity = capacity;
        this.driveTo = driveTo;
        this.busNumber = busNumber;

        this.passengerCount = 0;
        this.families = new ArrayList<>();
        this.alreadyGo = false;
    }

    public void run() {
        System.out.println(this);
    }

    public boolean isNotFull () {
        return capacity > passengerCount && passengerCount!= 0;
    }

    synchronized public String fillBus (Family family) {
        int passengerCountWithCurrentFamily = family.getCount() + passengerCount;

        if (passengerCountWithCurrentFamily < capacity) {
            families.add(family);
            passengerCount += family.getCount();
            return "in process";
        } else if (passengerCountWithCurrentFamily == capacity) {
            families.add(family);
            passengerCount += family.getCount();
            alreadyGo = true;
            return "ready to go";
        } else {
            return "family is too big";
        }

    }

    public String getFamiliesNames () {
        String result = "";
        StringBuffer names = new StringBuffer();
        for (Family family: families) {
            names.append(family.getName() + ", ");
        }
        result = names.toString().trim();
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }


    @Override
    public String toString() {
        return "Bus " + busNumber + " (families: " + getFamiliesNames() + ") is going to " + driveTo;
    }
}
