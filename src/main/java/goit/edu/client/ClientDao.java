package goit.edu.client;

import java.util.List;
import java.util.Optional;

public interface ClientDao {
    Optional<Client> getById(Long id);
    List<Client> getAll();
    Client save(Client client);
    void update(Client client);
    void delete(Client client);
}
