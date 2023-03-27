package airport.domain_generator;


import airport.domain.Bus;
import airport.domain.Family;
import airport.domain.Plane;

import java.util.*;

public class Generator{

    private final static String[] cities;
    private static final Random rand;

    static{
        cities = new String[]{"Kalush", "Kosiv", "Galych", "Kolomiya"};
        rand = new Random();
    }


    public static String[] getCities () {
        return cities;
    }

    public static Bus generateBus(String driveTo , int busNumber) {
        // 6 + rand.nextInt(3)
        return new Bus(20, driveTo, busNumber);
    }

    public static Set<Plane> generatePlanes(int planeCount) {
        Set<Plane> planes = new HashSet<>();
        List<String> familyNames = generateFamilyNames(planeCount);
        List<Family> families;
        String familyName;
        String travelTo;
        int familyMemberCount;
        int passengerCount = 0;
        int familyCount = 0;

        for (int i = 0; i < planeCount; i++) {
            families = new ArrayList<>();
            while (passengerCount < 100) {
                familyName = familyNames.get(familyCount);
                travelTo =  cities[rand.nextInt(4)]; //rand.nextInt(4)
                //1 + rand.nextInt(4)
                familyMemberCount = 10;

                // Fill each plane by 100 passengers
                if (passengerCount + familyMemberCount < 100) {
                    familyCount++;
                    passengerCount += familyMemberCount;
                    families.add(new Family(familyName, travelTo, familyMemberCount));
                } else if (passengerCount + familyMemberCount == 100) {
                    familyCount++;
                    passengerCount += familyMemberCount;
                    families.add(new Family(familyName, travelTo, familyMemberCount));
                }
            }
            planes.add(new Plane(families, i + 1));
            passengerCount = 0;
        }
        return planes;
    }



    private static List<String> generateFamilyNames(int planeCount) {
        Set<String> names = new HashSet<>();
        String name;
        int count = 0;
        int nameCount = planeCount*100;

        while (count < nameCount) {
            char letter1 = (char) (rand.nextInt(26) + 'a');
            char letter2 = (char) (rand.nextInt(26) + 'a');
            name = letter1 + String.valueOf(letter2);
            // Add string to set if it doesn't already exist
            if (!names.contains(name)) {
                names.add(name);
                count++;
            }
        }
        return new ArrayList<>(names);
    }


}
