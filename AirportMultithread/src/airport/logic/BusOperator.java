package airport.logic;


import airport.domain.Bus;
import airport.domain.Family;
import airport.domain_generator.Generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BusOperator {
    private final Map<String, List<Bus>> busBase;
    private final AtomicInteger busNumber;

    public BusOperator() {
        busBase = new HashMap<>();
        busNumber = new AtomicInteger(0);
        addPrimaryBuses();
    }

    public Map<String, List<Bus>> getBusBase() {
        return busBase;
    }

    public int addBusNumber() {
        return busNumber.incrementAndGet();
    }

    public boolean putFamilyOnBus(Family family) {
        String city = family.getTravelTo();
        boolean result = false;
        List<Bus> allBusesToCity = getBusBase().get(city);
        Bus busOnStation = allBusesToCity.get(allBusesToCity.size() - 1);

        //  Put the family on the bus
        switch (busOnStation.fillBus(family)){
            case "ready to go":
                // Bus with current family go to city and new Bus is coming to station
                new Thread(busOnStation).start();
                allBusesToCity.add(Generator.generateBus(city, addBusNumber()));
                getBusBase().put(city, allBusesToCity);
                result = true;
                break;
            case "in process":
                result = true;
                break;
        }
        return result;
    }


    public void runLastBuses() {
        List<Bus> cityBuses;
        Bus busOnStation;
        for (String city: busBase.keySet()) {
            cityBuses = busBase.get(city);
            busOnStation = cityBuses.get(cityBuses.size() - 1);
            if (busOnStation.isNotFull()) {
                new Thread(busOnStation).start();
            }
        }
    }



    private void addPrimaryBuses() {
        List<Bus> primaryBus;
        for (String city : Generator.getCities()) {
            primaryBus = new ArrayList<>(List.of(Generator.generateBus(city, addBusNumber())));
            busBase.put(city, primaryBus);
        }
    }
}