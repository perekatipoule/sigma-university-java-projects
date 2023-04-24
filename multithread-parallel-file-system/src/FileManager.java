import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FileManager {

    private File[] files;
    private AtomicLong wordCount, letterCount;

    public FileManager() {}


    public FileManager(String filePath) {
        setFiles(filePath);
    }

    public void setFiles(String filesPath) {

        wordCount = new AtomicLong(0);
        letterCount = new AtomicLong(0);

        // avoid hidden files initialization
        files = new File(filesPath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return !file.isHidden();
            }
        });
    }

    public double countAverageWordLength() {

        List<Thread> fileThreads = new ArrayList<>();
        Thread currentThread;

        // create file threads and start them
        for (File file : files) {
            currentThread = new Thread(new FileThread(file));
            fileThreads.add(currentThread);
            currentThread.start();
        }

        // count result after the completion of all threads
        try {
            for (Thread thread : fileThreads) {
                thread.join();
            }
        } catch (InterruptedException ignored) {
        }

        return (double) letterCount.get() / wordCount.get();
    }


    private class FileThread implements Runnable {
        private File file;

        public FileThread(File file) {
            this.file = file;
        }

        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    line.chars().parallel().forEach(c -> {
                        if (Character.isLetter(c)) {
                            letterCount.incrementAndGet();
                        } else if (c == ' ') {
                            wordCount.incrementAndGet();
                        }
                    });
                    // add last word in line if it is not empty
                    if (!line.equals("")) {
                        wordCount.incrementAndGet();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}