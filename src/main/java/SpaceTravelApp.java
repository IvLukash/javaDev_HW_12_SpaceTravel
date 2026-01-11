import goit.edu.client.ClientCrudService;
import goit.edu.planet.PlanetCrudService;
import goit.edu.settings.DBInitializer;
import goit.edu.settings.HibernateUtil;
import org.hibernate.SessionFactory;

public class SpaceTravelApp {
    public static void main(String[] args) {
        DBInitializer.initDB();
        SessionFactory factory = HibernateUtil.getFactory();
        ClientCrudService clientService = new ClientCrudService(factory);
        PlanetCrudService planetService = new PlanetCrudService(factory);

        clientService.getAllClients().forEach(System.out::println);
        System.out.println("**********");
        planetService.getAllPlanets().forEach(System.out::println);

        HibernateUtil.shutdown();
    }
}
