import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileThread implements Runnable {
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
                        FileManager.letterCount.incrementAndGet();
                    } else if (c == ' ') {
                        FileManager.wordCount.incrementAndGet();
                    }
                });
                // add last word in line if it is not empty
                if (!line.equals("")) {
                    FileManager.wordCount.incrementAndGet();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
