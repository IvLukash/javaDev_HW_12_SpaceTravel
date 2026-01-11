package goit.edu.settings;

import org.flywaydb.core.Flyway;

public class DBInitializer {

    public static void initDB() {
        var properties = PropertiesLoader.loadProperties("hibernate.properties");

        var flyway = Flyway
                .configure()
                .dataSource(properties.getProperty("hibernate.connection.url"),
                        properties.getProperty("hibernate.connection.username"),
                        properties.getProperty("hibernate.connection.password")
                ).load();
        flyway.migrate();
    }
}
