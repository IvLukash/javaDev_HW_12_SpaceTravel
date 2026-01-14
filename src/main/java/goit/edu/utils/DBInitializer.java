package goit.edu.utils;

import org.flywaydb.core.Flyway;

import java.util.Properties;

public class DBInitializer {

    public static void initDB(Properties properties) {
        Flyway.configure()
                .dataSource(
                        properties.getProperty("hibernate.connection.url"),
                        properties.getProperty("hibernate.connection.username"),
                        properties.getProperty("hibernate.connection.password")
                )
                .load()
                .migrate();
    }
}
