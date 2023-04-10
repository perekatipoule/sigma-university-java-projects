package logic;
import domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void writeShips(List<Ship> ships, File writingFile) {
        try{
            ObjectOutputStream shipsOos = new ObjectOutputStream(new FileOutputStream(writingFile));
            shipsOos.writeObject(ships);
            shipsOos.flush();
            shipsOos.close();
        } catch(IOException ioe) {
            System.out.println("Ships file writing failure");
        }
    }

    public static List<Ship> readShips(File readingFile) {
        List<Ship> ships = new ArrayList<>();
        try {
            ObjectInputStream shipsOis = new ObjectInputStream(new FileInputStream(readingFile));
            ships = (List<Ship>)shipsOis.readObject();
            shipsOis.close();
        } catch (Exception e) {
            System.out.println("domain.Ship file reading failure");
        }
        return ships;
    }

    public static void writePlanes(List<Plane> planes, File writingFile) {
        // Setting super class fields
        for (Plane plane: planes) {
            plane.setSpeedCopy(plane.getSpeed());
            plane.setProducedYearCopy(plane.getProducеdYear());
            plane.setEngineTypeCopy(plane.getEngine().getType());
            plane.setEnginePowerCopy(plane.getEngine().getPower());
        }
        // Writing to file
        try{
            ObjectOutputStream planesOos = new ObjectOutputStream(new FileOutputStream(writingFile));
            planesOos.writeObject(planes);
            planesOos.flush();
            planesOos.close();
        } catch(IOException ioe) {
            System.out.println("domain.Plane file writing failure");
        }
    }

    public static List<Plane> readPlanes(File readingFile) {
        List<Plane> planes = new ArrayList<>();
        try {
            ObjectInputStream planesOis = new ObjectInputStream(new FileInputStream(readingFile));
            planes = (List<Plane>)planesOis.readObject();
            planesOis.close();
            for (Plane plane: planes) {
                plane.setSpeed(plane.getSpeedCopy());
                plane.setProducеdYear(plane.getProducedYearCopy());
                plane.setEngine(new Engine(plane.getEngineTypeCopy(), plane.getEnginePowerCopy()));
            }
        } catch (Exception e) {
            System.out.println("domain.Plane file reading failure");
        }
        return planes;
    }

    public static void printPlanes(List<Plane> planes) {
        for (Plane plane: planes) {
            System.out.println(plane);
        }
    }

    public static void printShips(List<Ship> ships) {
        for (Ship ship: ships) {
            System.out.println(ship);
        }
    }
}
