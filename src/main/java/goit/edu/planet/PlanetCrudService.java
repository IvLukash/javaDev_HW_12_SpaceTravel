package goit.edu.planet;

import goit.edu.exception.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PlanetCrudService {
    SessionFactory factory;

    public PlanetCrudService(SessionFactory factory) {
        this.factory = factory;
    }

    public Planet getPlanetById(String id) throws EntityNotFoundException {
        try (Session session = factory.openSession()) {
            Planet planet =  session.find(Planet.class, id);
            if (planet == null) {
                throw new EntityNotFoundException("Planet with id " + id + " not found");
            }
            return planet;
        }
    }

    public List<Planet> getAllPlanets() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

    public Planet savePlanet(Planet planet) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(planet);
            session.getTransaction().commit();
        }
        return planet;
    }

    public void updatePlanet(String id, String newName) throws EntityNotFoundException {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Planet planet = session.find(Planet.class, id);
            if (planet == null) {
                throw new EntityNotFoundException("Planet with id " + id + " not found");
            }
            planet.setName(newName);
            session.getTransaction().commit();
        }
    }

    public void deletePlanet(String id) throws EntityNotFoundException {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Planet planet = session.find(Planet.class, id);
            if (planet == null) {
                throw new EntityNotFoundException("Planet with id " + id + " not found");
            }
            session.remove(planet);
            session.getTransaction().commit();
        }
    }
}
