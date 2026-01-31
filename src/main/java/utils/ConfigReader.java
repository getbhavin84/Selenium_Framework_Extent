package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    static {
        try {
            prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
