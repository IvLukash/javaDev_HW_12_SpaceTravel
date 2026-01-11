package goit.edu.settings;

import goit.edu.client.Client;
import goit.edu.planet.Planet;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @Getter
    private static final SessionFactory factory;
    private static final StandardServiceRegistry serviceRegistry;

    static {
        var properties = PropertiesLoader.loadProperties("hibernate.properties");
        var configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Planet.class);

        serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        factory = configuration.buildSessionFactory(serviceRegistry);
    }

    private HibernateUtil() {}

    public static void shutdown() {
        factory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
}
