import org.java.ebota.KindaFileWriter;

public class Main {
    public static void main(String[] args){

        KindaFileWriter noOverwriteFirst = new KindaFileWriter("noOverwrite.txt", false);
        KindaFileWriter noOverwriteSecond = new KindaFileWriter("noOverwrite.txt", false);
        KindaFileWriter overWriteFirst = new KindaFileWriter("overwrite.txt", true);
        KindaFileWriter overWriteSecond = new KindaFileWriter("overwrite.txt", true);
        KindaFileWriter[] workers = {noOverwriteFirst, noOverwriteSecond, overWriteFirst, overWriteSecond};

        for (KindaFileWriter instance : workers) {
            instance.write();
        }
    }
}