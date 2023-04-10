package airport.logic;


import airport.domain.Family;
import airport.domain.Plane;

import java.util.Iterator;
import java.util.List;

public class PlaneOperator implements Runnable {
    private Plane plane;
    private BusOperator busOperator;


    public PlaneOperator(Plane plane, BusOperator busOperator) {
        this.plane = plane;
        this.busOperator = busOperator;
    }

    public void run() {
        operatePlane();
    }

    public void operatePlane() {
        List<Family> planeFamilies = plane.getFamilies();
        Iterator<Family> iter = planeFamilies.iterator();
        Family family;

        // Put all families on their buses
        while (planeFamilies.size() > 0) {
            while (iter.hasNext()) {
                family = iter.next();
                if (busOperator.putFamilyOnBus(family)) {
                    iter.remove();
                }
            }
            iter = planeFamilies.iterator();
        }
    }

}
