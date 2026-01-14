import goit.edu.client.ClientDao;
import goit.edu.client.ClientDaoHibernateImpl;
import goit.edu.client.ClientService;
import goit.edu.client.ClientServiceImpl;
import goit.edu.planet.PlanetDao;
import goit.edu.planet.PlanetDaoHibernateImpl;
import goit.edu.planet.PlanetService;
import goit.edu.planet.PlanetServiceImpl;
import goit.edu.utils.DBInitializer;
import goit.edu.utils.HibernateUtil;
import goit.edu.utils.PropertiesLoader;
import goit.edu.utils.SessionExecutor;
import org.hibernate.SessionFactory;

import java.util.Properties;

public class SpaceTravelApp {
    public static void main(String[] args) {
        Properties properties = PropertiesLoader.loadProperties("hibernate.properties");
        DBInitializer.initDB(properties);
        SessionFactory factory = HibernateUtil.getSessionFactory(properties);
        SessionExecutor sessionExecutor = new SessionExecutor(factory);
        ClientDao clientDao = new ClientDaoHibernateImpl(sessionExecutor);
        ClientService clientService = new ClientServiceImpl(clientDao);
        PlanetDao planetDao = new PlanetDaoHibernateImpl(sessionExecutor);
        PlanetService planetService = new PlanetServiceImpl(planetDao);

        planetService.getAllPlanets().forEach(System.out::println);
        try {
            planetService.savePlanet("NEP", "Neptun");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        planetService.getAllPlanets().forEach(System.out::println);
        try {
            planetService.deletePlanet("NEP");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        planetService.getAllPlanets().forEach(System.out::println);

        factory.close();
    }
}
