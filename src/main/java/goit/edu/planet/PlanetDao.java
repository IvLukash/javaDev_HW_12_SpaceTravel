package goit.edu.planet;

import goit.edu.client.Client;

import java.util.List;
import java.util.Optional;

public interface PlanetDao {
    Optional<Planet> getById(String id);
    List<Planet> getAll();
    Planet save(Planet planet);
    void update(Planet planet);
    void delete(Planet planet);
}
