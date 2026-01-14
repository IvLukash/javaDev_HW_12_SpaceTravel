package goit.edu.planet;

import goit.edu.utils.SessionExecutor;

import java.util.List;
import java.util.Optional;

public class PlanetDaoHibernateImpl implements PlanetDao {
    private final SessionExecutor sessionExecutor;

    public PlanetDaoHibernateImpl(SessionExecutor sessionExecutor) {
        this.sessionExecutor = sessionExecutor;
    }

    @Override
    public Optional<Planet> getById(String id) {
       return sessionExecutor.read(session ->
               Optional.ofNullable(session.find(Planet.class, id)));
    }

    @Override
    public List<Planet> getAll() {
        return sessionExecutor.read(session ->
                session.createQuery("from Planet order by id", Planet.class).list());
    }

    @Override
    public Planet save(Planet planet) {
        return sessionExecutor.writeWithReturn(session -> {
           session.persist(planet);
           return planet;
        });
    }

    @Override
    public void update(Planet planet) {
        sessionExecutor.writeWithoutReturn(session ->
                session.merge(planet));
    }

    @Override
    public void delete(Planet planet) {
        sessionExecutor.writeWithoutReturn(session ->
                session.remove(planet));
    }
}
