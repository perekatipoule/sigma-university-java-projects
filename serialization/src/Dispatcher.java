import domain.*;
import logic.FileManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dispatcher {
    public static void main(String[] args) {

        // Creating lists and files for serialization
        List<Plane> planes = new ArrayList<>();
        List<Ship> ships = new ArrayList<>();
        planes.add(new Plane(700, 1980, new Engine("Turbojet", 75),
                "Boeing 737", 6000, new Chassis(new Wheel(3, 80),  8)));
        planes.add(new Plane(450, 2007, new Engine("Turboprop", 32),
                "Cessna M-150", 1800, new Chassis(new Wheel(1, 36),  3)));
        planes.add(new Plane(680, 2003, new Engine("Turbofan", 60),
                "Airbus 320", 5000, new Chassis(new Wheel(3, 60),  6)));
        planes.add(new Plane(400, 1998, new Engine("Prop", 24),
                "An-24", 1200, new Chassis(new Wheel(2, 25),  3)));
        ships.add(new Ship(60, 1973, new Engine("Nuclear", 130), 16,
                35, new Boat(20, "Composite")));
        ships.add(new Ship(80, 1999, new Engine("Diesel", 155), 32,
                28, new Boat(27, "Metal")));
        ships.add(new Ship(95, 2003, new Engine("Diesel", 130), 20,
                15, new Boat(45, "Composite")));

        Collections.sort(planes);
        Collections.sort(ships);
        File planesFile = new File("serialization/resultedFiles/PLANES");
        File shipsFile = new File("serialization/resultedFiles/SHIPS");

        // Printing lists before serialization
        System.out.println("Before serialization:");
        System.out.println("Planes:");
        FileManager.printPlanes(planes);
        System.out.println("Ships:");
        FileManager.printShips(ships);
        System.out.println();

        // Serialization
        FileManager.writePlanes(planes, planesFile);
        FileManager.writeShips(ships, shipsFile);

        // Deserialization
        List<Plane> deserializedPlanes = FileManager.readPlanes(planesFile);
        List<Ship> deserializedShips = FileManager.readShips(shipsFile);

        // Printing lists after deserialization
        System.out.println("After deserialization:");
        System.out.println("Planes:");
        FileManager.printPlanes(deserializedPlanes);
        System.out.println("Ships:");
        FileManager.printShips(deserializedShips);

    }
}
