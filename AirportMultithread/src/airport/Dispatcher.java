package airport;

import airport.domain.Plane;
import airport.domain_generator.Generator;
import airport.logic.BusOperator;
import airport.logic.PlaneOperator;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;


public class Dispatcher {
    public static void main(String[] args) throws InterruptedException{
        Set<Plane> planes = Generator.generatePlanes(3);
        List<Thread> threads = new ArrayList<>();
        BusOperator busOperator = new BusOperator();
        for (Plane plane: planes) {
            threads.add(new Thread(new PlaneOperator(plane, busOperator)));
        }
        for(Thread thread: threads) {
            thread.start();
        }
        for(Thread thread: threads) {
            thread.join();
        }
        busOperator.runLastBuses();
    }
}
