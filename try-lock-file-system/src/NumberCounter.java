import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberCounter implements Runnable {
    private String name;
    private NumberAdder adder;
    private File file;
    private Pattern pattern;
    private Lock lock;

    public NumberCounter(String name, NumberAdder adder, File file, Pattern pattern, Lock lock) {
        this.name = name;
        this.adder = adder;
        this.file = file;
        this.pattern = pattern;
        this.lock = lock;
    }

    public void run() {
        try {
            BufferedReader bR = new BufferedReader(new FileReader(file));
            String temp;
            Matcher matcher;
            int number;
            while ((temp = bR.readLine()) != null) {
                matcher = pattern.matcher(temp);
                while (matcher.find()) {
                    number = Integer.parseInt(matcher.group());
                    addOrLock(number);
                }
            }
            bR.close();
        } catch(IOException ioe) {
            System.out.println("File reading failure");
        }
    }

    public void addOrLock(int number) {
        try {
            while (!lock.tryLock()) {
                System.out.println(name + "LOCKED");
            }
            adder.add(number);
        } finally {
            lock.unlock();
        }
    }

}
