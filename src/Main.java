import org.java.ebota.Handler;
import org.java.ebota.KindaFileWriter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("""
                START

         """);
        Scanner scan = new Scanner(System.in);
        KindaFileWriter fw = new KindaFileWriter(scan);
        Handler handler = new Handler(fw, scan);
        handler.exec();
        System.out.println("END");
    }
}