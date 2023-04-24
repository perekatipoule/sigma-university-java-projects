public class NumberAdder {
    private long numbersCount;

    public NumberAdder() {
        this.numbersCount = 0;
    }

    public void add(int number) {
        numbersCount += number;
    }

    public String toString() {
        return "Sum of numbers in three files - " + numbersCount;
    }
}
