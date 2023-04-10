import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FileManager {

    private String filesPath;
    static AtomicLong wordCount, letterCount;


    public FileManager(String filesPath) {
        this.filesPath = filesPath;
        wordCount = new AtomicLong(0);
        letterCount = new AtomicLong(0);
    }


    public double countAverageWordLength() {
        File[] files = new File(filesPath).listFiles();
        List<Thread> fileThreads = new ArrayList<>();
        Thread currentThread;

        // Create file threads and start them
        for (File file : files) {
            currentThread = new Thread(new FileThread(file));
            fileThreads.add(currentThread);
            currentThread.start();
        }

        // Count result after the completion of all threads
        try {
            for (Thread thread : fileThreads) {
                thread.join();
            }
        } catch (InterruptedException ignored) {
        }

        return (double) letterCount.get() / wordCount.get();
    }

}