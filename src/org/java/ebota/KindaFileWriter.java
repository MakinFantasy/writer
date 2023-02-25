package org.java.ebota;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class KindaFileWriter {
    String filepath;
    boolean overwrite;
    Scanner scanner;

    public KindaFileWriter(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getFilepath () {
        return this.filepath;
    }


    public void setFilepath () {
        System.out.println("Pls, enter the filepath: ");
            this.filepath = this.scanner.nextLine();
            File file = new File(this.filepath);
            if (!file.exists()) {
                throw new NoFileFound("File doesn't exist!");
            } else {
                setOverwrite();
            }
    }

    public boolean checkFile () {
        try (FileInputStream fis = new FileInputStream(this.filepath)) {
            if (!(fis.readAllBytes().length == 0)){
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void setOverwrite () {
        if (checkFile()) {
            System.out.println("Do you want to overwrite it? Enter y/n");
            String ow = this.scanner.nextLine();
            if (ow.equals("y")) {
                this.overwrite = true;
                writeToFile();
            } else if (ow.equals("n")){
                this.overwrite = false;
                writeToFile();
            } else {
                System.out.println("You're typing smth wrong, better look at your keyboard...try once more" + "\n");
                setOverwrite();
            }
        } else {
            writeToFile();
        }

    }

    public void writeToFile() {
        System.out.println("Write down anything u want. Every new line will be written, so to stop it type <EOF>");
        if (this.overwrite) {
            try (FileOutputStream fis = new FileOutputStream(this.filepath, false)) {
                for (;;) {
                    String userInput = this.scanner.nextLine();
                    if (!userInput.equals("EOF")) {
                        fis.write(userInput.getBytes());
                        fis.write("\n".getBytes());
                    } else {
                        System.out.println("End of writing. If u wanna continue type <start> again!");
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (FileOutputStream fos = new FileOutputStream(this.filepath, true)) {
                for (;;) {
                    String userInput = scanner.nextLine();
                    if (!userInput.equals("EOF")) {
                        fos.write(userInput.getBytes());
                        fos.write("\n".getBytes());
                    } else {
                        System.out.println("End of writing. If u wanna continue type <start> again!");
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void cat() {
        System.out.println("Data from file will be printed below: ");
        try (FileInputStream fis = new FileInputStream(this.filepath)) {
            String text = new String(fis.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(text);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start () {
        setFilepath();
    }

}
