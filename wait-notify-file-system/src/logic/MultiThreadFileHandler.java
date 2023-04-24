package logic;

import domain.CustomFile;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadFileHandler {
    private List<Thread> fileThreads;

    public MultiThreadFileHandler(CustomFile[] files) {
        init(files);
    }

    private void init(CustomFile[] files) {

        fileThreads = new ArrayList<>();
        Thread currentThread;

        // Create thread for each file
        for (CustomFile file : files) {
            currentThread = new Thread(() -> {
                if (file.countSpaces()%2 == 0) {
                    file.capitalizeFirstLetter();
                } else {
                    file.capitalizeLastLetter();
                }
            });
            fileThreads.add(currentThread);
        }
    }

    public void execute() throws InterruptedException{

        for (Thread thread: fileThreads) {
            thread.start();
        }
        for (Thread thread : fileThreads) {
            thread.join();
        }
    }

}
