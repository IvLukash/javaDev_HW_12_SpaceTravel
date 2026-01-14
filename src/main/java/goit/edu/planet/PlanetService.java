package goit.edu.planet;

import goit.edu.exception.InvalidArgumentException;
import goit.edu.exception.NotFoundException;

import java.util.List;

public interface PlanetService {
    Planet getPlanetById(String id)  throws NotFoundException;
    List<Planet> getAllPlanets();
    Planet savePlanet(String id, String name) throws InvalidArgumentException;
    void updatePlanet(String id, String newName) throws NotFoundException, InvalidArgumentException;
    void deletePlanet(String id) throws NotFoundException;
}
