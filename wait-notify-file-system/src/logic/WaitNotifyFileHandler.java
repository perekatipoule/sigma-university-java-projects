package logic;

import domain.CustomFile;

public class WaitNotifyFileHandler {

    CustomFile[] files;
    Thread counterThread;
    Thread modifierThread;

    public WaitNotifyFileHandler(CustomFile[] files) {
        this.files = files;

        counterThread = new Thread(() -> {
            for (CustomFile file: files) {
                countSpace(file);
            }
        });

        modifierThread = new Thread(() -> {
            for (CustomFile file: files) {
                changeLetters(file);
            }
        });
    }


    synchronized private void changeLetters(CustomFile file) {
        while (!file.isChecked()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

        if (file.countSpaces() % 2 == 0) {
            file.capitalizeFirstLetter();
        } else {
            file.capitalizeLastLetter();
        }
     //   System.out.println("Changed: " + file.getName());
    }

    synchronized private void countSpace(CustomFile file) {
        file.countSpaces();
     //   System.out.println("Checked: " + file.getName()); //
        notify();
    }

    public void execute() throws InterruptedException{
        counterThread.start();
        modifierThread.start();

        counterThread.join();
        modifierThread.join();
    }

}