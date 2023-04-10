package airport.domain;

import java.util.List;

public class Plane {
    List<Family> families; // exactly 100 family members
    int id; // exactly 1, 2, 3

    public Plane(List<Family> families, int id) {
        this.families = families;
        this.id = id;
    }

    public List<Family> getFamilies() {
        return families;
    }

}