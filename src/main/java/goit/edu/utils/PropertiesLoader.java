package goit.edu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream is = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {
            if (is == null) {
                throw new RuntimeException("File not found");
            }
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
        return properties;
    }

    private PropertiesLoader() {}
}
