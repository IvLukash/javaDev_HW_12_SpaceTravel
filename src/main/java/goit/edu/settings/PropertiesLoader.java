package goit.edu.settings;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties(String fileName) {
        var properties = new Properties();
        try (var is = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {
            if (is == null) {
                throw new RuntimeException("File " + fileName + " not found");
            }
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
        return properties;
    }

    private PropertiesLoader() {}
}
