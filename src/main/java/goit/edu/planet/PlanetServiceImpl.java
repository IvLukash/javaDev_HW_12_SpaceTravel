package goit.edu.planet;

import goit.edu.exception.InvalidArgumentException;
import goit.edu.exception.NotFoundException;

import java.util.List;

public class PlanetServiceImpl implements PlanetService {
    private final PlanetDao planetDao;

    public PlanetServiceImpl(PlanetDao planetDao) {
        this.planetDao = planetDao;
    }

    @Override
    public Planet getPlanetById(String id) throws NotFoundException {
        return planetDao.getById(id).orElseThrow(
                () -> new NotFoundException("Planet with id " + id + " not found")
        );
    }

    @Override
    public List<Planet> getAllPlanets() {
        return planetDao.getAll();
    }

    @Override
    public Planet savePlanet(String id, String name) throws InvalidArgumentException {
        if (id == null || id.isEmpty() || id.length() > 10) {
            throw new InvalidArgumentException("Planet id length should be between 1 and 10 symbols");
        }
        if (!(id.matches("^[A-Z0-9]+$"))) {
            throw new InvalidArgumentException("Planet id can contain only big letters and numbers");
        }
        if (name == null || name.isEmpty() || name.length() > 500) {
            throw new InvalidArgumentException("Planet name length should be between 1 and 500 symbols");
        }
        Planet planet = new Planet(id, name);
        return planetDao.save(planet);
    }

    @Override
    public void updatePlanet(String id, String newName) throws InvalidArgumentException, NotFoundException {
        if (newName == null || newName.isEmpty() || newName.length() > 500) {
            throw new InvalidArgumentException("Planet name length should be between 1 and 500 symbols");
        }
        Planet planet = getPlanetById(id);
        planet.setName(newName);
        planetDao.update(planet);
    }

    @Override
    public void deletePlanet(String id) throws NotFoundException {
        Planet planet = getPlanetById(id);
        planetDao.delete(planet);
    }
}
