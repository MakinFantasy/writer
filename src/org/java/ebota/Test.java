package org.java.ebota;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {
    public static void main (String[] args) throws IOException {
        String rootPath = System.getProperty("user.dir") + "/";
        String cfgPath = rootPath + "cfg.properties";

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(cfgPath));
        System.out.println(appProps.getProperty("overwrite"));
    }
}
