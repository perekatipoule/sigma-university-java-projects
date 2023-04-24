package domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomFile extends File {

    private boolean isChecked;

    public CustomFile(String pathname) {
        super(pathname);
        isChecked = false;
    }

    public boolean isChecked() {
        return isChecked;
    }


    public long countSpaces() {
        int count = 0;
        try {
            BufferedReader bR = new BufferedReader(new FileReader(this));
            String temp;
            Pattern pattern = Pattern.compile("\\s");
            Matcher matcher;
            while ((temp = bR.readLine()) != null) {
                matcher = pattern.matcher(temp);
                while (matcher.find()) {
                    count++;
                }
            }
            bR.close();
            isChecked = true;
            return count;
        } catch(IOException ioe) {
            System.out.println("File reading failure");
            return -1;
        }
    }


    public void capitalizeFirstLetter() {
        try {
            File tempFile = new File(this.getPath() + "temp");
            BufferedReader bR = new BufferedReader(new FileReader(this));
            PrintWriter pR = new PrintWriter(tempFile);
            String temp;
            String[] words;
            while ((temp = bR.readLine()) != null) {
                words = temp.split("\\s+");
                if (words.length > 0) {
                    // Create paragraph and avoid IndexOutOfBoundsException
                    if (words[0].equals("")) {
                        words[0] = "     ";
                    }
                    for (String word : words) {
                        pR.print(word.substring(0, 1).toUpperCase() + word.substring(1) + " ");
                    }
                    pR.println();
                } else {
                    // Leave an empty line if there was one
                    pR.println();
                }
            }
            bR.close();
            pR.flush();
            pR.close();
            tempFile.renameTo(this);
        } catch(IOException ioe) {
            System.out.println("File reading failure");
        }
    }


    public void capitalizeLastLetter() {
        try {
            File tempFile = new File(this.getPath() + "temp");
            BufferedReader bR = new BufferedReader(new FileReader(this));
            PrintWriter pR = new PrintWriter(tempFile);
            String temp;
            String[] words;
            int wordLength;
            while ((temp = bR.readLine()) != null) {
                words = temp.split("\\s+");
                if (words.length > 0) {
                    // Create paragraph and avoid IndexOutOfBoundsException
                    if (words[0].equals("")) {
                        words[0] = "     ";
                    }
                    for (String word : words) {
                        wordLength = word.length();
                        pR.print(word.substring(0, wordLength - 1) + word.substring(wordLength - 1).toUpperCase() + " ");
                    }
                    pR.println();
                } else {
                    // Leave an empty line if there was one
                    pR.println();
                }
            }
            bR.close();
            pR.flush();
            pR.close();
            tempFile.renameTo(this);
        } catch(IOException ioe) {
            System.out.println("File reading failure");
        }
    }

    @Override
    public CustomFile[] listFiles() {
        File[] files = super.listFiles();
        if (files == null) {
            return null;
        }

        List<CustomFile> result = new ArrayList<>();
        for (File file: files) {
            if (!file.isHidden()) {
                result.add(new CustomFile(file.getPath()));
            }
        }

        return result.toArray(new CustomFile[result.size()]);
    }


}
