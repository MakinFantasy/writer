package org.java.ebota;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.FileOutputStream;
public class KindaFileWriter {
    String filepath;
    boolean overwrite;

    public KindaFileWriter (String filepath, boolean overwrite) {
        this.filepath = filepath;
        this.overwrite = overwrite;
    }

    public void write () {
        if (this.overwrite) {
            System.out.println("File will be overwritten." + "\n" + "Enter your message, every new line will written to file. To stop writing enter EOF " );
            try (FileOutputStream fos = new FileOutputStream(this.filepath, false)) {
                Scanner scanner = new Scanner(System.in);
                for (;;) {
                    String input = scanner.nextLine();
                    if (input.equals("EOF")) {
                        System.out.println("Writing stopped");
                        break;
                    } else {
                        fos.write(input.getBytes());
                        fos.write("\n".getBytes());
                    }

                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("File will not be overwritten." + "\n" + "Enter your message, every new line will written to file. To stop writing enter EOF " );
            try (FileOutputStream fos = new FileOutputStream(this.filepath, true)) {
                Scanner scanner = new Scanner(System.in);
                for (;;) {
                    String input = scanner.nextLine();
                    if (input.equals("EOF")) {
                        System.out.println("Writing stopped");
                        break;
                    } else {
                        fos.write(input.getBytes());
                        fos.write("\n".getBytes());
                    }

                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
