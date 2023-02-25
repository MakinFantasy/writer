package org.java.ebota;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Handler {
    KindaFileWriter fileWriter;
    Scanner scanner;

    public Handler(KindaFileWriter fw, Scanner scan) {
        this.fileWriter = fw;
        this.scanner = scan;
    }


    public void exec() throws IOException {
        try {
            System.out.println("Hey mate, u wanna use me? Sure? Code is pretty bad....Ok, let's start then. So, to run me just type <start>! Or if u need help just write <help>. And type <quit> to finish me.");
            for (;;) {
                String userInput = this.scanner.nextLine();
                if (userInput.equals("start")) {
                    this.fileWriter.start();
                } else if (userInput.equals("help")) {
                    System.out.println("<start> will run the configuration part"
                            + "\n"
                            + "<quit> will stop me"
                            + "\n"
                            + "All new files will be created in this directory"
                            + "\n"
                            + "Every step will be runnig with tips for you, so there is nothing more left to say..."
                    );
                } else if (userInput.equals("quit")) {
                    System.out.println("Bye bye!!!");
                    System.exit(0);
                } else {
                    System.out.println("You're typing smth wrong, Better look at your keyboard...");
                }
            }
        } catch (NoFileFound ex) {
            System.out.println("No file found with this name. We need to create it");
            File file = new File(this.fileWriter.getFilepath());
            file.createNewFile();
            fileWriter.setOverwrite();
        }
    }
}
