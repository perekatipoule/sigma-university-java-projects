package airport.domain;

public class Family {
    String name; // twoLetters “aa”, “ab”, ..., “zz” – for example, up to 100 names
    String travelTo; // 4 cities – “Kalush”, “Kosiv”, “Galych”, “Kolomiya”
    int count; // family members count, from 1 to 4 members

    public Family(String name, String travelTo, int count) {
        this.name = name;
        this.travelTo = travelTo;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTravelTo() {
        return travelTo;
    }

    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
