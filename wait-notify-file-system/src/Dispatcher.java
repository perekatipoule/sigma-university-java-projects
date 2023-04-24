import domain.CustomFile;
import logic.MultiThreadFileHandler;
import logic.WaitNotifyFileHandler;

import java.io.File;

public class Dispatcher {

    public static void main(String[] args) throws InterruptedException{

        // Wait-Notify system
        // Also you can specify your file folder path here
        String waitNotifyFilePath = "wait-notify-file-system/files-for-waitnotify";
        CustomFile[] waitNotifyFiles = new CustomFile(waitNotifyFilePath).listFiles();
        WaitNotifyFileHandler waitNotifyHandler = new WaitNotifyFileHandler(waitNotifyFiles);

        long waitNotifyStart = System.nanoTime();
        waitNotifyHandler.execute();
        long waitNotifyStop = System.nanoTime();

        System.out.println("Wait-Notify system time: " + (waitNotifyStop - waitNotifyStart));


        // Multithread system
/*        String multiFilePath = "wait-notify-file-system/files-for-multithread";
        CustomFile[] multiFiles = new CustomFile(multiFilePath).listFiles();
        MultiThreadFileHandler multiHandler = new MultiThreadFileHandler(multiFiles);

        long multiStart = System.nanoTime();
        multiHandler.execute();
        long multiStop = System.nanoTime();

        System.out.println("Multi Threads system time: " + (multiStop - multiStart));

*/

    }
}