import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class Dispatcher {

    public static void main(String[] args) throws InterruptedException{

        // initialize our files
        // also you can specify the path to your files here
        File firstFile = new File("try-lock-file-system/files/FileA.txt");
        File secondFile = new File("try-lock-file-system/files/FileB.txt");
        File thirdFile = new File("try-lock-file-system/files/FileC.txt");

        // initialize variables needed to start threads
        Pattern pattern = Pattern.compile("\\d");
        Lock lock = new ReentrantLock();
        NumberAdder adder = new NumberAdder();

        // create threads for file number counting
        Thread firstThread = new Thread(new NumberCounter("firstThread", adder, firstFile, pattern, lock));
        Thread secondThread = new Thread(new NumberCounter("secondThread", adder, secondFile, pattern, lock));
        Thread thirdThread = new Thread(new NumberCounter("thirdThread", adder, thirdFile, pattern, lock));

        // start threads
        firstThread.start(); secondThread.start(); thirdThread.start();
        firstThread.join(); secondThread.join(); thirdThread.join();

        // print result
        System.out.println(adder);
    }


}

